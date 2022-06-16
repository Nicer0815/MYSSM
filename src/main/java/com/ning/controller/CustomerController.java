package com.ning.controller;

import com.ning.dao.CustomerMapper;
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

    //基本结构建立完毕，/xxx/all 对应xxx.queryAll() 返回对应json
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MessageAndData queryAll() {
        System.out.println(customerService);
        System.out.println(customerService.queryAll());
        MessageAndData messageAndData = MessageAndData.success();
        messageAndData.add("list",customerService.queryAll()).setMessage("返回customer列表");
        return messageAndData;
    }

}
