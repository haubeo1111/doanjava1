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

import com.example.demo.Repository.DiLamRepository;
import com.example.demo.Services.DiLamService;
import com.example.demo.Services.EmployeeService;
import com.example.demo.models.DiLam;
import com.example.demo.models.Employee;

@Controller
@RequestMapping("/DiLam")
public class DiLamController {
@Autowired
DiLamService DiLamService;
@Autowired
EmployeeService EmployeeService;
@ModelAttribute("employee")
public List<Employee> getall1(){
	return EmployeeService.getAll();
}
SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
@RequestMapping("/")
public String index(Model model) {
	DiLam dto=new DiLam();
	model.addAttribute("DiLam",dto);
	model.addAttribute("action","/DiLam/saveorupdate");
	return "register-DiLam";
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
public String save(ModelMap model,@ModelAttribute("DiLam")DiLam DiLam) {
	DiLam.setId(random());
	DiLam.setIsdelete(0);
	DiLamService.save(DiLam);
    DiLam u=new DiLam();
	model.addAttribute("DiLam",u);
	return "register-DiLam";
	
	}
@PostMapping("/update")
public String update(ModelMap model,@ModelAttribute("DiLam")DiLam DiLam) {
	//DiLamService.update(DiLam.getName(),DiLam.getGender(),DiLam.getBirthday(),DiLam.getEmail()
		//	,DiLam.getPhone(),DiLam.getPassword(),DiLam.getAddress(),DiLam.getId());
	DiLamService.save(DiLam);
	model.addAttribute("DiLam",DiLam);
	return "register-DiLam";

	}
@RequestMapping("/data/{id}")
public String data(ModelMap model,@PathVariable(name="id")long id) {
	 DiLam dilam=new DiLam();
	 dilam.setIdnhanvien(id);
	 dilam.setNgaydilam(new Date());
	model.addAttribute("DiLam",dilam);
	
	model.addAttribute("action", "/DiLam/saveorupdate");
	
return "register-DiLam";
}
@RequestMapping("/edit/{id}")
public String edit(ModelMap model,@PathVariable(name="id")long id) {
	Optional<DiLam> u= DiLamService.findById(id);
	if(u.isPresent()) {
		model.addAttribute("DiLam", u.get());
	}else {
		model.addAttribute("DiLam", new DiLam());
	}
	model.addAttribute("action", "/DiLam/update");
	
return "register-DiLam";
}
 @Autowired
    JdbcTemplate jdbcT;
@RequestMapping("/delete/{id}")
public String delete(ModelMap model,@PathVariable(name="id")long id
		,HttpServletRequest request,RedirectAttributes redirect) {

 String sql="update DiLam set isdelete=1 where id=?";
 DiLam DiLam=new  DiLam(id);
 jdbcT.update(sql,new Object[] {DiLam.getId()});
request.getSession().setAttribute("employeelist", null);
 redirect.addAttribute("id", 1);
return "redirect:/DiLam/page/{id}";
}
@RequestMapping("/xoanhieu")
public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
		HttpServletRequest request,RedirectAttributes redirect) {
	for(int i=0;i<ll.size();i++) {
		
		Long g=ll.get(i);
		 String sql="update DiLam set isdelete=1 where id=?";
		 DiLam DiLam =new  DiLam(g);
		 jdbcT.update(sql,new Object[] {DiLam.getId()});
		//employeeService.isdelete(g);
	}
	
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1);
	 
	return "redirect:/DiLam/page/{id}";
}
@GetMapping("/page")
public String index(Model model,HttpServletRequest request
		,RedirectAttributes redirect) {
	request.getSession().setAttribute("employeelist", null);
	
	 redirect.addAttribute("id", 1);
	
	return "redirect:/DiLam/page/{id}";
}
@GetMapping("/page/{pageNumber}")
public String showEmployeePage(HttpServletRequest request, 
		@PathVariable int pageNumber, Model model) {
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
	int pagesize = 3;
	//model.addAttribute("customer",customerService.findAll());
	List<DiLam> list =(List<DiLam>) DiLamService.getAll();
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
	String baseUrl = "/DiLam/page/";

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);
	model.addAttribute("totalPageCount", totalPageCount);
	model.addAttribute("baseUrl", baseUrl);
	model.addAttribute("employees", pages);

	return "view-DiLam";
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
		return "/DiLam/page";	
	}	
	List<DiLam> list = DiLamService.findup(xuly(s));	
	if (list == null) {	
		return "/DiLam/page";	
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
	String baseUrl = "/DiLam/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-DiLam";	
}
@GetMapping("/search/pageNumber")	
public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
		) {	
	if (s.equals("")) {	
		return "/DiLam/page";	
	}	
	List<DiLam> list = DiLamService.getAll();	
	if (list == null) {	
		return "/DiLam/page";	
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
	String baseUrl = "/DiLam/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-DiLam";	
}
}
