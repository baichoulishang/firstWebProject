package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.Role;
import com.ssm.service.RoleService;
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
@Controller("/roleController")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 测试返回
     *
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(Role role) {
        roleService.insertRole(role);
        System.out.println("插入成功");
        return "findUser";
    }

    /**
     * 得到列表
     *
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public String getList() {
        List<Role> list = roleService.getList("");
        Map<String, List<Role>> listMap = new HashMap<>();
        listMap.put("list", list);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(listMap);
        jsonResult.setState(jsonResult.SUCCESS);
        return JSON.toJSONString(jsonResult);
    }

}
