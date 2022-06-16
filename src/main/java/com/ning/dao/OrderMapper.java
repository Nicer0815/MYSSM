package com.ning.dao;
import com.ning.entity.Order;

import java.util.Date;
import java.util.List;

public interface OrderMapper {

    int addOrder(Order order);
    int deleteOrder(Order order);//根据orderId
    int updateOrder(Order order);
    Order queryById(String orderId);
    List<Order> queryAll();
    List<Order> queryToday(Date today);
}
