package com.ning.controller;
import com.ning.entity.Admin;
import com.ning.service.AdminService;
import com.ning.utils.MessageAndData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


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
    public MessageAndData queryById(String username, String password, String remember,HttpSession session) {
        System.out.println(adminService);
        System.out.println(username);
        System.out.println(adminService.queryById(username));
        Admin admin = adminService.queryById(username);
        MessageAndData messageAndData;
        if(admin == null){
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("查无此人");
            return messageAndData;
        }

        if(admin.getPassword().equals(password)){
            messageAndData = MessageAndData.success();
            messageAndData.add("admin",admin).setMessage("密码正确");
            session.setAttribute("admin",admin);
        }else{
            messageAndData = MessageAndData.error();
            messageAndData.setMessage("密码错误");
        }
        return messageAndData;
    }
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public MessageAndData getAdmin(HttpSession session){
        MessageAndData messageAndData;
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null){
            messageAndData=MessageAndData.error();
            messageAndData.setMessage("您还未登录");
        }else{
            messageAndData = MessageAndData.success();
            messageAndData.add("admin",admin);
        }
        return messageAndData;
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public MessageAndData register(String username,String password,String name){
        MessageAndData messageAndData;
        Admin admin = adminService.queryById(username);
        if (admin != null){
            messageAndData=MessageAndData.error();
            messageAndData.setMessage("用户名已存在");
        }else{
            messageAndData = MessageAndData.success();
            messageAndData.setMessage("注册成功");
            admin = new Admin();
            admin.setAdminId(username);
            admin.setName(name);
            admin.setPassword(password);
            admin.setRank("职员");
            adminService.insert(admin);
        }
        return messageAndData;
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public void logout(HttpSession session){
        session.removeAttribute("admin");
    }

}

