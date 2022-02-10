/*package com.huashuohair.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig{
	
	@Bean
	DatabaseRealm myRealm() {
	    return new DatabaseRealm();
	}
	
	@Bean
	DefaultWebSecurityManager securityManager() {
	    DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
	    manager.setRealm(myRealm());
	    return manager;
	}
	
	@Bean
	ShiroFilterChainDefinition shiroFilterChainDefinition() {
	    DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
	    definition.addPathDefinition("/login", "anon");
	    definition.addPathDefinition("/**", "authc");
	    return definition;
	}
}*/