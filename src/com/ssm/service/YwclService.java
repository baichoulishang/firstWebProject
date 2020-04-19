package com.ssm.service;

import com.ssm.pojo.Role;
import com.ssm.pojo.YwclCaseVO;

import java.util.List;

public interface YwclService {

    List<YwclCaseVO> getList(String ldzl);
}
