package com.huashuohair.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huashuohair.app.bean.User;
import com.huashuohair.app.utils.SecurityUtil;

@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByAccount(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        //获取该账户下的所有角色
        Set<String> rolesSet = userService.getRolesByAccount(username);
        if(rolesSet != null && rolesSet.size()>0){
        	for(String role : rolesSet){
        		authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
        	}
        }
        //获取该账户下的所有权限
        Set<String> permissionsSet = userService.getPermissionsByAccount(username);
        if(permissionsSet != null && permissionsSet.size()>0){
        	for(String permission : permissionsSet){
        		authorities.add(new SimpleGrantedAuthority(permission));
        	}
        }
        return new org.springframework.security.core.userdetails.User(user.getAccount(),SecurityUtil.encryptPassword(user.getPassword()),authorities);
    }
    
}