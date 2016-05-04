package com.estsoft.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
	
	@RequestMapping("/{id}")
	public String blog(){
		System.out.println("잘 들어와찌룽");
		return "/blog/blog-main";
	}
	
	@RequestMapping("/{id}/blog-admin-basic")
	public String blogAdminBasic(){
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping("/{id}/blog-admin-category")
	public String blogAdminCategory(){
		return "blog/blog-admin-category";
	}
	
	@RequestMapping("/{id}/blog-admin-write")
	public String blogAdminWrite(){
		return "blog/blog-admin-write";
	}
	
//	@RequestMapping("/main")
//	public String index() {
//		System.out.println("메인까지 들어온다");
//		return "/blog/blog-main";
//	}
	
}
