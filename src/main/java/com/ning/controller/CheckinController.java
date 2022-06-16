package com.ning.controller;


import com.ning.entity.Checkin;
import com.ning.entity.Order;
import com.ning.service.CheckinService;
import com.ning.utils.DateUtils;
import com.ning.utils.MessageAndData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/today",method = RequestMethod.GET)
    public MessageAndData queryToday() {
        System.out.println(checkinService);
        List<Checkin> list = checkinService.queryToday(DateUtils.getTodayBegin());
        System.out.println(list);
        MessageAndData messageAndData = MessageAndData.success();
        messageAndData.add("list",list).setMessage("返回checkin列表");
        return messageAndData;
    }


    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public MessageAndData newCheckin(String checkinId, String roomId, String customerId, String checkinDate, String leaveDate, String state, String number) {
        MessageAndData messageAndData;
        System.out.println("reserveDate:"+leaveDate);
        System.out.println("checkinDate:"+checkinDate);
        //TODO 这里要处理下
        Checkin checkin = new Checkin(checkinId,roomId,customerId,DateUtils.cstStringToDate(checkinDate),
                DateUtils.cstStringToDate(leaveDate),state,Integer.parseInt(number),0);
        checkinService.addCheckin(checkin);
        messageAndData = MessageAndData.success();
        messageAndData.setMessage("创建checkin成功");
        return messageAndData;
    }

}
