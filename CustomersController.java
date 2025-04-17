package com.restaurant.controller;


import com.restaurant.pojo.Customers;
import com.restaurant.pojo.Users;
import com.restaurant.service.CustomersService;
import com.restaurant.util.PageResult;
import com.restaurant.util.QueryPageBean;
import com.restaurant.util.Result;
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
@RequestMapping("/customers")
public class CustomersController {
    @Resource
    private CustomersService customerService;

    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = customerService.findPage(queryPageBean);
        return pageResult;
    }
    @RequestMapping("/saveItem")
    public Result saveItem(@RequestBody Customers customers){
        System.out.println(customers+"====");
        Result result = customerService.saveItem(customers);

        return result;
    }
    @RequestMapping("/deleteById")
    public Result deleteById(Integer id){
        Result result = customerService.deleteById(id);
        return result;
    }

    //显示所有的检查项数据
    @RequestMapping("/getAllItemInfo")
    public Result getAllItemInfo(){
        Result result = customerService.getAllItemInfo();
        return result;
    }
}

