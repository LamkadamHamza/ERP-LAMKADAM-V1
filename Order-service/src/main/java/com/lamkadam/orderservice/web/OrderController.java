package com.lamkadam.orderservice.web;


import com.lamkadam.orderservice.dtos.NewOrderDTO;
import com.lamkadam.orderservice.dtos.OrderDTO;
import com.lamkadam.orderservice.entities.Order;
import com.lamkadam.orderservice.enumes.StatusOrder;
import com.lamkadam.orderservice.mappers.OrderMapper;
import com.lamkadam.orderservice.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin("*")
public class OrderController {

    private OrderService orderService;
    private OrderMapper orderMapper;

    @GetMapping("/orders")
    public List<OrderDTO> ListOrder(){

        return   orderService.LISTOrders();
    }

    @GetMapping("/orders/{id}")
    public  OrderDTO GetOrderById(@PathVariable String id){
        OrderDTO orderDTO = orderService.findOrderById(id);
       return  orderDTO;
    }


    @PostMapping(path="/orders", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public OrderDTO savePayment(@RequestParam("Contratfile") MultipartFile Contratfile, NewOrderDTO newOrderDTO
                                ) throws IOException {
       return orderService.saveOrder(Contratfile, newOrderDTO);

    }


    @GetMapping(path="orders/{id}/Contratfile",produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getOrderContratFile(@PathVariable String id) throws IOException {
        return orderService.getOrderContraFile(id);

    }

    @PutMapping("orders/{id}/updateStatus")
    public OrderDTO updateOrderStatus(@RequestParam StatusOrder status, @PathVariable String orderId){
        return orderService.updateOrderStatus(status,orderId);
    }
}
