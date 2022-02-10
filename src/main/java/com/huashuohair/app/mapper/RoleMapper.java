package com.huashuohair.app.mapper;

import java.util.List;

import com.huashuohair.app.bean.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectAllRoles();
    
    List<Role> selectAllRolesByPage();
    
}