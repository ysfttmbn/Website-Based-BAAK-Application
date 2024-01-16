package com.example.Kel02.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Kel02.model.User;
import com.example.Kel02.service.RegistrasiService;

@Controller
public class RegistrasiController {
	@Autowired
    private RegistrasiService userService;

                                   
    @GetMapping("/register")
           
    public ModelAndView register() {
    	ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user ) {
    	User oauthUser = userService.register(user.getUsername(), user.getPassword(),user.getRoles(),user.getKtp(),user.getNim(),user.getNama(),user.getHp());

    	if(Objects.nonNull(oauthUser)) 
    	{	
    		return "redirect:/login";
    	}else {
    		return "redirect:/register";
    	}
    }
}