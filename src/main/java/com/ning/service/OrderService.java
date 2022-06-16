package com.ning.service;

import com.ning.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {

    int addOrder(Order order);
    int deleteOrder(Order order);//根据orderId
    int updateOrder(Order order);
    Order queryById(String orderId);
    List<Order> queryAll();
}
