package com.estsoft.jblog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estsoft.jblog.service.BlogService;
import com.estsoft.jblog.service.CategoryService;
import com.estsoft.jblog.service.PostService;
import com.estsoft.jblog.vo.BlogVo;
import com.estsoft.jblog.vo.CategoryVo;
import com.estsoft.jblog.vo.PostVo;

@Controller
public class BlogController {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	BlogService blogService;
	@Autowired
	PostService postService;
	
	@RequestMapping("/{id}")
	public String blog(@PathVariable("id") String id, Model model ){
		System.out.println("잘 들어와찌룽");
		
		BlogVo blogVo =  blogService.get(id);
		
		List<CategoryVo> list = categoryService.getCategoryList();
		model.addAttribute( "list", list );
		model.addAttribute( "blogVo", blogVo );
		
		return "blog/blog-main";
	}
	
	@RequestMapping( "/blog/insert" )
	public String insert( @ModelAttribute CategoryVo vo, @RequestParam(value= "id", required=true, defaultValue="" ) String id ) {
		
		System.out.println("으아아아아아아앙ㄱ!");
		Long blog_no = blogService.getBlogNoById(id);
		vo.setBlog_no(blog_no);
		categoryService.insert(vo);
//		 BlogVo blogVo = blogService.get(vo);
//		 categoryService.insert(blogVo);
		return "redirect:/"+id+"/blog-admin-category";
	}
	
	@RequestMapping("blog/delete/{id}/{no}")
	public String delete(@PathVariable("id") Long id,@PathVariable("no") Long categoryNo, Model model ){
		System.out.println("삭제한다앙");
		
		//no = 카테고리 넘버를 찾아서 딜리
		categoryService.delete(categoryNo);
		
		List<CategoryVo> list = categoryService.getCategoryList();
		model.addAttribute( "list", list );
		
		
		return "redirect:/"+id+"/blog-admin-category";
	}
	
	@RequestMapping("/{id}/blog-admin-basic")
	public String blogAdminBasic(@PathVariable("id") String id, Model model ){
		BlogVo blogVo =  blogService.get(id);
		model.addAttribute( "blogVo", blogVo );
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping("/{id}/blog-admin-category")
	public String blogAdminCategory(@PathVariable("id") String id, Model model ){
		BlogVo blogVo =  blogService.get(id);
		List<CategoryVo> list = categoryService.getCategoryList();
		model.addAttribute( "list", list );
		model.addAttribute( "blogVo", blogVo );
//		@PathVariable( "id" ) String id,
//		model.addAttribute( "id", id);
		
		return "blog/blog-admin-category";
	}
	
	@RequestMapping("/{id}/blog-admin-write")
	public String blogAdminWriteForm(@PathVariable("id") String id, Model model){
		BlogVo blogVo =  blogService.get(id);
		List<CategoryVo> list = categoryService.getCategoryList();
		model.addAttribute( "list", list );
		model.addAttribute( "blogVo", blogVo );
		return "blog/blog-admin-write";
	}
	
	@RequestMapping("/blog/edit")
	public String edit(@ModelAttribute BlogVo vo,
			@RequestParam(value= "id", required=true, defaultValue="" ) String id){
		
		System.out.println("no : "+  vo.getNo());
		System.out.println("id : "+  vo.getId());
		System.out.println("title : "+ vo.getTitle());
		System.out.println("logo : "+  vo.getLogo());
		
		blogService.edit(vo);
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping("/blog/{id}/write")
	public String write(@PathVariable("id") String id,
			@Valid @ModelAttribute PostVo vo,
			BindingResult result,
			Model model){
		
		BlogVo blogVo =  blogService.get(id);
		
		// Valid 채크
//		if (result.hasErrors()) {
//			List<CategoryVo> categoryList = categoryService.getList(blogVo.getBlog_no());
//			model.addAttribute("categoryList", categoryList);
//			model.addAttribute("postVo", vo);
//			model.addAttribute("blogVo", blogVo);
//			model.addAttribute(result.getModel());
//			return "blog/blog-admin-write";
//		}
		
		// write 부분
		postService.write(vo);
		
		return "redirect:/blog/"+id;
		
	}
	

	
}
