package com.huashuohair.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuohair.app.bean.Permission;
import com.huashuohair.app.mapper.PermissionMapper;

@Service
public class PermissionService{

	@Autowired
	PermissionMapper permissionMapper;
	
	/**
	 * 新增
	 * @param Permission
	 * @return
	 */
	public int insertSelective(Permission record) {
		int intReslut = permissionMapper.insertSelective(record);
		return intReslut;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id) {
		int intReslut = permissionMapper.deleteByPrimaryKey(id);
		return intReslut;
	}
	/**
	 * 更新
	 * @param Permission
	 * @return
	 */
	public int updateByPrimaryKeySelective(Permission record) {
		int intReslut = permissionMapper.updateByPrimaryKeySelective(record);
		return intReslut;
	}
	/**
	 * 查询:通过id查询单个信息
	 * @param id
	 * @return
	 */
	public Permission selectByPrimaryKey(Integer id) {
		Permission crmCatalog = permissionMapper.selectByPrimaryKey(id);
		return crmCatalog;
	}
	
	/**
	 * 分页查询
	 * @param id
	 * @return
	 */
	public List<Permission> selectAllPermissionsByPage() {
		List<Permission> permissionList = permissionMapper.selectAllPermissionsByPage();
		return permissionList;
	}
}