package com.ning.controller;

import com.ning.entity.Admin;
import com.ning.entity.Checkin;
import com.ning.entity.Order;
import com.ning.entity.Room;
import com.ning.service.*;
import com.ning.utils.DateUtils;
import com.ning.utils.MessageAndData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    @Qualifier("roomServiceImpl")
    private RoomService roomService;

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;

    @Autowired
    @Qualifier("checkinServiceImpl")
    private CheckinService checkinService;

    @Autowired
    @Qualifier("customerServiceImpl")
    private CustomerService customerService;

    @Autowired
    @Qualifier("orderServiceImpl")
    private OrderService orderService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MessageAndData queryAll(HttpSession session) {
        MessageAndData messageAndData = MessageAndData.success();
        Admin admin = (Admin) session.getAttribute("admin");
        messageAndData.add("admin",admin);
        List<Order> orderList = orderService.queryToday();
        Double moneyToday = 0.0;
        for (Order order : orderList) {
            moneyToday+=order.getPrice();
        }
        messageAndData.add("orderToday", orderList.size());
        messageAndData.add("moneyToday", moneyToday);

        List<Room> busyList = roomService.queryBusy();
        List<Room> restList = roomService.queryRest();
        List<Room> fixList = roomService.queryFix();
        int standardBusy = 0;
        int standardRest = 0;
        int standardFix = 0;
        int singleBusy = 0;
        int singleRest = 0;
        int singleFix = 0;
        int bigBedBusy = 0;
        int bigBedRest = 0;
        int bigBedFix = 0;
        int tripleBusy = 0;
        int tripleRest = 0;
        int tripleFix = 0;
        int luxuryBusy = 0;
        int luxuryRest = 0;
        int luxuryFix = 0;
        int standardPrice = 200;
        int singlePrice = 200;
        int bigBedPrice = 200;
        int triplePrice = 200;
        int luxuryPrice = 200;



        for (Room room : busyList) {
            switch (room.getSize()) {
                case "?????????":
                    standardBusy++;
                    break;
                case "?????????":
                    singleBusy++;
                    break;
                case "?????????":
                    bigBedBusy++;
                    break;
                case "?????????":
                    tripleBusy++;
                    break;
                case "????????????":
                    luxuryBusy++;
                    break;
            }
        }
        for (Room room : restList) {
            switch (room.getSize()) {
                case "?????????":
                    standardRest++;
                    standardPrice = room.getPrice();
                    break;
                case "?????????":
                    singleRest++;
                    singlePrice = room.getPrice();
                    break;
                case "?????????":
                    bigBedRest++;
                    bigBedPrice = room.getPrice();
                    break;
                case "?????????":
                    tripleRest++;
                    triplePrice = room.getPrice();
                    break;
                case "????????????":
                    luxuryRest++;
                    luxuryPrice = room.getPrice();
                    break;
            }
        }
        for (Room room : fixList) {
            switch (room.getSize()) {
                case "?????????":
                    standardFix++;
                    break;
                case "?????????":
                    singleFix++;
                    break;
                case "?????????":
                    bigBedFix++;
                    break;
                case "?????????":
                    tripleFix++;
                    break;
                case "????????????":
                    luxuryFix++;
                    break;
            }
        }
        messageAndData.add("standardBusy", standardBusy);
        messageAndData.add("standardRest", standardRest);
        messageAndData.add("standardFix", standardFix);
        messageAndData.add("singleBusy", singleBusy);
        messageAndData.add("singleRest", singleRest);
        messageAndData.add("singleFix", singleFix);
        messageAndData.add("bigBedBusy", bigBedBusy);
        messageAndData.add("bigBedRest", bigBedRest);
        messageAndData.add("bigBedFix", bigBedFix);
        messageAndData.add("tripleBusy", tripleBusy);
        messageAndData.add("tripleRest", tripleRest);
        messageAndData.add("tripleFix", tripleFix);
        messageAndData.add("luxuryBusy", luxuryBusy);
        messageAndData.add("luxuryRest", luxuryRest);
        messageAndData.add("luxuryFix", luxuryFix);
        messageAndData.add("standardPrice", standardPrice);
        messageAndData.add("singlePrice", singlePrice);
        messageAndData.add("bigBedPrice", bigBedPrice);
        messageAndData.add("triplePrice", triplePrice);
        messageAndData.add("luxuryPrice", luxuryPrice);

        List<Checkin> checkinList = checkinService.queryToday(DateUtils.getTodayBegin());
        messageAndData.add("checkinToday",checkinList.size());
        List<Checkin> checkinLeave = checkinService.queryTodayLeave();
        messageAndData.add("leaveToday",checkinLeave.size());
        messageAndData.add("restToday",busyList.size());

        return messageAndData;
    }

}
