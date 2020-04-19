package com.ssm.controller.eChartsModule;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.Role;
import com.ssm.service.RoleService;
import com.ssm.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈宜康
 * @date 2019/3/9 16:38
 * @forWhat
 */
@Controller("/echartsController")
@RequestMapping("/echarts")
public class EchartsController {


    @RequestMapping("/main")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ECharts/echartsIndex.jsp");
        return modelAndView;
    }

}
