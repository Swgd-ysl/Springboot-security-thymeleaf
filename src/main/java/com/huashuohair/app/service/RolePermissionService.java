package com.huashuohair.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuohair.app.bean.RolePermission;
import com.huashuohair.app.mapper.RolePermissionMapper;

@Service
public class RolePermissionService{

	@Autowired
	RolePermissionMapper rolePermissionMapper;
	
	/**
	 * 新增
	 * @param RolePermission
	 * @return
	 */
	public int insertSelective(RolePermission record) {
		int intReslut = rolePermissionMapper.insertSelective(record);
		return intReslut;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id) {
		int intReslut = rolePermissionMapper.deleteByPrimaryKey(id);
		return intReslut;
	}
	/**
	 * 更新
	 * @param RolePermission
	 * @return
	 */
	public int updateByPrimaryKeySelective(RolePermission record) {
		int intReslut = rolePermissionMapper.updateByPrimaryKeySelective(record);
		return intReslut;
	}
	/**
	 * 查询:通过id查询单个信息
	 * @param id
	 * @return
	 */
	public RolePermission selectByPrimaryKey(Integer id) {
		RolePermission crmCatalog = rolePermissionMapper.selectByPrimaryKey(id);
		return crmCatalog;
	}
	
	
}