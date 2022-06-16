package com.ning.controller;


import com.ning.entity.Room;
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

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public MessageAndData newRoom(String roomId,String size,String state,String price) {
        MessageAndData messageAndData;
        Room room = new Room(roomId,size,state,Integer.parseInt(price));
        Room temp = roomService.queryById(roomId);
        if(temp!=null){
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("房间号已存在");
        }else {
            roomService.addRoom(room);
            messageAndData = MessageAndData.success();
            messageAndData.setMessage("房间设立成功");
        }
        return messageAndData;
    }
}
