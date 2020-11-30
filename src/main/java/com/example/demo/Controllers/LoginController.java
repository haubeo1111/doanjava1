package com.example.demo.Controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LoginController {
/*@GetMapping("/")
	    public String index() {
	        return "index1";
	    }

	    @GetMapping("/admin") 
	    public String admin() {
	        return "admin";
	    }

	    @GetMapping("/403")
	    public String accessDenied() {
	        return "403";
	    }

	    @GetMapping("/Login") 
	    public String getLogin() {
	        return "Login";
	    }
	    @GetMapping("/Logout")
	    public String logout(HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) {
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	        return "redirect:/";
	    }*/
	    }