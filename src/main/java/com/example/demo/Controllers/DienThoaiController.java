package com.example.demo.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockMultipartFile;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Repository.DienThoaiRepository;
import com.example.demo.Repository.QuyenChucNang;
import com.example.demo.Services.DienThoaiService;
import com.example.demo.Services.LoaiDTService;
import com.example.demo.dto.DienThoaiDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.models.ChucVu;
import com.example.demo.models.DienThoai;
import com.example.demo.models.Employee;
import com.example.demo.models.LoaiDT;

@Controller
@RequestMapping("/DienThoai")
public class DienThoaiController {
@Autowired
DienThoaiService DienThoaiService;
@Autowired
LoaiDTService loaiDTService;
@Autowired
QuyenChucNang QuyenChucNang;
@PreAuthorize ("hasPermission ('','/DienThoai/saveorupdate') or hasRole('ROLE_ADMIN')")
@GetMapping("/")
public String index(Model model,HttpSession session) {
	
		System.out.println("hau map login");
		DienThoaiDTO dto=new DienThoaiDTO();
		model.addAttribute("dto",dto);
		model.addAttribute("action","/DienThoai/saveorupdate");
		return "register-dienthoai";
	
}

@ModelAttribute(name="loaidt")
public List<LoaiDT> getAll(){
	
return  (List<LoaiDT>) loaiDTService.getAll();
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
//@PostAuthorize ("hasPermission ('','/DienThoai/saveorupdate')")
@RequestMapping("/saveorupdate")
@PostAuthorize ("hasPermission ('','/DienThoai/saveorupdate') or hasRole('ROLE_ADMIN')")
public String save(ModelMap model,@ModelAttribute("dto")DienThoaiDTO dto,HttpSession session) {
	dto.setId(random());
	DienThoai staff=null;
	String image="logo.png";
	Path path=Paths.get("uploads/");
	if(dto.getHinhanh().isEmpty()) {
		}else {
			try {
			InputStream inputStream=dto.getHinhanh().getInputStream();
				Files.copy(inputStream,path.resolve(dto.getHinhanh().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			image=dto.getHinhanh().getOriginalFilename().toString();
		} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace(); 
			}
			}
			 staff=new DienThoai(dto.getId(),dto.getName(),dto.getMadt(),dto.getNgaynhap(),image,dto.getSoluong(),
						dto.getGiaban(),dto.getMaloaidt(),0);
             DienThoaiService.save(staff);
             DienThoaiService.clearCache();
			DienThoaiDTO dto1=new DienThoaiDTO();
			model.addAttribute("dto",dto1);
			return "register-dienthoai";
		}

@RequestMapping("/update")
@PreAuthorize ("hasPermission ('','/DienThoai/saveorupdate') or hasRole('ROLE_ADMIN')")
public String update(ModelMap model,@ModelAttribute("dto")DienThoaiDTO dto) {
Optional<DienThoai> optionalstaff=DienThoaiService.find(dto.getId());
	DienThoai staff=null;
	String image="logo.png";
   Path path=Paths.get("uploads/");
   
	if(optionalstaff.isPresent()) {
		if(dto.getHinhanh().isEmpty()) {
			image=optionalstaff.get().getHinhanh();
		}else {
			try {
			InputStream inputStream=dto.getHinhanh().getInputStream();
				Files.copy(inputStream,path.resolve(dto.getHinhanh().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			image=dto.getHinhanh().getOriginalFilename().toString();
			  
		} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace(); 
			}
			 
		}
	}else {
		DienThoaiDTO dto1=new DienThoaiDTO();
		model.addAttribute("dto",dto1);
		model.addAttribute("action","/DienThoai/saveorupdate");
		return "register-dienthoai";
	}
	staff=new DienThoai(dto.getId(),dto.getName(),dto.getMadt(),dto.getNgaynhap(),image,dto.getSoluong(),
			dto.getGiaban(),dto.getMaloaidt(),0);
	
DienThoaiService.save(staff);
			DienThoaiDTO dto1=new DienThoaiDTO();
			model.addAttribute("dto",dto1);
			model.addAttribute("action","/DienThoai/saveorupdate");
			return "register-dienthoai";
		
}
//@PreAuthorize ("hasPermission ('','/DienThoai/edit')")

@RequestMapping("/edit/{id}")
@PreAuthorize ("hasPermission ('','/DienThoai/saveorupdate') or hasRole('ROLE_ADMIN')")
public String edit(ModelMap model,@PathVariable(name="id")Long id,HttpSession session) {
	
Optional<DienThoai> optionalstaff=DienThoaiService.find(id);
DienThoaiDTO dto=null;
if(optionalstaff.isPresent()) {
	DienThoai st=optionalstaff.get();
	File file=new File("uploads/"+st.getHinhanh());
	FileInputStream input; 
	try {
		input=new FileInputStream(file);
		MultipartFile multiphoto=new MockMultipartFile("file",file.getName(),"text/plain",
				IOUtils.toByteArray(input)); 
		dto=new DienThoaiDTO(st.getId(),st.getName(),st.getMadt(),st.getNgaynhap(),multiphoto,st.getSoluong(),st.getGiaban(),
				st.getMaloaidt(),0);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	model.addAttribute("dto",dto);
	
	model.addAttribute("action","/DienThoai/update");
	
}else {
	DienThoaiDTO dto1=new DienThoaiDTO();
	model.addAttribute("dto",dto1);
	model.addAttribute("action","/DienThoai/saveorupdate");
}
DienThoaiService.clearCache();
return "register-dienthoai";
	
}
 @Autowired
    JdbcTemplate jdbcT;
 //@PreAuthorize ("hasPermission ('','/DienThoai/delete')")
@RequestMapping("/delete/{id}")
@PreAuthorize ("hasPermission ('','/DienThoai/delete') and hasRole('ROLE_ADMIN')")
public String delete(ModelMap model,@PathVariable(name="id")Long id
		,HttpServletRequest request,RedirectAttributes redirect,HttpSession session) {

 String sql="update DienThoai set isdelete=1 where id=?";
 DienThoai DienThoai=new  DienThoai(id);
 jdbcT.update(sql,new Object[] {DienThoai.getId()});
 redirect.addAttribute("id", 3);
 DienThoaiService.clearCache();
return "redirect:/DienThoai/page/{id}";
	
}
 //@PostAuthorize ("hasPermission ('','/DienThoai/delete')")
@RequestMapping("/xoanhieu")
@PreAuthorize ("hasPermission ('','/DienThoai/delete') and hasRole('ROLE_ADMIN')")
public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
		HttpServletRequest request,RedirectAttributes redirect) {
	for(int i=0;i<ll.size();i++) {
		System.out.println("so la : "+ll.get(i));
		Long g=ll.get(i);
		 String sql="update DienThoai set isdelete=1 where id=?";
		 DienThoai DienThoai=new  DienThoai(g);
		 jdbcT.update(sql,new Object[] {DienThoai.getId()});
		//employeeService.isdelete(g);
	}
	 DienThoaiService.clearCache();
	//request.getSession().setAttribute("employeelist", null);
	// redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	return "redirect:/DienThoai/page";
}
 //@PostAuthorize ("hasPermission ('','/DienThoai/xem')")
@GetMapping("/page")
@PreAuthorize ("hasPermission ('','/DienThoai/view') or hasPermission ('','/DienThoai/saveorupdate') or hasRole('ROLE_ADMIN')")
public String index(Model model,HttpServletRequest request
		,RedirectAttributes redirect) {
	request.getSession().setAttribute("employeelist", null);
	
	 redirect.addAttribute("id", 1);
	   
	return "redirect:/DienThoai/page/{id}";
}
 //@PostAuthorize ("hasPermission ('','/DienThoai/xem')")
@GetMapping("/page/{pageNumber}")
@PreAuthorize ("hasPermission ('','/DienThoai/view') or hasPermission ('','/DienThoai/saveorupdate') or hasRole('ROLE_ADMIN')")
public String showEmployeePage(HttpServletRequest request, 
		@PathVariable int pageNumber, Model model) {
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
	int pagesize = 3;
	model.addAttribute("chucvu",loaiDTService.getAll());
	List<DienThoai> list =(List<DienThoai>) DienThoaiService.getAll();
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
	int begin=1;
	if(current==1) {
	 begin = Math.max(current, current - list.size());
	}else {
		 begin = Math.max(current-1, current - list.size());
	}
	int end = Math.min(begin + 3, pages.getPageCount());
	int totalPageCount = pages.getPageCount();
	String baseUrl = "/DienThoai/page/";

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);
	model.addAttribute("totalPageCount", totalPageCount);
	model.addAttribute("baseUrl", baseUrl);
	model.addAttribute("employees", pages);

	return "view-dienthoai";
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
@Autowired
DienThoaiRepository dienthoaii;
@GetMapping("/search")	
@PreAuthorize ("hasPermission ('','/DienThoai/view') or hasPermission ('','/DienThoai/saveorupdate') or hasRole('ROLE_ADMIN')")
public String search(@RequestParam("s") String s, Model model, HttpServletRequest request	
	) {	
	if (s.equals("")) {	
		return "/DienThoai/page";	
	}	
	 
	List<DienThoai> list = DienThoaiService.findlk("%"+s.trim()+"%");
	
	if (list == null) {	
		return "/DienThoai/page";	
	}	
	
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");	
	int pagesize = 3;	
	pages = new PagedListHolder<>(list);	
	pages.setPageSize(pagesize);	
		
	//final int goToPage = pageNumber - 1;	
	//if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
	//	pages.setPage(goToPage);	
	//}	
	request.getSession().setAttribute("employeelist", pages);	
	int current = pages.getPage() + 1;	
	int begin = Math.max(1, current - list.size());	
	int end = Math.min(begin + 5, pages.getPageCount());	
	int totalPageCount = pages.getPageCount();	
	String baseUrl = "/DienThoai/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-DienThoai";	
}
@GetMapping("/search/pageNumber")	
@PreAuthorize ("hasPermission ('','/DienThoai/view') or hasPermission ('','/DienThoai/saveorupdate') or hasRole('ROLE_ADMIN')")
public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
		) {	
	if (s.equals("")) {	
		return "/DienThoai/page";	
	}	
	List<DienThoai> list = DienThoaiService.getAll();	
	if (list == null) {	
		return "/DienThoai/page";	
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
	String baseUrl = "/DienThoai/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-dienthoai";	
}
}
