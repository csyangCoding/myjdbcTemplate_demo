package com.csyang.coding.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.csyang.coding.MyjdbctemplateApplication;
import com.csyang.coding.bean.User;
import com.csyang.coding.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=MyjdbctemplateApplication.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testGetAllUser()
	{
		List<User> list = userService.getAllUser();
		for (User user : list) {
			System.out.println(user.getName());
		}
	}
}
