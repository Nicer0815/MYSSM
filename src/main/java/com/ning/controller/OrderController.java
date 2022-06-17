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
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public MessageAndData queryOrder(String orderId) {
        MessageAndData messageAndData;
        Order temp = orderService.queryById(orderId);
        if(temp != null){
            messageAndData = MessageAndData.success();
            messageAndData.setMessage("订单已查到");
            messageAndData.add("order",temp);

        }else{
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("订单编号不存在");
        }
        return messageAndData;
    }


    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public MessageAndData addOrder(String orderId,String roomId,String checkinDate,String customerId,String price){
        System.out.println("reserveDate:");
        System.out.println("checkinDate:");
        Order order = new Order();
        order.setOrderId(orderId);
        order.setRoomId(roomId);
        order.setCustomerId(customerId);
        order.setPrice(Double.valueOf(price));

        order.setCheckinDate(DateUtils.cstStringToDate(checkinDate));

        //自动生成订单的创建时间
        order.setReserveDate(DateUtils.newDate());
        MessageAndData messageAndData;
        //添加订单

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

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public MessageAndData updateOrder(String orderId,String roomId,String checkinDate,String customerId,String price){
        System.out.println("reserveDate:");
        System.out.println("checkinDate:"+checkinDate);
        Order order = new Order();
        order.setOrderId(orderId);
        order.setRoomId(roomId);
        order.setCustomerId(customerId);
        order.setPrice(Double.valueOf(price));

        order.setCheckinDate(DateUtils.cstStringToDate(checkinDate));

        //自动生成订单的创建时间
        order.setReserveDate(DateUtils.newDate());
        MessageAndData messageAndData;
        //更新订单

        Order temp = orderService.queryById(orderId);
        if(temp != null){
            messageAndData = MessageAndData.success();
            messageAndData.setMessage("订单找到");
            messageAndData.add("order",temp);
            orderService.updateOrder(order);
        }else{
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("未找到订单编号");
        }
        return messageAndData;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public MessageAndData deleteOrder(String orderId){

        Order order = new Order();
        order.setOrderId(orderId);

        MessageAndData messageAndData;
        //更新订单

        Order temp = orderService.queryById(orderId);
        if(temp != null){
            messageAndData = MessageAndData.success();
            messageAndData.setMessage("订单已删除");
            //messageAndData.add("order",temp);
            orderService.deleteOrder(order);
        }else{
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("未找到订单编号");
        }
        return messageAndData;
    }

}
