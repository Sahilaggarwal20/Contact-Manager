package com.contact.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contact.Repository.Crepo;
import com.contact.entity.User;

@Controller
@RequestMapping("/user")
public class UserControl {
	@Autowired
	private Crepo crepo;
	@RequestMapping("/index")
public String dashboard(Model model,Principal principal) {
	
	String username = principal.getName();
	System.out.println("username: "+username);
	
	User userByUserName = crepo.getUserByUserName(username);
	System.out.println(userByUserName);
	
	 model.addAttribute("user",userByUserName);
		return "Normal/user_dash";
}
}
