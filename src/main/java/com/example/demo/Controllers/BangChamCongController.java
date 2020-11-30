package com.example.demo.Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.demo.Services.BangChamCongService;
import com.example.demo.Services.ChucVuService;
import com.example.demo.Services.DiLamService;
import com.example.demo.Services.EmployeeService;
import com.example.demo.Services.KhongDiLamService;
import com.example.demo.Services.PhongBanService;
import com.example.demo.Services.TangCaService;
import com.example.demo.models.BangChamCong;
import com.example.demo.models.ChucVu;
import com.example.demo.models.DiLam;
import com.example.demo.models.Employee;
import com.example.demo.models.KhongDiLam;
import com.example.demo.models.PhongBan;
import com.example.demo.models.TangCa;

@Controller
@RequestMapping("/BangChamCong")
public class BangChamCongController {
	@Autowired
	EmployeeService employeeService ;
	@Autowired
	PhongBanService PhongBanService;
	@Autowired
    ChucVuService ChucVuService;
	@Autowired
	BangChamCongService BangChamCongService ;
    @Autowired
    TangCaService tangCaService;
    @Autowired
    DiLamService diLamService;
    @Autowired 
    KhongDiLamService khongDiLamService;
	SimpleDateFormat dd=new SimpleDateFormat("dd/MM/yyyy");
	//SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd");
	//@PreAuthorize ("hasPermission ('','/BangChamCong/')")
	@RequestMapping("/")
	@PreAuthorize (" hasPermission ('','/BangChamCong/saveorupdate') or hasRole('ROLE_ADMIN')")
	public String index(Model model) {
		BangChamCong dto=new BangChamCong();
		model.addAttribute("BangChamCong",dto);
		model.addAttribute("action","/BangChamCong/saveorupdate");
		model.addAttribute("ngay",dd.format(new Date()));
		System.out.println(dd.format(new Date()));
		return "register-BangChamCong";
	}
	
	@ModelAttribute(name="nhanvien")
	public List<Employee> getAll1(){
		
	return  (List<Employee>) employeeService.getAll();
	}
	@ModelAttribute(name="nhanvienid")
	public List<String> getAll7(){
		List<String> ak=new ArrayList();
		for(int ik=0;ik<employeeService.getAll().size();ik++) {
			ak.add(Long.toString(employeeService.getAll().get(ik).getId()));
		}
	return  (List<String>) ak;
	}
	@ModelAttribute(name="phongban")
	public List<PhongBan> getAll2(){
		
	return  (List<PhongBan>) PhongBanService.getAll();
	}
	@ModelAttribute(name="chucvu")
	public List<ChucVu> getAll3(){
		
	return  (List<ChucVu>) ChucVuService.findAll();
	}
	@ModelAttribute(name="KhongDiLam")
	public List<KhongDiLam> getAll9(){
		
	return  (List<KhongDiLam>) khongDiLamService.getAll();
	}
	@ModelAttribute(name="DiLam")
	public List<DiLam> getAll8(){
		
	return  (List<DiLam>) diLamService.getAll();
	}
	@ModelAttribute(name="tangca")
	public List<TangCa> getAll4(){
		
	return  (List<TangCa>) tangCaService.getAll();
	}
	public long random() {
		Random rd = new Random();
		long longNumber = rd.nextLong();
		if(longNumber<0) {return (-1*longNumber);}
		return longNumber;
	}
	//Kiem Tra Loi
	//tat ca loi co the xay ra
	//chon dong tren trang
	//hien thi tong so
	//tim kiem giu lai
	//
	@PostMapping("/saveorupdate")
	@PostAuthorize (" hasPermission ('','/BangChamCong/saveorupdate') or hasRole('ROLE_ADMIN')")
	public String save(ModelMap model,@RequestParam(value="id",defaultValue="-1")List<Long> lid,@RequestParam(value="tangca",defaultValue="-1")List<Integer> tc,
			@RequestParam(value="dilam",defaultValue="-1")List<Long> ll,@RequestParam(value="khongdilam",defaultValue="-1")List<Long> ll1
			,@RequestParam(value="ngaycham",defaultValue="")String ngaycham) throws ParseException {
		if(BangChamCongService.getAll1(dd.parse(ngaycham)).size()>0) {
			return "redirect:/BangChamCong/";	
		}
		BangChamCong BangChamCong=new BangChamCong();
		TangCa tangca=new TangCa();
		System.out.println("kich ko "+ll.size());
		if(lid.get(0)==-1) {}else {
			for(int ii=0;ii<lid.size();ii++) {
				
			}
		}
		
		for(int i=0;i<ll.size();i++) {
			for(int j=0;j<employeeService.getAll().size();j++) {
				if(ll.get(i)==employeeService.getAll().get(j).getId()) {
					BangChamCong.setId(random());
					BangChamCong.setIsdelete(0);
					BangChamCong.setIdemployee(ll.get(i));
					BangChamCong.setNgaycham(dd.parse(ngaycham));
					BangChamCong.setTinhtrang(1);
					BangChamCongService.save(BangChamCong);
				}
			}
		
	}
		BangChamCong BangChamCong1=new BangChamCong();
		if(ll1.get(0)==-1) {}else {
		for(int i=0;i<ll1.size();i++) {
			for(int j=0;j<employeeService.getAll().size();j++) {
				if(ll1.get(i)==employeeService.getAll().get(j).getId()) {
					BangChamCong1.setId(random());
					BangChamCong1.setIsdelete(0);
					BangChamCong1.setIdemployee(ll1.get(i));
					BangChamCong1.setNgaycham(dd.parse(ngaycham));
					BangChamCong1.setTinhtrang(2);
					BangChamCongService.save(BangChamCong1);
				}
			}
		}
	}
		
		return "redirect:/BangChamCong/";		
		}
	@PostMapping("/update")
	@PostAuthorize (" hasPermission ('','/BangChamCong/saveorupdate') or hasRole('ROLE_ADMIN')")
	public String update(ModelMap model,@RequestParam(value="id",defaultValue="-1")List<Long> lid,@RequestParam(value="tangca",defaultValue="-1")List<Integer> tc,
			@RequestParam(value="dilam",defaultValue="-1")List<Long> ll,@RequestParam(value="khongdilam",defaultValue="-1")List<Long> ll1
			,@RequestParam("ngaycham")String ngaycham) throws ParseException {
		BangChamCong BangChamCong=new BangChamCong();
		TangCa tangca=new TangCa();
		System.out.println("kich ko "+ll.size());
		if(lid.get(0)==-1) {}else {
			for(int ii=0;ii<lid.size();ii++) {
				
			}
		}
		
		for(int i=0;i<ll.size();i++) {
			for(int j=0;j<employeeService.getAll().size();j++) {
				if(ll.get(i)==employeeService.getAll().get(j).getId()) {
					long idemployee=BangChamCongService.getid(ll.get(i), dd.parse(ngaycham)).get().getId();
					BangChamCong.setId(idemployee);
					BangChamCong.setIsdelete(0);
					BangChamCong.setIdemployee(ll.get(i));
					BangChamCong.setNgaycham(dd.parse(ngaycham));
					BangChamCong.setTinhtrang(1);
					BangChamCongService.save(BangChamCong);
				}
			}
		
	}
		BangChamCong BangChamCong1=new BangChamCong();
		if(ll1.get(0)==-1) {}else {
		for(int i=0;i<ll1.size();i++) {
			for(int j=0;j<employeeService.getAll().size();j++) {
				if(ll1.get(i)==employeeService.getAll().get(j).getId()) {
					long idemployee1=BangChamCongService.getid(ll1.get(i), dd.parse(ngaycham)).get().getId();
					BangChamCong1.setId(idemployee1);
					BangChamCong1.setIsdelete(0);
					BangChamCong1.setIdemployee(ll1.get(i));
					BangChamCong1.setNgaycham(dd.parse(ngaycham));
					BangChamCong1.setTinhtrang(2);
					BangChamCongService.save(BangChamCong1);
				}
			}
		}
	}
		
	    
		return "redirect:/BangChamCong/";
		}
	@RequestMapping("/view")
	@PreAuthorize ("hasPermission ('','/BangChamCong/view') or hasPermission ('','/BangChamCong/saveorupdate') or hasRole('ROLE_ADMIN')")
	public String view(ModelMap model) {
		model.addAttribute("BangChamCong",BangChamCongService.getAll1(new Date()));
		model.addAttribute("ngay",dd.format(new Date()));
		return "view-BangChamCong";
	}
	@RequestMapping("/edit")
	public String edit(ModelMap model,@RequestParam("ngaysua")String  ngaysua) throws ParseException {
		model.addAttribute("BangChamCong",BangChamCongService.getAll1(dd.parse(ngaysua)));
		model.addAttribute("ngay",ngaysua);
		model.addAttribute("action","/BangChamCong/update");
		return "register-BangChamCong";
	}
	@RequestMapping("/ngaycham")
	public String ngaycham(ModelMap model,@RequestParam("ngaycham")String  ngaycham) throws ParseException {
		model.addAttribute("BangChamCong",BangChamCongService.getAll1(dd.parse(ngaycham)));
		model.addAttribute("ngay",ngaycham);
		return "view-BangChamCong";
	}
	@RequestMapping("/ngay")
	public String ngay(ModelMap model,@RequestParam("ngaycham")String  ngaycham) throws ParseException {
		
		model.addAttribute("ngay",ngaycham);
		
		BangChamCong dto=new BangChamCong();
		model.addAttribute("BangChamCong",dto);
		model.addAttribute("action","/BangChamCong/saveorupdate");
		
		
		return "register-BangChamCong";
	}
	public String xuly(String name) {
	name.trim();
	String tim="";
	List<String> T=new ArrayList<>();
	String[] words = name.split("\\s");
	for (String w : words) {
		   System.out.println(w);
		   T.add(w);
	}
	for(int i=0;i<T.size();i++) {
		if(i==T.size()-1) {
			tim=tim+T.get(i);
		}else {
		tim=tim+T.get(i)+"|" ;
		}
	}
	 System.out.println("so ls: "+ tim);
				return tim;
	}
	
}
