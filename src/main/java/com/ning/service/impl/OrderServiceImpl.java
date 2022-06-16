package com.ning.service.impl;

import com.ning.dao.OrderMapper;
import com.ning.entity.Order;
import com.ning.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;

    public OrderMapper getOrderMapper() {
        return orderMapper;
    }

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }


    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int deleteOrder(Order order) {
        return orderMapper.deleteOrder(order);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    @Override
    public Order queryById(String orderId) {
        return orderMapper.queryById(orderId);
    }

    @Override
    public List<Order> queryAll() {
        return orderMapper.queryAll();
    }
}
