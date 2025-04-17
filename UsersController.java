package com.restaurant.controller;


import com.restaurant.pojo.Users;
import com.restaurant.service.UsersService;
import com.restaurant.util.PageResult;
import com.restaurant.util.QueryPageBean;
import com.restaurant.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sdlg
 * @since 2025-01-02
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Resource
    private UsersService usersService;

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = usersService.findPage(queryPageBean);
        return pageResult;
    }
    @RequestMapping("/saveItem")
    public Result saveItem(@RequestBody Users users){
        System.out.println(users+"====");
        Result result = usersService.saveItem(users);

        return result;
    }
    @RequestMapping("/deleteById")
    public Result deleteById(Integer id){
        Result result = usersService.deleteById(id);
        return result;
    }

    //显示所有的检查项数据
    @RequestMapping("/getAllItemInfo")
    public Result getAllItemInfo(){
        Result result = usersService.getAllItemInfo();
        return result;
    }
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

