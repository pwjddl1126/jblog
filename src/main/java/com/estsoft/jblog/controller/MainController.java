package com.estsoft.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/" )
public class MainController {

//	@RequestMapping( "/{id}" )
//	public String blog(){
//		System.out.println("잘 들어와찌룽");
//		return "/blog/blog-main";
//	}
	
	@RequestMapping( "/main" )
	public String index() {

		return "/main/index";
	}
}
