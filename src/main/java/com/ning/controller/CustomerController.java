package com.ning.controller;

import com.ning.dao.CustomerMapper;
import com.ning.entity.Customer;
import com.ning.service.CustomerService;
import com.ning.utils.MessageAndData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    @Qualifier("customerServiceImpl")
    private CustomerService customerService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MessageAndData queryAll() {
        System.out.println(customerService);
        System.out.println(customerService.queryAll());
        MessageAndData messageAndData = MessageAndData.success();
        messageAndData.add("list",customerService.queryAll()).setMessage("返回customer列表");
        return messageAndData;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public MessageAndData register(String customerId,String name,String sex,String phoneNum,String discount) {
        Customer customer = new Customer(customerId,name,sex,Integer.parseInt(phoneNum),Integer.parseInt(discount));
        MessageAndData messageAndData;
        Customer temp = customerService.queryById(customerId);
        if(temp != null){
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("用户名已存在");
        }else {
            messageAndData = MessageAndData.success();
            customerService.addCustomer(customer);
            messageAndData.setMessage("注册成功");
        }
        return messageAndData;
    }

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public MessageAndData queryById(String customerId) {
        MessageAndData messageAndData;
        Customer customer = customerService.queryById(customerId);
        if(customer == null){
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("查无此人");
        }else{
            messageAndData = MessageAndData.success();
            messageAndData.setMessage("找到了");
            messageAndData.add("customer",customer);
        }
        return messageAndData;
    }


}
