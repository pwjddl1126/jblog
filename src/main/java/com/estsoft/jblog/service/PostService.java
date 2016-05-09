package com.estsoft.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estsoft.jblog.dao.PostDao;
import com.estsoft.jblog.vo.PostVo;

@Service
public class PostService {

	@Autowired
	PostDao postDao;
	
	public void write(PostVo postVo){
		postDao.write(postVo);
	}
	
	
}
