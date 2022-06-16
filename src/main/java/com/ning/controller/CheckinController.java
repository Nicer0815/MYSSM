package com.ning.controller;


import com.ning.service.CheckinService;
import com.ning.utils.MessageAndData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkin")
public class CheckinController {
    @Autowired
    @Qualifier("checkinServiceImpl")
    private CheckinService checkinService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MessageAndData queryAll() {
        System.out.println(checkinService);
        System.out.println(checkinService.queryAll());
        MessageAndData messageAndData = MessageAndData.success();
        messageAndData.add("list",checkinService.queryAll()).setMessage("返回checkin列表");
        return messageAndData;
    }
}
