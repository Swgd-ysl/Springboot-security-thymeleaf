package com.huashuohair.app.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huashuohair.app.common.Msg;

@Component
public class HuaShuoAccessDeniedHandler implements AccessDeniedHandler {
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		 Msg msg = Msg.fail();
		 msg.add("error", "权限不足,访问失败");
		 response.setStatus(403);
		 response.setContentType("application/json;charset=utf-8");
         PrintWriter out = response.getWriter();
         out.write(new ObjectMapper().writeValueAsString(msg));
         out.flush();
         out.close();
		
	}

}