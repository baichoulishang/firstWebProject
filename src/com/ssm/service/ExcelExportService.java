package com.ssm.service;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

/**
 * @author 陈宜康
 * @date 2019/3/11 20:11
 * @forWhat
 */
public interface ExcelExportService {
    /**
     * 生成Excel
     * @param:
     * @return:
     * @auther: 不用密码的账号
     * @date: 2019/3/11 20:15
     */
    void makeWorkBook(Map<String, Object> map, Workbook workbook);
}
