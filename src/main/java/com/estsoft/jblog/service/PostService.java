package com.estsoft.jblog.service;

import java.util.List;

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
	
	public List<PostVo> getPostList(Long category_no){
		return postDao.getPostList(category_no);
	}
	
	public PostVo get(Long no){
		PostVo vo = new PostVo();
		vo.setNo(no);
		
		vo = postDao.get(vo);
		
		return vo;
	}
	
	public void delete(Long no){
		PostVo vo = new PostVo();
		vo.setNo(no);
		
		postDao.delete(vo);
	}
	
	
}
