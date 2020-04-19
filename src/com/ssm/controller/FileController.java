package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.File;
import java.io.IOException;

/**
 * @author 陈宜康
 * @date 2019/3/12 20:16
 * @forWhat
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping(value = "/uploadMultipartFile",method = RequestMethod.POST)
    public ModelAndView uploadMultipartFile(MultipartFile multipartFile) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new MappingJackson2JsonView());
        //获取原始文件名
        String fileName = multipartFile.getOriginalFilename();
        multipartFile.getContentType();
        //目标文件
        File file = new File(fileName);
        //保存文件
        multipartFile.transferTo(file);
        System.out.println("暂停");
        modelAndView.addObject("success", true);
        modelAndView.addObject("msg", "上传文件成功");
        return modelAndView;
    }

    @RequestMapping("/upload")
    public String uploadMultipartFile(File file) throws IOException {
        System.out.println("shit");
        return null;
    }

}
