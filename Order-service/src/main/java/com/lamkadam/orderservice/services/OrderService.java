package com.lamkadam.orderservice.services;

import com.lamkadam.orderservice.dtos.NewOrderDTO;
import com.lamkadam.orderservice.dtos.OrderDTO;
import com.lamkadam.orderservice.entities.Order;
import com.lamkadam.orderservice.enumes.StatusOrder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface OrderService {


    List<OrderDTO>  LISTOrders();

    public  OrderDTO findOrderById(String id);

    public OrderDTO saveOrder(MultipartFile Contratfile, NewOrderDTO newOrderDTO)
                              throws IOException;

    public byte[] getOrderContraFile(String id) throws IOException;

    public OrderDTO updateOrderStatus(StatusOrder status, String orderId);


}
