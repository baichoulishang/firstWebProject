package com.ssm.serviceImp;

import com.ssm.mapper.RoleMapper;
import com.ssm.mapper.YwclMapper;
import com.ssm.pojo.Role;
import com.ssm.pojo.YwclCaseVO;
import com.ssm.service.RoleService;
import com.ssm.service.YwclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
@Component
public class Ywcl implements YwclService {

    //自动装配mapper
    @Autowired
    public YwclMapper ywclMapper;

    @Override
    public List<YwclCaseVO> getList(String ldzl) {
        List<YwclCaseVO> ywclList = ywclMapper.getYwclList(ldzl);
        return ywclList;
    }
}
