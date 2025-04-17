package com.restaurant.controller;

import com.restaurant.service.ReportService;
import com.restaurant.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Resource
    private ReportService reportService;
//    @RequestMapping("/getBusinessReportData")
//    @ResponseBody
//    public Result getBusinessReportData(){
//        Result result = reportService.getBusinessReportData();
//        return  result;
//    }
    @RequestMapping("/getSetmealReport")
    @ResponseBody
    public Result getSetmealReport(){
        Result result = reportService.getSetmealReport();
        return  result;
    }

}
