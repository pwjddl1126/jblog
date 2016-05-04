package com.estsoft.jblog.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.jblog.vo.BlogVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void insert(BlogVo blogVo) {
		System.out.println("insert!!!!!!!!!!");
		sqlSession.insert( "category.insert", blogVo );
	}
}
