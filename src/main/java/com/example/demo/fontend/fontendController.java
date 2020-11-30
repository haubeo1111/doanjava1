package com.example.demo.fontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fontend")
public class fontendController {

	@RequestMapping("/")
	public String fontend() {
		return "fontend/index";
	}
	@RequestMapping("/temtown")
	public String fontend1() {
		return "temtown/index";
	}
}
