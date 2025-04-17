package com.restaurant.service;

import com.restaurant.pojo.Menu;
import com.restaurant.util.PageResult;
import com.restaurant.util.QueryPageBean;
import com.restaurant.util.Result;

public interface MenuService {
    PageResult findPage(QueryPageBean queryPageBean);

    Result saveItem(Menu menu);

    Result deleteById(Integer id);

    Result getAllItemInfo();
}
