package com.sx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sx.pojo.User;
import com.sx.service.userService;
@Controller
public class indexController {
	@Autowired
	private userService us;
	@RequestMapping({"/index","/"})
	public String index(Model model) {
		System.out.println("进入controller");
		List<User> list = us.allUser();
		for(User u:list) {
			System.out.println(u.getName());
		}
		model.addAttribute("user",list );
		return "index";
	}
	
	//模糊查询
	@RequestMapping("/mohu")
	public String mohu(String name ,int department_id,Model model) {
		System.out.println("模糊查询");
		List<User> list = us.mohu(name,department_id);
		model.addAttribute("user",list );
		return "index";
	}
	//删除
	@RequestMapping("/del")
	@ResponseBody
	public Map<String,String> del(int id){
		Map<String, String> map = new HashMap<String, String>();
		int row = us.del(id);
		if(row <1) {
			map.put("type", "error");
			map.put("msg", "删除失败!");
			return map;
			
		}
		map.put("type", "success");
		map.put("msg", "删除成功!");
		return map;
		
	}
	//跳转至修改页面
	@RequestMapping("update")
	public String update(int id,Model model) {
		User user = us.byidUser(id);
		model.addAttribute("user", user);
		return "update";
	}
	//跳转至添加页面
	@RequestMapping("add")
	public String add() {
		return "update";
	}
	//修改
	@RequestMapping("modify")
	@ResponseBody
	public Map<String, String> modify(Model model,User user){
		Map<String, String> map = new HashMap<String, String>();
		if(user.getId()==0) {
			int row = us.add(user);
			if(row>0){
				map.put("type", "success");
				map.put("msg", "添加成功!");
				return map;
			}else {
				map.put("type", "error");
				map.put("msg", "添加失败!");
				return map;
			}
		}else {
			int row = us.modify(user);
			if(row>0){
				map.put("type", "success");
				map.put("msg", "修改成功!");
				return map;
			}else {
				map.put("type", "error");
				map.put("msg", "修改失败!");
				return map;
			}
		}
	}
	@RequestMapping("MyJsp")
	public String MyJsp() {
		return "MyJsp";
	}

}
