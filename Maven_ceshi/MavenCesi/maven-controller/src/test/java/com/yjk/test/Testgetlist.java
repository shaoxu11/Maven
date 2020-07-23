package com.yjk.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yjk.pojo.User;
import com.yjk.service.impl.UserService;

public class Testgetlist {

	@Autowired
	UserService userservice;
	@Test
	public void testa() {
		System.out.println("cs");
		System.out.println("aa");
		List<User> lsit=userservice.get();
		for (User user : lsit) {
			System.out.println(user.getUser_name());
		}
	
	}
}
