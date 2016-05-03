package com.estsoft.jblog.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estsoft.jblog.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	//
	
	public UserVo get(UserVo userVo) {
		return sqlSession.selectOne("user.selectByIdAndPassword", userVo);
	}
	
	public void insert(UserVo userVo) {
		sqlSession.insert( "user.insert", userVo );
	}
	
}
