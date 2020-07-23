package com.yjk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjk.pojo.User;
import com.yjk.service.impl.UserService;

@Controller
public class IndexController {
	
	@Autowired
	UserService userService;
	@RequestMapping({"index","/"})
	public String index() {
		return "index";
		
	}
	@RequestMapping("/getlist")
	public String getlsit() {
		
		List<User>getList=userService.getlist();
		for (User user : getList) {
			System.out.println(user.getUser_address());
		}
		return "index";
	}
}
