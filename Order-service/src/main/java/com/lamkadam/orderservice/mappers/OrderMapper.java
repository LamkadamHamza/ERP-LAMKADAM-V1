package com.lamkadam.orderservice.mappers;

import com.lamkadam.orderservice.dtos.OrderDTO;
import com.lamkadam.orderservice.entities.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    ModelMapper modelMapper = new ModelMapper();

    public OrderDTO from(Order order) {return modelMapper.map(order,OrderDTO.class);};

    public  Order from(OrderDTO orderDTO){return  modelMapper.map(orderDTO,Order.class);}
}
