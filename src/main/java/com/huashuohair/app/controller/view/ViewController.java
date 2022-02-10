package com.huashuohair.app.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name ="各页面路由接口")
@Controller
public class ViewController{
	
	@Operation(summary ="登录页")
	@GetMapping("/Login")
	public String toLoginPage(){
		return "login";
	}
	
	@Operation(summary ="index页")
	@GetMapping("/Index")
	public String toIndexPage(){
		return "index";
	}
	
	@Operation(summary ="用户页")
	@GetMapping("/User/ToUserPage")
	public String toUserPage(){
		return "userPage";
	}
	
	@Operation(summary ="角色页")
	@GetMapping("/Role/ToRolePage")
	public String toRolePage(){
		return "rolePage";
	}
	
	@Operation(summary ="权限页")
	@GetMapping("/Permission/ToPermissionPage")
	public String toPermissionPage(){
		return "permissionPage";
	}

}