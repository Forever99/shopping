package cn.edu.zhku.shopping.store.domain;

import cn.edu.zhku.shopping.user.domain.User;

public class Store {

	private String sid;//主键
	private String sname;//店铺名称
	
	private User user;//所属用户

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
