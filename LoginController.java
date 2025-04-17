package com.restaurant.controller;

import com.restaurant.pojo.Users;
import com.restaurant.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/logins")
public class LoginController {
    @Resource
    private UsersService usersService;
    @RequestMapping("/login")
    public String login(String username,String password) {
        Users users = null;
        try {
            users = usersService.login(username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (users != null) {
            if (users.getRole().equals("admin")) {
                return "redirect:/pages/main.html?id=" + users.getUserid();
            } else if (users.getRole().equals("customer")) {
                return "redirect:/pages/cmain.html?id=" + users.getUserid();
            }else {
                return "redirect:/index.html";
            }
        } else {
            return "redirect:/index.html";
        }
    }
}
