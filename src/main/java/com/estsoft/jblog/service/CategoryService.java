package com.estsoft.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.jblog.dao.CategoryDao;
import com.estsoft.jblog.vo.BlogVo;

@Service
public class CategoryService {

	@Autowired
	private static CategoryDao categoryDao;
	
	public static void create( BlogVo vo ) {
		categoryDao.insert(vo);
	}
}
