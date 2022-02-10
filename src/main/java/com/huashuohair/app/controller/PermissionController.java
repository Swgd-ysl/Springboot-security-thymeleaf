package com.huashuohair.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashuohair.app.bean.Permission;
import com.huashuohair.app.common.Const;
import com.huashuohair.app.common.Msg;
import com.huashuohair.app.service.PermissionService;
import com.huashuohair.app.utils.DateUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="权限相关接口")
@RestController
@RequestMapping("/Permission")
public class PermissionController{
	
	@Autowired 
	PermissionService permissionService;
	
	
	/**
	 * 新增
	 * @param rep
	 * @param res
	 * @param session
	 * @param permissionReq
	 * @return
	 */
	@Operation(description = "新增单条权限信息",summary="新增")
	@PostMapping("/Add")
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody Permission permissionReq){
		String nowTime = DateUtil.strTime14s();
		permissionReq.setCreateTime(nowTime);
		permissionService.insertSelective(permissionReq);
		
		if(permissionReq.getId() != null){
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
	 * @param permissionReq
	 * @return
	 */
	@Operation(description = "通过id删除单条权限信息",summary="删除")
	@PostMapping("/Delete")
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody Permission permissionReq){
		permissionService.deleteByPrimaryKey(permissionReq.getId());
		return Msg.success().add("resMsg", "删除成功");
	}
	
	/**
	 * 更新
	 * @param rep
	 * @param res
	 * @param session
	 * @param permissionReq
	 * @return
	 */
	@Operation(description = "通过id修改单条权限信息",summary="更新")
	@PostMapping("/Update")
	public Msg updateByPrimaryKeySelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody Permission permissionReq){
		String nowTime = DateUtil.strTime14s();
		permissionReq.setLastUpdateTime(nowTime);
		permissionService.updateByPrimaryKeySelective(permissionReq);
		return Msg.success().add("resMsg", "修改成功");
	}
	
	/**
	 * @author 20211018
	 * @param Permission
	 * 查询：通过id 查询单个详情
	 * */
	@Operation(description = "通过id查询单条权限信息",summary="查询")
	@PostMapping("/GetOnePermissionDetailById")
	public Msg GetOnePermissionDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody Permission permissionReq){
		//通过id 查询单个详情
		Permission permissionRes = permissionService.selectByPrimaryKey(permissionReq.getId());
		return Msg.success().add("permission", permissionRes);
		
	}
	
	/**
	 * 分页查询
	 * @param rep
	 * @param res
	 * @param session
	 * @return
	 */
	@Operation(description = "分页查询权限信息",summary="分页查询")
	@PreAuthorize("hasAuthority('listPermission')")
	@PostMapping("/GetAllPermissionsByPage")
	public Msg getAllPermissionsByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session){
		//通过id 查询单个详情
		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<Permission> permissionList = permissionService.selectAllPermissionsByPage();
		PageInfo<Permission> page = new PageInfo<Permission>(permissionList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
}