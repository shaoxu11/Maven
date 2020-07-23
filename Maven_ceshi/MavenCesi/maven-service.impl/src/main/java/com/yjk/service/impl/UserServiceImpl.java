package com.yjk.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjk.dao.UserDao;
import com.yjk.pojo.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public List<User> getlist() {
		// TODO Auto-generated method stub
		return userDao.getlist();
	}
	@Override
	public List<User> get() {
		// TODO Auto-generated method stub
		return userDao.get();
	}
	
}
