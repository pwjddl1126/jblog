package com.estsoft.jblog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.estsoft.jblog.service.UserService;
import com.estsoft.jblog.vo.UserVo;


public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
//		ApplicationContext applicationContext =   
//				WebApplicationContextUtils.getWebApplicationContext( request.getServletContext() );		
//		UserService userService = applicationContext.getBean( UserService.class );

		String id = request.getParameter( "id" );
		String password = request.getParameter( "password" );

		UserVo userVo = new UserVo();
		userVo.setId(id);
		userVo.setPassword(password);
		
		System.out.println("id:"+userVo.getId());
		System.out.println("psd:"+userVo.getPassword());
		
		//login 서비스 호출 (로긴 작업)
		UserVo authUser = userService.login( userVo );
		if( authUser == null ) {
			response.sendRedirect( request.getContextPath() + "/user/loginform" );
			return false;
		}
		
		//로그인 처리
		HttpSession session = request.getSession( true );
		session.setAttribute( "authUser", authUser );
		System.out.println("로그인 됏다아");
		response.sendRedirect( request.getContextPath()+ "/main" );
		
		return false;
	}

}
