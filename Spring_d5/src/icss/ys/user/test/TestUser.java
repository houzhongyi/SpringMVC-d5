package icss.ys.user.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import icss.ys.user.controller.UserController;
import icss.ys.user.pojo.Users;

public class TestUser {
	@Test
	public void login(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserController c = (UserController)ac.getBean("userController");
//		System.out.println(c.getService().updateUser(new Users("a888888","888888")));
		List<Users> list = c.getService().showUsers();
		for (Users users : list) {
			System.out.println(users);
		}
		//测试插入多条数据
		c.getService().insertAll();
		//DispatcherServlet
	}
}
