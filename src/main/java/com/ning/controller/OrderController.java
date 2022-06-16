package com.ning.controller;


import com.ning.service.OrderService;
import com.ning.utils.MessageAndData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
