package com.restaurant.controller;
import com.restaurant.pojo.Menu;
import com.restaurant.service.MenuService;
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
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        PageResult pageResult = menuService.findPage(queryPageBean);
        return pageResult;
    }
    @RequestMapping("/saveItem")
    public Result saveItem(@RequestBody Menu menu){
        System.out.println(menu+"====");
        Result result = menuService.saveItem(menu);
        return result;
    }
    @RequestMapping("/deleteById")
    public Result deleteById(Integer id){
        Result result = menuService.deleteById(id);
        return result;
    }

    //显示所有的检查项数据
    @RequestMapping("/getAllItemInfo")
    public Result getAllItemInfo(){
        Result result = menuService.getAllItemInfo();
        return result;
    }
}

