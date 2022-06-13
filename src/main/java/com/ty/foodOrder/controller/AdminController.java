package com.ty.foodOrder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.foodOrder.dto.Admin;
import com.ty.foodOrder.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService ;
	
	@RequestMapping("/loadadmin")
	public ModelAndView loadAdmin() {
		ModelAndView modelAndView = new ModelAndView("loadadmin.jsp");
		modelAndView.addObject("admin" , new Admin()) ;
		return modelAndView ;
	}
	
	@RequestMapping("/saveadmin")
	public ModelAndView saveAdmin(@ModelAttribute Admin admin) {
		adminService.saveAdmin(admin);
		ModelAndView modelAndView = new ModelAndView("loadadmin");
		modelAndView.addObject("msg" , "admin added successfully") ;
		return modelAndView ;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginAdmin(@RequestParam(name = "email")String email ,@RequestParam(name = "password")String password) {
		boolean res = adminService.validateAdmin(email, password) ;
		if(res) {
			ModelAndView modelAndView = new ModelAndView("adminmenu.jsp") ;
			modelAndView.addObject("msg" ,"log in successful") ;
			return modelAndView ;
		}else {
			ModelAndView modelAndView = new ModelAndView("login") ;
			modelAndView.addObject("msg" ,"log in failed successful") ;
			return modelAndView ;
		}
	}
	
}
