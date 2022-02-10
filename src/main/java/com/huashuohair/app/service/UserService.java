package com.huashuohair.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuohair.app.bean.Permission;
import com.huashuohair.app.bean.Role;
import com.huashuohair.app.bean.User;
import com.huashuohair.app.mapper.UserMapper;

@Service
public class UserService{

	@Autowired
	UserMapper userMapper;
	
	/**
	 * 新增
	 * @param User
	 * @return
	 */
	public int insertSelective(User record) {
		int intReslut = userMapper.insertSelective(record);
		return intReslut;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id) {
		int intReslut = userMapper.deleteByPrimaryKey(id);
		return intReslut;
	}
	/**
	 * 更新
	 * @param User
	 * @return
	 */
	public int updateByPrimaryKeySelective(User record) {
		int intReslut = userMapper.updateByPrimaryKeySelective(record);
		return intReslut;
	}
	/**
	 * 查询:通过id查询单个信息
	 * @param id
	 * @return
	 */
	public User selectByPrimaryKey(Integer id) {
		User crmCatalog = userMapper.selectByPrimaryKey(id);
		return crmCatalog;
	}
	/**
	 * 通过账户获取该用户信息
	 * @param account
	 * @return
	 */
	public User getUserByAccount(String account) {
		User user = userMapper.getUserByAccount(account);
		return user;
	}
	/**
	 * 通过账户获取该用户的所有角色
	 * @param account
	 * @return
	 */
	public Set<String> getRolesByAccount(String account) {
        List<Role> roles = userMapper.getRolesByAccount(account);
        Set<String> result = new HashSet<>();
        for (Role role: roles) {
            result.add(role.getCode());
        }
        return result;
    }
	/**
	 * 通过账户获取该用户的所有权限
	 * @param account
	 * @return
	 */
	public Set<String> getPermissionsByAccount(String account) {
        List<Permission> permissions = userMapper.getPermissionsByAccount(account);
        Set<String> result = new HashSet<>();
        for (Permission permission: permissions) {
            result.add(permission.getCode());
        }
        return result;
    }
	
	/**
	 * 分页查询
	 * @param id
	 * @return
	 */
	public List<User> selectAllUsersByPage() {
		List<User> userList = userMapper.selectAllUsersByPage();
		return userList;
	}
	
}