package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SlayController {
@RequestMapping("/slay/")
public String slay(ModelMap model) {
	model.addAttribute("anh","cuahang.jpg");
	return "slay/slay2";
}
}
