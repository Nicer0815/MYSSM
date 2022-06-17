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

import java.util.List;

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

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public MessageAndData updateCustomer(String customerId,String name,String sex,String phoneNum,String discount) {
        Customer customer = new Customer(customerId,name,sex,Integer.parseInt(phoneNum),Integer.parseInt(discount));
        MessageAndData messageAndData;
        Customer temp = customerService.queryById(customerId);
        if(temp != null){
            messageAndData = MessageAndData.success();
            customerService.updateCustomer(customer);
            messageAndData.setMessage("修改顾客信息成功");
        }else {
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("customerId不存在");
        }
        return messageAndData;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public MessageAndData deleteCustomer(String customerId) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        MessageAndData messageAndData;
        Customer temp = customerService.queryById(customerId);
        if(temp != null){
            messageAndData = MessageAndData.success();
            customerService.deleteCustomer(customer);
            messageAndData.setMessage("删除顾客成功");
        }else {
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("customerId不存在");
        }
        return messageAndData;
    }


    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public MessageAndData queryByName(String name) {
        MessageAndData messageAndData;
        List<Customer> list = customerService.queryByName(name);
        if(list == null){
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("查无此人");
        }else{
            messageAndData = MessageAndData.success();
            messageAndData.setMessage("找到了");
            messageAndData.add("list",list);
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
