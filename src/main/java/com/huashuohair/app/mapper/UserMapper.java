package com.huashuohair.app.mapper;

import java.util.List;

import com.huashuohair.app.bean.Permission;
import com.huashuohair.app.bean.Role;
import com.huashuohair.app.bean.User;

public interface UserMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User getUserByAccount(String account);
    
    List<Role> getRolesByAccount(String account);
    
    List<Permission> getPermissionsByAccount(String account);
    
    List<User> selectAllUsersByPage();
    
    
}