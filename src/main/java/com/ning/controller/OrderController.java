package com.ning.controller;
import com.ning.entity.Order;
import com.ning.service.OrderService;
import com.ning.utils.DateUtils;
import com.ning.utils.MessageAndData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;


    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MessageAndData queryAll() {
        System.out.println(orderService);
        System.out.println(orderService.queryAll());
        MessageAndData messageAndData = MessageAndData.success();
        messageAndData.add("list",orderService.queryAll()).setMessage("返回order列表");
        return messageAndData;
    }

    @RequestMapping(value = "/today",method = RequestMethod.GET)
    public MessageAndData queryToday() {
        System.out.println(orderService);
        List<Order> list = orderService.queryToday();
        System.out.println(list);
        MessageAndData messageAndData = MessageAndData.success();
        messageAndData.add("list",list).setMessage("返回order列表");
        return messageAndData;
    }
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public MessageAndData addOrder(String orderId,String roomId,String reserveDate,String checkinDate,String customerId,String price){
        System.out.println("reserveDate:"+reserveDate);
        System.out.println("checkinDate:"+checkinDate);
        Order order = new Order(orderId,roomId,DateUtils.cstStringToDate(reserveDate),DateUtils.cstStringToDate(checkinDate),customerId,Double.valueOf(price));
        MessageAndData messageAndData;
        //添加订单
//        Order order = new Order();
//        order.setOrderId("20220616002");
//        order.setRoomId("101");
//        order.setReserveDate(DateUtils.newDate());
//        order.setCheckinDate(DateUtils.newDate());
//        order.setCustomerId("100001");
//        order.setPrice(180.0);
//        orderService.addOrder(order);
        Order temp = orderService.queryById(orderId);
        if(temp != null){
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("订单编号已存在");
        }else{
            orderService.addOrder(order);
            messageAndData = MessageAndData.success();
            messageAndData.setMessage("创建订单成功");
        }
        return messageAndData;
    }



}
