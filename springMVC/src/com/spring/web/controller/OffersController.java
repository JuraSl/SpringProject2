package com.spring.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// marks this class as Controller.
@Controller
public class OffersController {

	/*
	// annotation is used to map the class with the specified URL name.
	@RequestMapping("/")
	public ModelAndView showHome(){
		ModelAndView mv = new ModelAndView("home");
		Map<String, Object> model = mv.getModel();
		model.put("name", "Rome");
		
	return mv;
	}*/
	
	public String showHome(Model model){
		model.addAttribute("name", "Dublin");
		
		return "home";
	}
}
