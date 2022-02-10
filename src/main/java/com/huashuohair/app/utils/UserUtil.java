package com.huashuohair.app.utils;

import javax.servlet.http.HttpSession;

import com.huashuohair.app.bean.User;
import com.huashuohair.app.common.Const;


public class UserUtil{
	
	
	/**
	 * 是否登录
	 * @return
	 */
	public static boolean IslogIn(HttpSession session){
		boolean flag = false;
		User user = (User)session.getAttribute(Const.SUBJECT);
		if(user != null){
			flag = true;
		}
		return flag;
	}
}