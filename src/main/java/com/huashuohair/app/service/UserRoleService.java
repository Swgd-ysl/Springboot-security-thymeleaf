package com.huashuohair.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuohair.app.bean.UserRole;
import com.huashuohair.app.mapper.UserRoleMapper;

@Service
public class UserRoleService{

	@Autowired
	UserRoleMapper userRoleMapper;
	
	/**
	 * 新增
	 * @param UserRole
	 * @return
	 */
	public int insertSelective(UserRole record) {
		int intReslut = userRoleMapper.insertSelective(record);
		return intReslut;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id) {
		int intReslut = userRoleMapper.deleteByPrimaryKey(id);
		return intReslut;
	}
	/**
	 * 更新
	 * @param UserRole
	 * @return
	 */
	public int updateByPrimaryKeySelective(UserRole record) {
		int intReslut = userRoleMapper.updateByPrimaryKeySelective(record);
		return intReslut;
	}
	/**
	 * 查询:通过id查询单个信息
	 * @param id
	 * @return
	 */
	public UserRole selectByPrimaryKey(Integer id) {
		UserRole crmCatalog = userRoleMapper.selectByPrimaryKey(id);
		return crmCatalog;
	}
	
	
}