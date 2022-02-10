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
import com.huashuohair.app.bean.User;
import com.huashuohair.app.common.Const;
import com.huashuohair.app.common.Msg;
import com.huashuohair.app.service.UserService;
import com.huashuohair.app.utils.DateUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "用户相关接口")
@RestController
@RequestMapping("/User")
public class UserController{
	
	@Autowired 
	UserService userService;
	
	/**
	 * 新增
	 * @param rep
	 * @param res
	 * @param session
	 * @param userReq
	 * @return
	 */
	
	@Operation(description = "添加单条用户信息",summary="新增")
	@PostMapping("/Add")
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody User userReq){
		String nowTime = DateUtil.strTime14s();
		userReq.setCreateTime(nowTime);
		userService.insertSelective(userReq);
		
		if(userReq.getId() != null){
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
	 * @param userReq
	 * @return
	 */
	@Operation(description = "通过id删除单条用户信息",summary="删除")
	@PostMapping("/Delete")
	public Msg delete(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody User userReq){
		userService.deleteByPrimaryKey(userReq.getId());
		return Msg.success().add("resMsg", "删除成功");
	}
	/**
	 * 更新
	 * @param rep
	 * @param res
	 * @param session
	 * @param userReq
	 * @return
	 */
	@Operation(description = "通过id修改单条用户信息",summary="更新")
	@PostMapping("/Update")
	public Msg updateByPrimaryKeySelective(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody User userReq){
		String nowTime = DateUtil.strTime14s();
		userReq.setLastUpdateTime(nowTime);
		userService.updateByPrimaryKeySelective(userReq);
		return Msg.success().add("resMsg", "修改成功");
	}
	
	/**
	 * 查询：通过id 查询单个详情 
	 * @param rep
	 * @param res
	 * @param session
	 * @param userReq
	 * @return
	 */
	@Operation(description = "通过id查询单条用户信息",summary="查询")
	@PostMapping("/GetOneUserDetailById")
	public Msg GetOneUserDetailById(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody User userReq){
		User userRes = userService.selectByPrimaryKey(userReq.getId());
		return Msg.success().add("user", userRes);
		
	}
	
	/**
	 * 分页查询
	 * @param rep
	 * @param res
	 * @param session
	 * @return
	 */
	@Operation(description = "分页查询用户信息",summary="分页查询")
	@PreAuthorize("hasAuthority('listUser')")
	@PostMapping("/GetAllUsersByPage")
	public Msg getAllUsersByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session){
		//通过id 查询单个详情
		int PagNum = Const.PAGE_NUM_DEFAULT;
		PageHelper.startPage(pn, PagNum);
		List<User> userList = userService.selectAllUsersByPage();
		PageInfo<User> page = new PageInfo<User>(userList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
}