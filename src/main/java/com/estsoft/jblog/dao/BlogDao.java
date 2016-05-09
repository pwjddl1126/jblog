package com.estsoft.jblog.dao;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.jblog.vo.BlogVo;
import com.estsoft.jblog.vo.CategoryVo;
import com.estsoft.jblog.vo.UserVo;

@Repository
public class BlogDao {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(UserVo userVo) {
		System.out.println("insert");
		sqlSession.insert( "blog.insert", userVo );
	}
	
	public BlogVo get(UserVo userVo){
		return sqlSession.selectOne("blog.selectByUser", userVo);
	}
	
	public BlogVo getAll(String id){
		return sqlSession.selectOne("blog.selectAllById", id);
	}
	
	public Long getBlogNoById(String id){
		System.out.println("들어온다!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return sqlSession.selectOne("blog.selectById", id);
	}
	
	public void edit(BlogVo blogVo){
		sqlSession.update("blog.update", blogVo);
	}
	
	
}
