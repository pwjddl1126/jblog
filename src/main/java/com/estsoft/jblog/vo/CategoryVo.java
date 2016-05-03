package com.estsoft.jblog.vo;

public class CategoryVo {

	private long no;
	private String name;
	private String description;
	private String reg_date;
	private long post_count;
	private long blog_no;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public long getPost_count() {
		return post_count;
	}
	public void setPost_count(long post_count) {
		this.post_count = post_count;
	}
	public long getBlog_no() {
		return blog_no;
	}
	public void setBlog_no(long blog_no) {
		this.blog_no = blog_no;
	}
	
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", description="
				+ description + ", reg_date=" + reg_date + ", post_count="
				+ post_count + ", blog_no=" + blog_no + "]";
	}
	
	
}
