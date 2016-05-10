package com.estsoft.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estsoft.jblog.service.BlogService;
import com.estsoft.jblog.service.CategoryService;
import com.estsoft.jblog.vo.BlogVo;
import com.estsoft.jblog.vo.CategoryVo;

@Controller
@RequestMapping( "/category" )
public class CategoryController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping( "/insert" )
	public String insert( @ModelAttribute CategoryVo vo, @RequestParam(value= "id", required=true, defaultValue="" ) String id ) {
		
		System.out.println("으아아아아아아앙ㄱ!");
		Long blog_no = blogService.getBlogNoById(id);
		vo.setBlog_no(blog_no);
		categoryService.insert(vo);
//		 BlogVo blogVo = blogService.get(vo);
//		 categoryService.insert(blogVo);
		return "redirect:/"+id+"/blog-admin-category";
	}
	
	@RequestMapping("/delete/{id}/{no}")
	public String delete(@PathVariable("id") String id,@PathVariable("no") Long categoryNo, Model model ){
		System.out.println("삭제한다앙");
		
		BlogVo blogVo =  blogService.get(id);
		//no = 카테고리 넘버를 찾아서 딜리
		categoryService.delete(categoryNo);
		
		List<CategoryVo> list = categoryService.getCategoryList(blogVo.getNo());
		model.addAttribute( "list", list );
		
		
		return "redirect:/"+id+"/blog-admin-category";
	}
}
