package com.yjk.dao;

import java.util.List;

import com.yjk.pojo.User;

public interface UserDao {
	//查询全部
	public List<User> getlist();
	
	public List<User> get();
}
