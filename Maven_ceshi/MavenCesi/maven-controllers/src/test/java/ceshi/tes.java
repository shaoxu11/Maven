package ceshi;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sx.pojo.User;
import com.sx.service.userService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class tes {
	@Autowired
	private userService us;
	
	/**
	 * 查询全部用户信息
	 */
	@Test
	public void test() {
		List<User> list = us.allUser();
		for(User u:list) {
			System.out.println(u.getName());
		}
	}
	//模糊查询
	@Test
	public void mohu() {
		List<User> list = us.mohu("张",0);//String int 
		for(User u:list) {
			System.out.println(u.getName());
		}
		
	}
	//根据用户id 查询用户信息 用于修改回显
	@Test
	public void update() {
		User user = us.byidUser(1);//int
		System.out.println(user.getName());
	}
	//用户修改
	@Test
	public void modify() {
		User user = new User();
		user.setAge(1);				//int	年龄
		user.setDepartment_id(1);	//int 部门
		user.setGender(1);			//int  性别
		user.setId(1);				//用户id
		user.setName("张三2");		//用户名
		int row =us.modify(user);	//User对象
		System.out.println("修改结果:"+row);
	}
	//添加用户
	@Test
	public void add() {
		User user = new User();
		user.setAge(1);				//int	年龄
		user.setDepartment_id(1);	//int 部门
		user.setGender(1);			//int  性别
		user.setName("张三2");		//用户名
		int row = us.add(user);	//User对象
		System.out.println("添加结果:"+row);
	}
	
}
