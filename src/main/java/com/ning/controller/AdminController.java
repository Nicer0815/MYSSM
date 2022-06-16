package com.ning.controller;
import com.ning.entity.Admin;
import com.ning.service.AdminService;
import com.ning.utils.MessageAndData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("adminServiceImpl")
    private AdminService adminService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public MessageAndData queryAll() {
        System.out.println(adminService);
        System.out.println(adminService.queryAll());
        MessageAndData messageAndData = MessageAndData.success();
        messageAndData.add("list",adminService.queryAll()).setMessage("返回admin列表");
        return messageAndData;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public MessageAndData queryById(String uname,String pswd,String remember) {
        System.out.println(adminService);
        System.out.println(uname);
        System.out.println(adminService.queryById(uname));
        Admin admin = adminService.queryById(uname);
        MessageAndData messageAndData;
        if(admin == null){
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("查无此人");
            return messageAndData;
        }
        if(admin.getPassword().equals(pswd)){
            messageAndData = MessageAndData.success();
            messageAndData.add("admin",admin).setMessage("密码正确");
        }else{
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("密码错误");
        }
        return messageAndData;
    }

}

