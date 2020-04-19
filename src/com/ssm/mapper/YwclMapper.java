package com.ssm.mapper;


import com.ssm.pojo.Role;
import com.ssm.pojo.YwclCaseVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//表示dao层
@Repository
public interface YwclMapper {

    List<YwclCaseVO> getYwclList(String ldzl);
}
