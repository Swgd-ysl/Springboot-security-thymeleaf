package com.huashuohair.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huashuohair.app.bean.Role;
import com.huashuohair.app.mapper.RoleMapper;

@Service
public class RoleService{

	@Autowired
	RoleMapper roleMapper;
	
	/**
	 * 新增
	 * @param Role
	 * @return
	 */
	public int insertSelective(Role record) {
		int intReslut = roleMapper.insertSelective(record);
		return intReslut;
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id) {
		int intReslut = roleMapper.deleteByPrimaryKey(id);
		return intReslut;
	}
	/**
	 * 更新
	 * @param Role
	 * @return
	 */
	public int updateByPrimaryKeySelective(Role record) {
		int intReslut = roleMapper.updateByPrimaryKeySelective(record);
		return intReslut;
	}
	/**
	 * 查询:通过id查询单个信息
	 * @param id
	 * @return
	 */
	public Role selectByPrimaryKey(Integer id) {
		Role crmCatalog = roleMapper.selectByPrimaryKey(id);
		return crmCatalog;
	}
	
	/**
	 * 分页查询
	 * @param id
	 * @return
	 */
	public List<Role> selectAllRolesByPage() {
		List<Role> roleList = roleMapper.selectAllRolesByPage();
		return roleList;
	}
	
	/**
	 * 查询全部信息
	 * @param id
	 * @return
	 */
	public List<Role> selectAllRoles() {
		List<Role> roleList = roleMapper.selectAllRoles();
		return roleList;
	}
	
}