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
	public String blog(@PathVariable("id") String id,
			@RequestParam(value="category_no", defaultValue="0") Long category_no,
			@RequestParam(value="post_no",defaultValue="0") Long post_no,Model model) {

		BlogVo blogVo = blogService.get(id);

		System.out.println("blog no : " + blogVo.getNo());

		List<CategoryVo> categoryList = categoryService.getCategoryList(blogVo.getNo());
		List<PostVo> postList = postService.getPostList(category_no);
		
		PostVo postVo = postService.get(post_no);
		
		if (categoryList.size() > 0) {
			
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("blogVo", blogVo);
			model.addAttribute("postList", postList);
			model.addAttribute("postVo", postVo);
			
			return "blog/blog-main";

		}
		return "";
	}

	@RequestMapping("/blog/insert")
	public String insert(
			@ModelAttribute CategoryVo vo,
			@RequestParam(value = "id", required = true, defaultValue = "") String id) {

		Long blog_no = blogService.getBlogNoById(id);
		vo.setBlog_no(blog_no);
		categoryService.insert(vo);

		return "redirect:/" + id + "/blog-admin-category";
	}

	@RequestMapping("blog/delete/{id}/{no}")
	public String delete(@PathVariable("id") String id,
			@PathVariable("no") Long categoryNo, Model model) {
		System.out.println("삭제한다앙");

		// no = 카테고리 넘버를 찾아서 딜리
		categoryService.delete(categoryNo);
		BlogVo blogVo = blogService.get(id);
		List<CategoryVo> list = categoryService.getCategoryList(blogVo.getNo());
		model.addAttribute("list", list);

		return "redirect:/" + id + "/blog-admin-category";
	}

	@RequestMapping("/{id}/blog-admin-basic")
	public String blogAdminBasic(@PathVariable("id") String id, Model model) {
		BlogVo blogVo = blogService.get(id);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-admin-basic";
	}

	@RequestMapping("/{id}/blog-admin-category")
	public String blogAdminCategory(@PathVariable("id") String id, Model model) {
		BlogVo blogVo = blogService.get(id);
		List<CategoryVo> list = categoryService.getCategoryList(blogVo.getNo());
		model.addAttribute("list", list);
		model.addAttribute("blogVo", blogVo);
		// @PathVariable( "id" ) String id,
		// model.addAttribute( "id", id);

		return "blog/blog-admin-category";
	}

	@RequestMapping("/{id}/blog-admin-write")
	public String blogAdminWriteForm(@PathVariable("id") String id, Model model) {
		BlogVo blogVo = blogService.get(id);
		List<CategoryVo> list = categoryService.getCategoryList(blogVo.getNo());
		model.addAttribute("list", list);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-admin-write";
	}

	@RequestMapping("/blog/edit")
	public String edit(
			@ModelAttribute BlogVo vo,
			@RequestParam(value = "id", required = true, defaultValue = "") String id) {

		System.out.println("no : " + vo.getNo());
		System.out.println("id : " + vo.getId());
		System.out.println("title : " + vo.getTitle());
		System.out.println("logo : " + vo.getLogo());

		blogService.edit(vo);
		return "blog/blog-admin-basic";
	}

	@RequestMapping("/blog/{id}/write")
	public String write(
			@PathVariable("id") String id,
			@RequestParam(value = "category_no", required = true, defaultValue = "") Long category_no,
			@RequestParam(value = "title", required = true, defaultValue = "") String title,
			@RequestParam(value = "content", required = true, defaultValue = "") String content,PostVo postVo) {

		System.out.println("id : " + id);
		System.out.println("category_no : " + category_no);
		System.out.println("title : " + title);
		System.out.println("content : " + content);

		
		postVo.setCategory_no(category_no);
		postVo.setTitle(title);
		postVo.setContent(content);
		
		postService.write(postVo);

		return "redirect:/" + id;
	}

	@RequestMapping("blog/{id}/deletepost")
	public String deletePost(
			@PathVariable("id") String id,
			@RequestParam("no") Long no){
		
		postService.delete(no);
		
		return "redirect:/" + id;
	}
	
	// @RequestMapping("/blog/{id}/write")
	// public String write(@PathVariable("id") String id,
	// @Valid @ModelAttribute PostVo vo,
	// @RequestParam(value= "no", required=true, defaultValue="") Long
	// no,BindingResult result,
	// Model model){
	//
	// BlogVo blogVo = blogService.get(id);
	// System.out.println("id : "+ id);
	// System.out.println("no : "+ no);
	// System.out.println("postVo : "+ vo);
	// System.out.println("Binding result : "+ result);
	// System.out.println("model : "+ model);
	//
	// // Valid 채크
	// // if (result.hasErrors()) {
	// // List<CategoryVo> categoryList =
	// categoryService.getList(blogVo.getBlog_no());
	// // model.addAttribute("categoryList", categoryList);
	// // model.addAttribute("postVo", vo);
	// // model.addAttribute("blogVo", blogVo);
	// // model.addAttribute(result.getModel());
	// // return "blog/blog-admin-write";
	// // }
	//
	// // write 부분
	// // postService.write(vo);
	//
	// return "redirect:/blog/"+id;
	//
	// }

}
