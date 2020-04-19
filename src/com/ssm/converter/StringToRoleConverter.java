package com.ssm.converter;

import com.ssm.pojo.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * @author 陈宜康
 * @date 2019/3/16 10:44
 * @forWhat
 */
public class StringToRoleConverter implements Converter<String, Role> {
    @Override
    public Role convert(String string) {
        if (StringUtils.isEmpty(string)) {
            return null;
        }
        if (string.indexOf("-") == -1) {
            return null;
        }
        String[] arr = string.split("-");
        if (arr.length != 3) {
            return null;
        }
        Role role = new Role();
        role.setId(arr[0]);
        role.setRolename(arr[1]);
        role.setNote(arr[2]);
        return role;
    }
}
