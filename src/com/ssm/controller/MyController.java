package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.pojo.PageParams;
import com.ssm.pojo.Role;
import com.ssm.pojo.RoleParams;
import com.ssm.service.ExcelExportService;
import com.ssm.service.RoleService;
import com.ssm.view.ExcelView;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author 陈宜康
 * @date 2019/3/9 16:38
 * @forWhat
 */
@Controller("/myController")
@RequestMapping("/my")
public class MyController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jsp/index.jsp");
        return modelAndView;
    }

    /**
     * 跳转到layui测试页面
     *
     * @return
     */
    @RequestMapping("/layuiTest")
    public ModelAndView layuiTest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("layuiExperiment/layui.jsp");
        return modelAndView;
    }


    @RequestMapping("/goToXadmin")
    public ModelAndView goToXadmin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Xadmin/index.jsp");
        return modelAndView;
    }


    @RequestMapping("/testConverter")
    @ResponseBody
    public String testConverter(Role role) {
        return JSON.toJSONString(role);
    }

    /**
     * 测试返回
     *
     * @return
     */
    @RequestMapping(value = "/findUser")
    public String getUser() {
        System.out.println("进来了");
        return "findUser";
    }

    /**
     * 测试接收参数
     *
     * @param: 角色对象
     * @return:
     * @auther: 不用密码的账号
     * @date: 2019/3/12 20:45
     */
    @RequestMapping("/commonParam")
    public ModelAndView commonParam(Role role) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new MappingJackson2JsonView());
        modelAndView.addObject("role", role);
        return modelAndView;
    }


    @RequestMapping("/ModelMap")
    public String ModelMap(ModelMap modelMap) {
        System.out.println("哈哈哈");
        return "jsp/index.jsp";
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView export() {
        //模型和视图
        ModelAndView mv = new ModelAndView();
        //Excel视图，并设置自定义导出接口
        ExcelView ev = new ExcelView(exportService());
        //文件名
        ev.setFileName("所有角色.xlsx");
        //设置SQL后台参数
        RoleParams roleParams = new RoleParams();
        //限制1万条
        PageParams page = new PageParams();
        page.setStart(0);
        page.setLimit(10000);
        roleParams.setPageParams(page);
        //查询
        List<Role> roleList = Arrays.asList(roleService.selectRole("100"));
        //加入数据模型
        mv.addObject("roleList", roleList);
        mv.setView(ev);
        return mv;
    }

    /**
     * ExcelExportService的makeWorkBook的实现
     *
     * @param:
     * @return:
     * @auther: 不用密码的账号
     * @date: 2019/3/11 20:36
     */
    @SuppressWarnings({"unchecked"})
    private ExcelExportService exportService() {
        //使用Lambda表达式自定义导出excel规则
        return (Map<String, Object> model, Workbook workbook) -> {
            //获取用户列表
            List<Role> roleList = (List<Role>) model.get("roleList");
            //生成Sheet
            Sheet sheet = workbook.createSheet("所有角色");
            //加载标题
            Row title = sheet.createRow(0);
            title.createCell(0).setCellValue("编号");
            title.createCell(1).setCellValue("名称");
            title.createCell(2).setCellValue("备注");
            //便利角色列表，生成一行行的数据
            for (int i = 0; i < roleList.size(); i++) {
                Role role = roleList.get(i);
                int rowIdx = i + 1;
                Row row = sheet.createRow(rowIdx);
                row.createCell(0).setCellValue(role.getId());
                row.createCell(1).setCellValue(role.getRolename());
                row.createCell(2).setCellValue(role.getNote());
            }
        };
    }


}
