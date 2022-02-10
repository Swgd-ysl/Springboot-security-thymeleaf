package com.huashuohair.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashuohair.app.bean.Role;
import com.huashuohair.app.common.Const;
import com.huashuohair.app.common.Msg;
import com.huashuohair.app.service.RoleService;
import com.huashuohair.app.utils.DateUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="角色相关接口")
@RestController
@RequestMapping("/Role")
public class RoleController{
	
	@Autowired 
	RoleService roleService;
	
	
	/**
	 * 新增
	 * @param rep
	 * @param res
	 * @param session
	 * @param roleReq
	 * @return
	 */
	@Operation(description = "新增单条角色信息",summary="新增")
	@PostMapping("/Add")
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody Role roleReq){
		String nowTime = DateUtil.strTime14s();
		roleReq.setCreateTime(nowTime);
		roleService.insertSelective(roleReq);
		
		if(roleReq.getId() != null){
			return Msg.success().add("resMsg", "创建成功");
		}else{
			return Msg.fail().add("resMsg", "系统错误，请联系管理员");
		}
	}
	
	/**
	 * 删除
	 * @param rep
	 * @param res
	 * @param session
	 * @param roleReq
	 * @return
	 */
	@Operation(description = "通过id删除单条角色信息",summary="删除")
	@PostMapping("/Delete")
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody Role roleReq){
		roleService.deleteByPrimaryKey(roleReq.getId());
		return Msg.success().add("resMsg", "删除成功");
	}
	
	/**
	 * 更新
	 * @param rep
	 * @param res
	 * @param session
	 * @param roleReq
	 * @return
	 */
	@Operation(description = "通过id更新单条角色信息",summary="更新")
	@PostMapping("/Update")
	public Msg updateByPrimaryKeySelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody Role roleReq){
		String nowTime = DateUtil.strTime14s();
		roleReq.setLastUpdateTime(nowTime);
		roleService.updateByPrimaryKeySelective(roleReq);
		return Msg.success().add("resMsg", "修改成功");
	}
	
	/**
	 * 查询：通过id 查询单个详情
	 * @param rep
	 * @param res
	 * @param session
	 * @param roleReq
	 * @return
	 */
	@Operation(description = "通过id查询单条角色信息",summary="查询")
	@PostMapping("/GetOneRoleDetailById")
	public Msg GetOneRoleDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody Role roleReq){
		//通过id 查询单个详情
		Role roleRes = roleService.selectByPrimaryKey(roleReq.getId());
		return Msg.success().add("role", roleRes);
		
	}
	
	/**
	 * 分页查询
	 * @param rep
	 * @param res
	 * @param session
	 * @return
	 */
	@Operation(description = "分页查询角色信息",summary="分页查询")
	@PreAuthorize("hasAuthority('listRole')")
	@PostMapping("/GetAllRolesByPage")
	public Msg getAllRolesByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session){
		//通过id 查询单个详情
		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<Role> roleList = roleService.selectAllRolesByPage();
		PageInfo<Role> page = new PageInfo<Role>(roleList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	/**
	 * 查询全部
	 * @param rep
	 * @param res
	 * @param session
	 * @return
	 */
	@Operation(description = "查询全部角色信息",summary="查询全部")
	@PreAuthorize("hasAuthority('listRole')")
	@GetMapping("/GetAllRoles")
	public Msg getAllRoles(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		//通过id 查询单个详情
		List<Role> roleList = roleService.selectAllRoles();
		return Msg.success().add("roleList", roleList);
		
	}
	
}