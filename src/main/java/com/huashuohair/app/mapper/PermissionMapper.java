package com.huashuohair.app.mapper;

import java.util.List;

import com.huashuohair.app.bean.Permission;

public interface PermissionMapper{
	
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    List<Permission> listPermissionsByUserName(String userName);
    
    List<Permission> selectAllPermissionsByPage();
}