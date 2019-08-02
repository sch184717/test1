package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.User;
import com.jt.service.UserService;
@Controller
public class UserController {
	@Autowired
 private UserService userService;
	//url:localhost:8090/user/findAll
	@RequestMapping("/findAll")
	public String userList(Model model) {
		List<User> userList = 
				userService.findAll();
		model.addAttribute("userList",userList);
		return "userList";//页面逻辑名称
	}
	//1.当用户访问localhost:8090/userList,要求直接跳转userList.jsp页面
	@RequestMapping("/user")
	public String doUser() {
		return"userList-ajax";
	}
	//2.获取userListJSON数据返回给页面
	@RequestMapping("/userList-ajax")
	@ResponseBody
	public List<User> findList_ajax(){
		List<User> userList=userService.findAll();
		return userList;
	}
	
}
