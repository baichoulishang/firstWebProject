package com.ssm.service;

import com.ssm.pojo.Role;

import java.util.List;

public interface RoleService {
    Role selectRole(String id);

    void insertRole(Role role);

    List<Role> getList(String rolename);
}
