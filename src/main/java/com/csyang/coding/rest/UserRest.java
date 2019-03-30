package com.csyang.coding.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csyang.coding.bean.User;
import com.csyang.coding.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "rest测试", tags = { "测试接口" })
@RestController
public class UserRest {
	
	@Autowired
	private UserService userService;

	@ApiOperation("查询用户信息借口")
	@GetMapping("/getAllUser")
	public List<User> getAllUser() throws Exception{
		return userService.getAllUser();
	}
}
