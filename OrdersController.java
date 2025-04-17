package com.restaurant.controller;


import com.restaurant.pojo.Menu;
import com.restaurant.pojo.Orders;
import com.restaurant.service.MenuService;
import com.restaurant.service.OrdersService;
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
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrdersService ordersService;
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = ordersService.findPage(queryPageBean);
        return pageResult;
    }
    @RequestMapping("/saveItem")
    public Result saveItem(@RequestBody Orders orders){
        System.out.println(orders+"====");
        Result result = ordersService.saveItem(orders);
        return result;
    }
    @RequestMapping("/deleteById")
    public Result deleteById(Integer id){
        Result result = ordersService.deleteById(id);
        return result;
    }

    //显示所有的检查项数据
    @RequestMapping("/getAllItemInfo")
    public Result getAllItemInfo(){
        Result result = ordersService.getAllItemInfo();
        return result;
    }

    @RequestMapping("/showOrdersDetailInfo")
    public Result showOrdersDetailInfo(String queryString){
        Result result =  ordersService.showOrdersDetailInfo(queryString);
        return  result;
    }
}

