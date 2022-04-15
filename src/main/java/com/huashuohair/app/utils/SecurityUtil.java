package com.huashuohair.app.utils;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtil{
	
	/**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
    /**
     * 获取当前用户权限
     * @return
     */
    public static HashSet<String> getAuthorities(){
    	SecurityContext securityContext = SecurityContextHolder.getContext();
    	Collection<? extends GrantedAuthority> authorities = securityContext.getAuthentication().getAuthorities();
		HashSet<String>	hashSet = new HashSet<String>();
		if(authorities != null && authorities.size()>0){
			for(GrantedAuthority grantedAuthority : authorities){
	    		hashSet.add(grantedAuthority.getAuthority());
	    	}
		}
    	return hashSet;
    }
}