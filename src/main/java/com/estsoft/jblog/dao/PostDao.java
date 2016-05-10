package com.estsoft.jblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.jblog.vo.CategoryVo;
import com.estsoft.jblog.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void write(PostVo postVo){
		sqlSession.insert("post.insert", postVo);
	}
	
	public List<PostVo> getPostList(Long category_no){
		List<PostVo> postList =  sqlSession.selectList("post.selectList", category_no);
		return postList;
	}
	
	public PostVo get(PostVo postVo){
		postVo = sqlSession.selectOne("post.get",postVo);
		return postVo;
	}
	
	public void delete(PostVo postVo){
		sqlSession.delete("post.delete", postVo);
	}
}

