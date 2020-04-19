package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.Role;
import com.ssm.pojo.YwclCaseVO;
import com.ssm.service.RoleService;
import com.ssm.service.YwclService;
import com.ssm.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈宜康
 * @date 2019/3/9 16:38
 * @forWhat
 */
@Controller("/ywclController")
@RequestMapping("/ywcl")
public class YwclController {

    @Autowired
    private YwclService ywclService;

    /**
     * 测试返回
     *
     * @return
     */
    @RequestMapping(value = "/getList")
    @ResponseBody
    public String getList(String ldzl) {
        List<YwclCaseVO> list = ywclService.getList(ldzl);
        return JSON.toJSONString(list);
    }

}
