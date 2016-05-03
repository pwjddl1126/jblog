package com.estsoft.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthLogoutInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession httpSession = request.getSession();
		if( httpSession != null ) {
			httpSession.removeAttribute( "authUser" );
			httpSession.invalidate();
		}
		
		System.out.println("로그아웃 됏다아");
		response.sendRedirect( request.getContextPath()+"/main" );
		return false;
	}

}
