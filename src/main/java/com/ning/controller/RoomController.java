package com.ning.controller;


import com.ning.service.AdminService;
import com.ning.service.RoomService;
import com.ning.utils.MessageAndData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    @Qualifier("roomServiceImpl")
    private RoomService roomService;


    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MessageAndData queryAll() {
        System.out.println(roomService);
        System.out.println(roomService.queryAll());
        MessageAndData messageAndData = MessageAndData.success();
        messageAndData.add("list",roomService.queryAll()).setMessage("返回room列表");
        return messageAndData;
    }

}
