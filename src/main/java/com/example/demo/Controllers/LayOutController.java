package com.example.demo.Controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Services.DangKyService;
import com.example.demo.Services.LayOutService;
import com.example.demo.dto.DienThoaiDTO;
import com.example.demo.dto.LayOutDTO;
import com.example.demo.models.DienThoai;
import com.example.demo.models.LayOut;

@Controller
@RequestMapping("/LayOut")
public class LayOutController {
	@Autowired
	LayOutService layOutService;
	@Autowired
	DangKyService dangKyService;
	public long random() {
		Random rd = new Random();
		long longNumber = rd.nextLong();
		if(longNumber<0) {return (-1*longNumber);}
		return longNumber;
	}
@RequestMapping("/")
@PreAuthorize (" hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN') ")
public String layout(ModelMap model,HttpSession session) {
	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username="";
	
	    username = ((UserDetails) principal).getUsername();
	    String vaitro ="";
	    vaitro=layOutService.tenvt(username);
	session.setAttribute("user",username);
	session.setAttribute("vaitro",vaitro);
	System.out.println("day la user"+username);
	model.addAttribute("anh1",layOutService.findById((long)1).get().getTenanh());
	model.addAttribute("anh2",layOutService.findById((long)2).get().getTenanh());
	model.addAttribute("anh3",layOutService.findById((long)3).get().getTenanh());
	return "layout/main-layout1";
	
}

@RequestMapping("/save1")
public String layoutsave1(ModelMap model,
		@ModelAttribute("dto1")LayOutDTO dto1) {
	LayOut layout1=null;
	String image1="anh3.png";
	Path path=Paths.get("uploads/");
	
	
			if(dto1.getTenanh().isEmpty()) {
				
			}else {
			try {
				
			InputStream inputStream=dto1.getTenanh().getInputStream();
				Files.copy(inputStream,path.resolve(dto1.getTenanh().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			image1=dto1.getTenanh().getOriginalFilename().toString();
			layout1=new LayOut((long)1,image1);
            layOutService.save(layout1);
		} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace(); 
			}
			
		}
	return "redirect:/LayOut/edit";
}
@RequestMapping("/save2")
public String layoutsave2(ModelMap model,
		@ModelAttribute("dto2")LayOutDTO dto2){
	LayOut layout2=null;
	String image2="anh4.png";
	Path path=Paths.get("uploads/");
	
		if(dto2.getTenanh().isEmpty()) {
				
		}else {
		try {
			System.out.println("toi6");	
		InputStream inputStream=dto2.getTenanh().getInputStream();
			Files.copy(inputStream,path.resolve(dto2.getTenanh().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		image2=dto2.getTenanh().getOriginalFilename().toString();
		layout2=new LayOut((long)2,image2);
        layOutService.save(layout2);
	} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
		}
		
	}
	return "redirect:/LayOut/edit";
}
@RequestMapping("/save3")
public String layoutsave3(ModelMap model,
		@ModelAttribute("dto3")LayOutDTO dto3) {
	LayOut layout3=null;
	String image3="anh5.png";
	Path path=Paths.get("uploads/");
	
if(dto3.getTenanh().isEmpty()) {
	
		}else {
		try {
			
		InputStream inputStream=dto3.getTenanh().getInputStream();
			Files.copy(inputStream,path.resolve(dto3.getTenanh().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		image3=dto3.getTenanh().getOriginalFilename().toString();
		layout3=new LayOut((long)3,image3);
        layOutService.save(layout3);
	} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); 
		}
		
	}
	
			return "redirect:/LayOut/edit";
	
}
@RequestMapping("/edit")
public String layoutedit(ModelMap model) {
	model.addAttribute("anh1",layOutService.findById((long)1).get().getTenanh());
	model.addAttribute("anh2",layOutService.findById((long)2).get().getTenanh());
	model.addAttribute("anh3",layOutService.findById((long)3).get().getTenanh());
	LayOutDTO dto1=new LayOutDTO();
	model.addAttribute("dto1",dto1);
	
	LayOutDTO dto2=new LayOutDTO();
	model.addAttribute("dto2",dto2);
	
	LayOutDTO dto3=new LayOutDTO();
	model.addAttribute("dto3",dto3);
	model.addAttribute("action1","/LayOut/save1");
	model.addAttribute("action2","/LayOut/save2");
	model.addAttribute("action3","/LayOut/save3");
	return "slay/layout";
}
}
