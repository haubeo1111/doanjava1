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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Repository.QuyenChucNang;
import com.example.demo.Services.DienThoaiNKService;
import com.example.demo.Services.DienThoaiService;
import com.example.demo.Services.LoaiDTService;
import com.example.demo.Services.PhieuNhapKhoService;
import com.example.demo.dto.DienThoaiNKDTO;
import com.example.demo.models.DienThoai;
import com.example.demo.models.DienThoaiNK;
import com.example.demo.models.LoaiDT;
import com.example.demo.models.PhieuNhapKho;

@Controller
@RequestMapping("/DienThoaiNK")
public class DienThoaiNKController {
	@Autowired
	DienThoaiNKService DienThoaiNKService;
	@Autowired
	DienThoaiService DienThoaiService;
	@Autowired
	LoaiDTService loaiDTService;
	@Autowired
	QuyenChucNang QuyenChucNang;
	@Autowired
	PhieuNhapKhoService phieuNhapKhoService;
	@PreAuthorize ("hasPermission ('','/DienThoaiNK/saveorupdate') and hasRole('ROLE_MEMBER') or hasRole('ROLE_ADMIN')")
	@GetMapping("/")
	public String index(Model model,HttpSession session) {
		
			System.out.println("hau map login");
			DienThoaiNKDTO dto=new DienThoaiNKDTO();
			model.addAttribute("dto",dto);
			model.addAttribute("action","/DienThoaiNK/saveorupdate");
			return "register-DienThoaiNK";
		
	}
	@ModelAttribute(name="phieunhapkho")
	public List<PhieuNhapKho> getAll1(){
		
	return  (List<PhieuNhapKho>) phieuNhapKhoService.getAll();
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
	static List<DienThoaiNK> pnk=new ArrayList<>();
	//@PostAuthorize ("hasPermission ('','/DienThoaiNK/saveorupdate')")
	@RequestMapping("/saveorupdate")
	public String save(ModelMap model,@ModelAttribute("dto")DienThoaiNKDTO dto,HttpSession session) {
		
		DienThoaiNK staff=null;
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
				 staff=new DienThoaiNK(dto.getMank(),dto.getName(),dto.getMadt(),dto.getNgaynhap(),image,dto.getSoluong(),
							dto.getGiaban(),dto.getMaloaidt(),0);
	            // DienThoaiNKService.save(staff);
	             pnk.add(staff);
				DienThoaiNKDTO dto1=new DienThoaiNKDTO();
				dto1.setMank(staff.getMank());
				model.addAttribute("dto",dto1);
				return "register-DienThoaiNK";
			}
	@RequestMapping("/savepnk")
	public String savepnk(ModelMap model) {
		for(int i=0;i<pnk.size();i++) {
			DienThoaiNKService.save(pnk.get(i));
			DienThoai dienthoai=new DienThoai();
			dienthoai.setName(pnk.get(i).getName());
			dienthoai.setMadt(pnk.get(i).getMadt());
			dienthoai.setHinhanh(pnk.get(i).getHinhanh());
			dienthoai.setIsdelete(0);
			dienthoai.setMaloaidt(pnk.get(i).getMaloaidt());
			dienthoai.setGiaban(pnk.get(i).getGiaban());
			dienthoai.setNgaynhap(pnk.get(i).getNgaynhap());
			dienthoai.setSoluong(pnk.get(i).getSoluong());
			DienThoaiService.save(dienthoai);
		}
		
		pnk=new ArrayList<>();
		System.out.println("pnk kck ko la "+pnk.size());
		return "redirect:/DienThoaiNK/page";
	}
	@RequestMapping("/update")
	public String update(ModelMap model,@ModelAttribute("dto")DienThoaiNKDTO dto) {
	Optional<DienThoaiNK> optionalstaff=DienThoaiNKService.find(dto.getId());
		DienThoaiNK staff=null;
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
			DienThoaiNKDTO dto1=new DienThoaiNKDTO();
			model.addAttribute("dto",dto1);
			model.addAttribute("action","/DienThoaiNK/saveorupdate");
			return "register-DienThoaiNK";
		}
		staff=new DienThoaiNK(dto.getId(),dto.getMank(),dto.getName(),dto.getMadt(),dto.getNgaynhap(),image,dto.getSoluong(),
				dto.getGiaban(),dto.getMaloaidt(),0);
		
	DienThoaiNKService.save(staff);
				DienThoaiNKDTO dto1=new DienThoaiNKDTO();
				model.addAttribute("dto",dto1);
				model.addAttribute("action","/DienThoaiNK/saveorupdate");
				return "register-DienThoaiNK";
			
	}
	//@PreAuthorize ("hasPermission ('','/DienThoaiNK/edit')")
	@RequestMapping("/dulieu/{maphieu}")
	public String edit(ModelMap model,@PathVariable(name="maphieu")long maphieu,HttpSession session) {
		DienThoaiNKDTO dto=new DienThoaiNKDTO();
		dto.setMank(maphieu);
		model.addAttribute("dto",dto);
		model.addAttribute("nk",maphieu);
		model.addAttribute("action","/DienThoaiNK/saveorupdate");
		return "register-DienThoaiNK";
	}
		
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")Long id,HttpSession session) {
		
	Optional<DienThoaiNK> optionalstaff=DienThoaiNKService.find(id);
	DienThoaiNKDTO dto=null;
	if(optionalstaff.isPresent()) {
		DienThoaiNK st=optionalstaff.get();
		File file=new File("uploads/"+st.getHinhanh());
		FileInputStream input; 
		try {
			input=new FileInputStream(file);
			MultipartFile multiphoto=new MockMultipartFile("file",file.getName(),"text/plain",
					IOUtils.toByteArray(input)); 
			dto=new DienThoaiNKDTO(st.getId(),st.getName(),st.getMadt(),st.getMank(),st.getNgaynhap(),multiphoto,st.getSoluong(),st.getGiaban(),
					st.getMaloaidt(),0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		model.addAttribute("dto",dto);
		model.addAttribute("nk",optionalstaff.get().getMank());
		model.addAttribute("action","/DienThoaiNK/update");
		
	}else {
		DienThoaiNKDTO dto1=new DienThoaiNKDTO();
		model.addAttribute("dto",dto1);
		model.addAttribute("action","/DienThoaiNK/saveorupdate");
	}

	return "register-DienThoaiNK";
		
	}
	 @Autowired
	    JdbcTemplate jdbcT;
	 //@PreAuthorize ("hasPermission ('','/DienThoaiNK/delete')")
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id")Long id
			,HttpServletRequest request,RedirectAttributes redirect,HttpSession session) {

	 String sql="update DienThoaiNK set isdelete=1 where id=?";
	 DienThoaiNK DienThoaiNK=new  DienThoaiNK(id);
	 jdbcT.update(sql,new Object[] {DienThoaiNK.getId()});
	 redirect.addAttribute("id",1);
	
	return "redirect:/DienThoaiNK/page/{id}";
		
	}
	 //@PostAuthorize ("hasPermission ('','/DienThoaiNK/delete')")
	@RequestMapping("/xoanhieu")
	public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
			HttpServletRequest request,RedirectAttributes redirect) {
		for(int i=0;i<ll.size();i++) {
			System.out.println("so la : "+ll.get(i));
			Long g=ll.get(i);
			 String sql="update DienThoaiNK set isdelete=1 where id=?";
			 DienThoaiNK DienThoaiNK=new  DienThoaiNK(g);
			 jdbcT.update(sql,new Object[] {DienThoaiNK.getId()});
			//employeeService.isdelete(g);
		}
		//request.getSession().setAttribute("employeelist", null);
		// redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
		return "redirect:/DienThoaiNK/page";
	}
	 //@PostAuthorize ("hasPermission ('','/DienThoaiNK/xem')")
	@GetMapping("/page")
	public String index(Model model,HttpServletRequest request
			,RedirectAttributes redirect) {
		request.getSession().setAttribute("employeelist", null);
		
		 redirect.addAttribute("id", 1);
		   
		return "redirect:/DienThoaiNK/page/{id}";
	}
	 //@PostAuthorize ("hasPermission ('','/DienThoaiNK/xem')")
	@GetMapping("/page/{pageNumber}")
	public String showEmployeePage(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
		int pagesize = 3;
		model.addAttribute("chucvu",loaiDTService.getAll());
		List<DienThoaiNK> list =(List<DienThoaiNK>) DienThoaiNKService.getAll();
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
		String baseUrl = "/DienThoaiNK/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("employees", pages);

		return "view-DienThoaiNK";
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
			return "/DienThoaiNK/page";	
		}	
		List<DienThoaiNK> list = DienThoaiNKService.findup("%"+s.trim()+"%");	
		if (list == null) {	
			return "/DienThoaiNK/page";	
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
		String baseUrl = "/employee/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-DienThoaiNK";	
	}
	@GetMapping("/search/pageNumber")	
	public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
			) {	
		if (s.equals("")) {	
			return "/DienThoaiNK/page";	
		}	
		List<DienThoaiNK> list = DienThoaiNKService.getAll();	
		if (list == null) {	
			return "/DienThoaiNK/page";	
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
		String baseUrl = "/DienThoaiNK/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-DienThoaiNK";	
	}
}
