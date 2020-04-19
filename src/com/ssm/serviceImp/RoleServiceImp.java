package com.ssm.serviceImp;

import com.ssm.mapper.RoleMapper;
import com.ssm.pojo.Role;
import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Service
@Component
public class RoleServiceImp implements RoleService {

    //自动装配mapper
    @Autowired
    public RoleMapper roleMapper = null;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Role selectRole(String id) {
        Role selectRole = new Role();
        selectRole.setId(id);
        Role role = roleMapper.getRole(selectRole);
        return role;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public void insertRole(Role role) {
        roleMapper.insertRole(role);
    }

    @Override
    public List<Role> getList(String rolename) {
        List<Role> roles = roleMapper.getRoles(rolename);
        return roles;
    }
}
