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

import java.util.List;

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

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public MessageAndData newRoom(String roomId) {
        MessageAndData messageAndData;
        Room temp = roomService.queryById(roomId);
        if(temp!=null){
            messageAndData = MessageAndData.success();
            messageAndData.setMessage("房间查找到");
            messageAndData.add("room",temp);

        }else {
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("房间号不存在");
        }
        return messageAndData;
    }


    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public MessageAndData updateRoom(String roomId,String size,String state,String price) {
        MessageAndData messageAndData;
        Room room = new Room(roomId,size,state,Integer.parseInt(price));
        Room temp = roomService.queryById(roomId);
        if(temp!=null){
            messageAndData = MessageAndData.success();
            messageAndData.setMessage("房间设立成功");
            roomService.updateRoom(room);

        }else {

            messageAndData = MessageAndData.error();
            messageAndData.setMessage("房间号不存在");
        }
        return messageAndData;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public MessageAndData deleteRoom(String roomId) {
        MessageAndData messageAndData;
        Room room = new Room();
        room.setRoomId(roomId);
        Room temp = roomService.queryById(roomId);
        if(temp!=null){
            messageAndData = MessageAndData.success();
            messageAndData.setMessage("删除房间成功");
            roomService.deleteRoom(room);

        }else {

            messageAndData = MessageAndData.error();
            messageAndData.setMessage("房间号不存在");
        }
        return messageAndData;
    }


    @RequestMapping(value = "/rest",method = RequestMethod.GET)
    public MessageAndData restRoom() {
        MessageAndData messageAndData;

        List<Room> list = roomService.queryRest();
        messageAndData = MessageAndData.success();
        messageAndData.setMessage("获取房间信息成功");
        messageAndData.add("restList",list);
        return messageAndData;
    }


    @RequestMapping(value = "/busy",method = RequestMethod.GET)
    public MessageAndData busyRoom() {
        MessageAndData messageAndData;
        List<Room> busyList = roomService.queryBusy();
        List<Room> fixList = roomService.queryFix();
        messageAndData = MessageAndData.success();
        messageAndData.setMessage("获取房间信息成功");
        messageAndData.add("busyList",busyList);
        messageAndData.add("fixList",fixList);
        return messageAndData;
    }
    //Controller完善，去除多余文件
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public MessageAndData infoRoom() {
        MessageAndData messageAndData;
        List<Room> busyList = roomService.queryBusy();
        List<Room> fixList = roomService.queryFix();
        List<Room> list = roomService.queryRest();
        messageAndData = MessageAndData.success();
        messageAndData.setMessage("获取房间信息成功");
        messageAndData.add("restList",list);
        messageAndData.add("busyList",busyList);
        messageAndData.add("fixList",fixList);
        return messageAndData;
    }

}
