package com.lamkadam.orderservice.services;

import com.lamkadam.orderservice.clients.CustomerServiceClient;
import com.lamkadam.orderservice.clients.ProductServiceClient;
import com.lamkadam.orderservice.clients.SiteServiceClient;
import com.lamkadam.orderservice.dtos.NewOrderDTO;
import com.lamkadam.orderservice.dtos.OrderDTO;
import com.lamkadam.orderservice.entities.Order;
import com.lamkadam.orderservice.enumes.StatusOrder;
import com.lamkadam.orderservice.mappers.OrderMapper;
import com.lamkadam.orderservice.modul.Customer;
import com.lamkadam.orderservice.modul.Product;
import com.lamkadam.orderservice.modul.Site;
import com.lamkadam.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@AllArgsConstructor @Service
@Slf4j @Transactional
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private OrderMapper orderMapper;
    private CustomerServiceClient customerServiceClient;
    private ProductServiceClient productServiceClient;
    private SiteServiceClient siteServiceClient;
    @Override
    public List<OrderDTO> LISTOrders() {

      return   orderRepository.findAll().stream().map(orderMapper::from).collect(Collectors.toList());

    }

    @Override
    public OrderDTO findOrderById(String id) {
        Order order = orderRepository.findOrderById(id);
        OrderDTO orderDTO = orderMapper.from(order);
        return orderDTO;
    }

    @Override
    public OrderDTO saveOrder(MultipartFile Contratfile, NewOrderDTO newOrderDTO
                              ) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"),"enset-order","orders");
        if(!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }

        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"),"enset-order","orders",fileName+".pdf");
        Files.copy(Contratfile.getInputStream(),filePath);



        Order order = Order.builder()
                .id(UUID.randomUUID().toString())
                .dateLivrision(newOrderDTO.getDateLivrision())
                .status(newOrderDTO.getStatus())
                .Contratfile(filePath.toUri().toString())
                .IdCustomer(newOrderDTO.getIdCustomer())
                .IdProduct(newOrderDTO.getIdProduct())
                .IdSite(newOrderDTO.getIdSite())
                .build();

      Order ordersaved = orderRepository.save(order);

      OrderDTO orderDTO = orderMapper.from(ordersaved);

        return orderDTO;
    }


    public byte[] getOrderContraFile(String id) throws IOException {
        Order order = orderRepository.findOrderById(id);
        OrderDTO orderDTO =orderMapper.from(order);
        return Files.readAllBytes(Path.of(URI.create(orderDTO.getContratfile())));

    }

    public OrderDTO updateOrderStatus(StatusOrder status, String orderId){
        Order order = orderRepository.findOrderById(orderId);
        order.setStatus(status);

        Order orderUpadet = orderRepository.save(order);

        OrderDTO orderDTO = orderMapper.from(orderUpadet);
        return orderDTO;
    }
}
