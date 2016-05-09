package com.estsoft.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.jblog.dao.BlogDao;
import com.estsoft.jblog.vo.BlogVo;
import com.estsoft.jblog.vo.CategoryVo;
import com.estsoft.jblog.vo.UserVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	public void create( UserVo vo ) {
		System.out.println("create");
		blogDao.insert(vo);
	}
	
	public BlogVo get(UserVo userVo){
		BlogVo blogVo = blogDao.get(userVo);
		return blogVo;
	}
	
	public BlogVo get(String id){
		BlogVo blogVo= blogDao.getAll(id);
		return blogVo;
	}

	public Long getBlogNoById(String id){
		Long blog_no = blogDao.getBlogNoById(id);
		return blog_no;
	}
	
	public void edit( BlogVo vo){
		blogDao.edit(vo);
	}
}
