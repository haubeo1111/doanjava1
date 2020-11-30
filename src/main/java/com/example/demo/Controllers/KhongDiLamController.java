package com.example.demo.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.jdbc.core.JdbcTemplate;
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

import com.example.demo.Services.EmployeeService;
import com.example.demo.Services.KhongDiLamService;
import com.example.demo.models.Employee;
import com.example.demo.models.KhongDiLam;


@Controller
@RequestMapping("/KhongDiLam")
public class KhongDiLamController {
	@Autowired
	KhongDiLamService KhongDiLamService;
	@Autowired
	EmployeeService EmployeeService;
	@ModelAttribute("employee")
	public List<Employee> getall1(){
		return EmployeeService.getAll();
	}
	SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
	@RequestMapping("/")
	public String index(Model model) {
		KhongDiLam dto=new KhongDiLam();
		model.addAttribute("KhongDiLam",dto);
		model.addAttribute("action","/KhongDiLam/saveorupdate");
		return "register-KhongDiLam";
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
	public String save(ModelMap model,@ModelAttribute("KhongDiLam")KhongDiLam KhongDiLam) {
		KhongDiLam.setId(random());
		KhongDiLam.setIsdelete(0);
		KhongDiLamService.save(KhongDiLam);
	    KhongDiLam u=new KhongDiLam();
		model.addAttribute("KhongDiLam",u);
		return "register-KhongDiLam";
		
		}
	@PostMapping("/update")
	public String update(ModelMap model,@ModelAttribute("KhongDiLam")KhongDiLam KhongDiLam) {
		//KhongDiLamService.update(KhongDiLam.getName(),KhongDiLam.getGender(),KhongDiLam.getBirthday(),KhongDiLam.getEmail()
			//	,KhongDiLam.getPhone(),KhongDiLam.getPassword(),KhongDiLam.getAddress(),KhongDiLam.getId());
		KhongDiLamService.save(KhongDiLam);
		model.addAttribute("KhongDiLam",KhongDiLam);
		return "register-KhongDiLam";

		}
	@RequestMapping("/data/{id}")
	public String data(ModelMap model,@PathVariable(name="id")long id) {
		 KhongDiLam KhongDiLam=new KhongDiLam();
		 KhongDiLam.setIdnhanvien(id);
		 KhongDiLam.setNgaykhongdilam(new Date());
		model.addAttribute("KhongDiLam",KhongDiLam);
		
		model.addAttribute("action", "/KhongDiLam/saveorupdate");
		
	return "register-KhongDiLam";
	}
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")long id) {
		Optional<KhongDiLam> u= KhongDiLamService.findById(id);
		if(u.isPresent()) {
			model.addAttribute("KhongDiLam", u.get());
		}else {
			model.addAttribute("KhongDiLam", new KhongDiLam());
		}
		model.addAttribute("action", "/KhongDiLam/update");
		
	return "register-KhongDiLam";
	}
	 @Autowired
	    JdbcTemplate jdbcT;
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id")long id
			,HttpServletRequest request,RedirectAttributes redirect) {

	 String sql="update KhongDiLam set isdelete=1 where id=?";
	 KhongDiLam KhongDiLam=new  KhongDiLam(id);
	 jdbcT.update(sql,new Object[] {KhongDiLam.getId()});
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1);
	return "redirect:/KhongDiLam/page/{id}";
	}
	@RequestMapping("/xoanhieu")
	public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
			HttpServletRequest request,RedirectAttributes redirect) {
		for(int i=0;i<ll.size();i++) {
			
			Long g=ll.get(i);
			 String sql="update KhongDiLam set isdelete=1 where id=?";
			 KhongDiLam KhongDiLam =new  KhongDiLam(g);
			 jdbcT.update(sql,new Object[] {KhongDiLam.getId()});
			//employeeService.isdelete(g);
		}
		
		request.getSession().setAttribute("employeelist", null);
		 redirect.addAttribute("id", 1);
		 
		return "redirect:/KhongDiLam/page/{id}";
	}
	@GetMapping("/page")
	public String index(Model model,HttpServletRequest request
			,RedirectAttributes redirect) {
		request.getSession().setAttribute("employeelist", null);
		
		 redirect.addAttribute("id", 1);
		
		return "redirect:/KhongDiLam/page/{id}";
	}
	@GetMapping("/page/{pageNumber}")
	public String showEmployeePage(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
		int pagesize = 3;
		//model.addAttribute("customer",customerService.findAll());
		List<KhongDiLam> list =(List<KhongDiLam>) KhongDiLamService.getAll();
		System.out.println(list.size());
		if (pages == null) {
			pages = new PagedListHolder<>(list);
			pages.setPageSize(pagesize);
		} else {
			final int goToPage = pageNumber - 1;
			if (goToPage <= pages.getPageCount() && goToPage >= 0) {
				pages.setPage(goToPage);
			}
		}
		request.getSession().setAttribute("employeelist", pages);
		int current = pages.getPage() + 1;
		int begin = Math.max(1, current - list.size());
		int end = Math.min(begin + 5, pages.getPageCount());
		int totalPageCount = pages.getPageCount();
		String baseUrl = "/KhongDiLam/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("employees", pages);

		return "view-KhongDiLam";
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
	@GetMapping("/search")	
	public String search(@RequestParam("s") String s, Model model, HttpServletRequest request	
		) {	
		if (s.equals("")) {	
			return "/KhongDiLam/page";	
		}	
		List<KhongDiLam> list = KhongDiLamService.findup(xuly(s));	
		if (list == null) {	
			return "/KhongDiLam/page";	
		}	
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");	
		int pagesize = 3;	
		pages = new PagedListHolder<>(list);	
		pages.setPageSize(pagesize);	
			
		//final int goToPage = pageNumber - 1;	
		//if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
		//	pages.setPage(goToPage);	
		//}	
		//request.getSession().setAttribute("employeelist", pages);	
		int current = pages.getPage() + 1;	
		int begin = Math.max(1, current - list.size());	
		int end = Math.min(begin + 5, pages.getPageCount());	
		int totalPageCount = pages.getPageCount();	
		String baseUrl = "/KhongDiLam/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-KhongDiLam";	
	}
	@GetMapping("/search/pageNumber")	
	public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
			) {	
		if (s.equals("")) {	
			return "/KhongDiLam/page";	
		}	
		List<KhongDiLam> list = KhongDiLamService.getAll();	
		if (list == null) {	
			return "/KhongDiLam/page";	
		}	
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");	
		int pagesize = 3;	
		pages = new PagedListHolder<>(list);	
		pages.setPageSize(pagesize);	
			
		final int goToPage = Integer.parseInt(s) - 1;	
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
			pages.setPage(goToPage);	
		}	
		request.getSession().setAttribute("employeelist", pages);	
		int current = pages.getPage() + 1;	
		int begin = Math.max(1, current - list.size());	
		int end = Math.min(begin + 5, pages.getPageCount());	
		int totalPageCount = pages.getPageCount();	
		String baseUrl = "/KhongDiLam/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-KhongDiLam";	
	}
}
