package com.estsoft.jblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.estsoft.jblog.service.BlogService;
import com.estsoft.jblog.service.CategoryService;
import com.estsoft.jblog.service.UserService;
import com.estsoft.jblog.vo.BlogVo;
import com.estsoft.jblog.vo.UserVo;



@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/login")
	public String login() {
		return "/user/loginform";
	}
	
	
	@RequestMapping("/loginform")
	public String loginform() {
		return "/user/loginform";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "/user/join";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo vo,
					BindingResult result, Model model) {

		if (result.hasErrors()) {
			// 에러 출력
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError e : list) {
//				System.out.println(" ObjectError : " + e);
//			}
			model.addAllAttributes(result.getModel());
			return "/user/joinform";
		}
		
			
		 userService.join(vo);
		 blogService.create(vo);
		 
		 BlogVo blogVo = blogService.get(vo);
		 System.out.println("in usercontroller blogVo : " + blogVo);
		 CategoryService.create(blogVo);
		 return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinSuccess() {
		return "/user/joinsuccess";
	}
}
