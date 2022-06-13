package com.ty.foodOrder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.foodOrder.dto.User;
import com.ty.foodOrder.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService ;
	
	@RequestMapping("/loaduser")
	public ModelAndView loadUser() {
		ModelAndView modelAndView = new ModelAndView("loaduser.jsp");
		modelAndView.addObject("user" , new User()) ;
		return modelAndView ;
	}
	
	@RequestMapping("/saveuser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		boolean res = userService.addUser(user) ;
		ModelAndView modelAndView = new ModelAndView("adminmenu.jsp");
		if(res) {
			
			modelAndView.addObject("msg" , "user added successfully") ;
			return modelAndView ;
		}else {
			modelAndView.addObject("msg" , "user not added ") ;
			return modelAndView ;
		}
	}
	
	@RequestMapping("/displayusers")
	public ModelAndView allUsers() {
		List<User> users = userService.getAllUsers() ;
		ModelAndView modelAndView = new ModelAndView("displayuser.jsp");
		modelAndView.addObject("users" , users) ;
		return modelAndView ;
	}
	
	@RequestMapping("/edituser")
	public ModelAndView editUser(@RequestParam(name = "id") int id) {
		User user = userService.getUserById(id) ;
		ModelAndView modelAndView = new ModelAndView("edituser.jsp");
		modelAndView.addObject("user" , user) ;
		return modelAndView ;
	}
	@RequestMapping("/updateuser")
	public ModelAndView updateUser(@ModelAttribute User user) {
		userService.updateUser(user.getId(), user) ;
		ModelAndView modelAndView = new ModelAndView("displayusers");
		modelAndView.addObject("msg" , "user updated successfully") ;
		return modelAndView ;
	}
	
	@RequestMapping("/deleteuser")
	public ModelAndView deleteUser(@RequestParam(name = "id") int id) {
		userService.deletUser(id) ;
		ModelAndView modelAndView = new ModelAndView("displayusers");
		modelAndView.addObject("msg" , "user deleted successfully") ;
		return modelAndView ;
	}
	
	@RequestMapping("/userlogin")
	public ModelAndView loginAdmin(@RequestParam(name = "email")String email ,@RequestParam(name = "password")String password) {
		boolean res = userService.validateUser(email, password) ;
		if(res) {
			ModelAndView modelAndView = new ModelAndView("usermenu.jsp") ;
			modelAndView.addObject("msg" ,"log in successful") ;
			return modelAndView ;
		}else {
			ModelAndView modelAndView = new ModelAndView("userlogin") ;
			modelAndView.addObject("msg" ,"log in failed") ;
			return modelAndView ;
		}
	}
}
