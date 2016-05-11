package com.estsoft.jblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.jblog.vo.BlogVo;
import com.estsoft.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<CategoryVo> getList(Long no) {
		List<CategoryVo> list = sqlSession.selectList( "category.selectList", no );
		return list;
	}
	
	public void create(BlogVo blogVo) {
		System.out.println("create까지 들어옵니다");
		sqlSession.insert( "category.create", blogVo );
	}
	
	public void insert(CategoryVo categoryVo) {
		System.out.println("insert까지 들어옵니다");
		//select 해서 blog
		sqlSession.insert( "category.insert", categoryVo );
	}
	
	public void delete(Long no){
		sqlSession.delete("category.delete",no);
	}
	
	public Long getDefaultCategory(Long blog_no){
		Long category_no = sqlSession.selectOne("category.selectDefaultCategoryNo", blog_no);
		return category_no;
	}

}
