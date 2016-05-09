package com.estsoft.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.jblog.dao.CategoryDao;
import com.estsoft.jblog.vo.BlogVo;
import com.estsoft.jblog.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public List<CategoryVo> getCategoryList() {
		return categoryDao.getList();
	}
	
	public void create( BlogVo vo ) {
		System.out.println("create까지 들어옵니다");
		categoryDao.create(vo);
	}
	
	public void insert(  CategoryVo vo  ) {
		categoryDao.insert(vo);
	}
	
	public void delete(Long no){
		categoryDao.delete(no);
	}

}
