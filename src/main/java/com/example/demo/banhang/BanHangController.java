package com.example.demo.banhang;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.TKLoaiDTRepository;
import com.example.demo.Services.BaoHanhService;
import com.example.demo.Services.CustomerService;
import com.example.demo.Services.DienThoaiService;
import com.example.demo.Services.DienThoaiXKService;
import com.example.demo.Services.HDChiTietService;
import com.example.demo.Services.HoadonServices;
import com.example.demo.Services.KhuyenMaiService;
import com.example.demo.Services.LoaiDTService;
import com.example.demo.Services.PhuKienService;
import com.example.demo.Services.TangKemService;
import com.example.demo.models.Customers;
import com.example.demo.models.DienThoai;
import com.example.demo.models.DienThoaiXK;
import com.example.demo.models.HDChiTiet;
import com.example.demo.models.Hoadon;
import com.example.demo.models.KhuyenMai;
import com.example.demo.models.PhieuXuatKho;
import com.example.demo.models.PhuKien;
import com.example.demo.models.TongTien;



@Controller
@RequestMapping("/cuahang")
public  class BanHangController {
	@Autowired
	CustomerService customerService;
	@Autowired
	BaoHanhService baoHanhService;
		@Autowired
		DienThoaiService dienThoaiService;
		@Autowired
		PhuKienService phuKienService;
		@Autowired
		LoaiDTService loaiDTService ;
		@Autowired
		TangKemService tangKemService;
		@Autowired
		TKLoaiDTRepository tKLoaiDTRepository;
		@Autowired
		HoadonServices hoaDonService; 
		@Autowired
		HDChiTietService hDChiTietService; 
		@Autowired
		KhuyenMaiService khuyenMaiService;
		@Autowired
		DienThoaiXKService dienThoaiXKService;
		
		@Autowired 
	    private PasswordEncoder passwordEncoder;
		
	@RequestMapping("/")
	public String cuahang(ModelMap model) {
		model.addAttribute("USERS",loaiDTService.findAll());
		List<DienThoai> lj=new ArrayList<>();
		List<PhuKien>pk=new ArrayList<>();
		for(int i=0;i<dienThoaiService.getAll().size();i++) {
		lj.add(dienThoaiService.getAll().get(i))	;
		}
		model.addAttribute("list1",lj);
		for(int j=0;j<4;j++) {
			pk.add(phuKienService.getAll().get(j))	;
			}
			model.addAttribute("listpk",pk);
		return "layout/customer-layout";
	}
	@RequestMapping("/sanpham/{id}")
	public String sanpham(ModelMap model,@PathVariable(name="id")Long id) {
		Optional<DienThoai> optionalstaff=dienThoaiService.findById(id);
		Optional<PhuKien> phukien=phuKienService.findById(id);
		long tienla=0;
		
		if(optionalstaff.isPresent()) {
			List<DienThoai> lk=new ArrayList<>();
			
			List<String> tentk=tKLoaiDTRepository.tensanpham(id);
			model.addAttribute("tienban",optionalstaff.get().getGiaban());
			model.addAttribute("tentk",tentk);
			tienla=optionalstaff.get().getGiaban()-khuyenMaiService.finddt(dienThoaiService.find(id).get().getMaloaidt()).get().getTien();
			optionalstaff.get().setGiaban(tienla);
			lk.add(optionalstaff.get());
			model.addAttribute("list1",lk);
			model.addAttribute("l",1);
			model.addAttribute("aa",optionalstaff.get().getHinhanh());
		}else {
			if(phukien.isPresent()) {
				List<PhuKien> lk=new ArrayList<>();
				lk.add(phukien.get());
				model.addAttribute("tienban",phukien.get().getGiaban());
				model.addAttribute("list1",lk);
				model.addAttribute("l",3);
				model.addAttribute("aa",phukien.get().getHinhanh());
			}else {
			
			return "layout/customer-layout";
			}
		}
	 
		model.addAttribute("tienthuc",tienla);
		
		return "view-productcustomer";
	}
	@RequestMapping("/banhang")
	public String banhang(ModelMap model) {
		return "layout/Banhang";
	}
	public long random() {
		Random rd = new Random();
		long longNumber = rd.nextLong();
		if(longNumber<0) {return (-1*longNumber);}
		return longNumber;
	}
	public static double tien=0;
	public static int k=1;
	public static long km1=0;
	public static List<Long> l=new ArrayList<>();
	@RequestMapping("/mua/{id}")
	public String buy(Model model,@PathVariable(name="id")Long id) {
		CustomerProduct uu=new CustomerProduct();
		HDChiTiet ui=new HDChiTiet();
		Optional<DienThoai> u= dienThoaiService.find(id);
		Optional<PhuKien> phukien=phuKienService.findById(id);
		KhuyenMai khuyenmai=new KhuyenMai();
		if(u.isPresent()) {
			long tienla=0;
			l.add(id);
			uu.setCartsdetail(random());
			uu.setCart(random());
			uu.setProduct(id);
			
			uu.setQuantity(1);
			tienla=u.get().getGiaban()-khuyenMaiService.finddt(dienThoaiService.find(id).get().getMaloaidt()).get().getTien();
			u.get().setGiaban(tienla);
			uu.setGiaban(tienla);
			uu.setPrice(u.get().getGiaban());
			uu.setName(u.get().getName());
			uu.setPhoto(u.get().getHinhanh());
			uu.setNgaydat(new Date());
			model.addAttribute("action","/cuahang/themhang");
			
				
			
			 
			dao.getall().add(uu);
			model.addAttribute("list1",dao.getall());
		}
		else {
			if(phukien.isPresent()) {
				l.add(id);
				uu.setCartsdetail(random());
				uu.setCart(random());
				uu.setGiaban(phukien.get().getGiaban());
				uu.setProduct(id);
				uu.setQuantity(1);
				uu.setPrice(phukien.get().getGiaban());
				uu.setName(phukien.get().getTenpk());
				uu.setPhoto(phukien.get().getHinhanh());
				uu.setNgaydat(new Date());
				model.addAttribute("action","/cuahang/themhang");
				
				
				dao.getall().add(uu);
			model.addAttribute("list1",dao.getall());
		}
		}
		tien=0;
		for(CustomerProduct a:dao.getall()) {
			tien=tien+a.getPrice();
			
		}
		
		TongTien tt=new TongTien();
		tt.setTien((long)tien);
		model.addAttribute("tongtien",tt);
		tien=0;
		return "view-customerproduct";
	}
	
	CustomerProductDAO dao=new CustomerProductDAO();
	public static List<HDChiTiet> lsf=new ArrayList<>();

	@RequestMapping("/themhang")
	public String themhang(ModelMap model,@RequestParam("cartsdetail")long cartsdetail ,
			@RequestParam("quantity") Integer quantity) {
		int p=dao.find(cartsdetail);
		tien =0;
		long tienla=0;
		long a=0;
		dao.getall().get(p).setQuantity(quantity);
		if(dienThoaiService.find(dao.getall().get(p).getProduct()).isPresent()) {
			tienla=khuyenMaiService.finddt(dienThoaiService.find(dao.getall().get(p).getProduct()).get().getMaloaidt()).get().getTien();
		 a=dienThoaiService.find(dao.getall().get(p).getProduct()).get().getGiaban();
		}
		if(phuKienService.find(dao.getall().get(p).getProduct()).isPresent()){
			a=phuKienService.find(dao.getall().get(p).getProduct()).get().getGiaban();
		}
		
		
		dao.getall().get(p).setPrice((a-tienla)*quantity);
		dao.getall().get(p).setQuantity(quantity);
		model.addAttribute("action","/cuahang/themhang");
		model.addAttribute("list1",dao.getall());
		for(CustomerProduct a1:dao.getall()) {
			tien=tien+a1.getPrice();
			}
		
		TongTien tt=new TongTien();
		tt.setTien((long)tien);
		model.addAttribute("tongtien",tt);
		tien=0;
	return "view-customerproduct";	
	}
	@RequestMapping("/dele/{cartsdetail}")
	public String delete(Model model,@PathVariable(name="cartsdetail")Long id) {
		int a=dao.find(id);
		dao.getall().remove(a);
		tien=0;
		model.addAttribute("action","/cuahang/themhang");
		TongTien tt=new TongTien();
		for(CustomerProduct aa:dao.getall()) {
			tien=tien+aa.getPrice();
			
		}
		tt.setTien((long)tien);
		model.addAttribute("tongtien",tt);
		model.addAttribute("list1",dao.getall());
		tien=0;
		return "view-customerproduct";
	}
	
	public static SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
	@RequestMapping("/thanhtoan")
	public String thanhtoan(ModelMap model,@ModelAttribute("tongtien")TongTien tongtien ) {
		Hoadon cart1=new Hoadon();
		HDChiTiet cartdetail=new HDChiTiet();
		Customers customer=new Customers();
		
		
		customer.setDto(new Date());
		cart1.setId(random());
		cart1.setCustomerid(customer.getId());
		cart1.setCreateddate(new Date());
		cart1.setIsdelete(0);
		cart1.setTien(tongtien.getTien());
		cart1.setStatus("da thanh toan");
		hoaDonService.save(cart1);
		
		
		for(CustomerProduct u:dao.getall()) {
			cartdetail.setId(random());
			cartdetail.setHoadonid(cart1.getId());
			cartdetail.setSanphamid(u.getProduct());
			cartdetail.setPrice(u.getGiaban());
			cartdetail.setSoluong(u.getQuantity());
			cartdetail.setTinhtrang(3);
			cartdetail.setNgaydat(u.getNgaydat());
			cartdetail.setIsdelete(0);
			cartdetail.setNote("Giam ngay 1.5 trieu dong");
			hDChiTietService.save(cartdetail);
			
		}
		model.addAttribute("action","/cuahang/addcustomer");
		model.addAttribute("customer",customer);
		model.addAttribute("list1",dao.getall());
		
		return "view-hoadon1";
	}
	@RequestMapping("/addcustomer")
	public String addcustomer(ModelMap model,@ModelAttribute("customer")Customers customer) {
		//customer.setPassword(passwordEncoder.encode(customer.getPassword()));
	    customer.setIsdelete(0);
		customerService.save(customer);
		TongTien tt=new TongTien();
		tien=0;
		for(CustomerProduct aa:dao.getall()) {
			tien=tien+aa.getPrice();
			
		}

		tt.setTien((long)tien);
		model.addAttribute("tongtien",tt);
		model.addAttribute("list1",dao.getall());
		
		name=customer.getName();
		
		model.addAttribute("ten",name);
		tien=0;
		PhieuXuatKho dto=new PhieuXuatKho();
		model.addAttribute("PhieuXuatKho",dto);
		model.addAttribute("action","/cuahang/phieuxuatkho");
		return "register-PhieuXuatKho";
			
	}
	@RequestMapping("/phieuxuatkho")
	public String phieuxuatkho(ModelMap model,@ModelAttribute("PhieuXuatKho")PhieuXuatKho PhieuXuatKho) {
		List<CustomerProduct> xuatkho=dao.getall();
		for(int i=0;i<dao.getall().size();i++) {
			dao.getall().get(i).setIdxuatkho(PhieuXuatKho.getId());
		}
		
		model.addAttribute("xuatkho",xuatkho);
		return "view-XuatKho";
	}
	public long random1() {
		Random rd = new Random();
		long longNumber = rd.nextLong();
		if(longNumber<0) {return (-1*longNumber);}
		return longNumber;
	}
	@RequestMapping("/savexuatkho")
	public String savexuatkho() {
		for(int i=0;i<dao.getall().size();i++) {
			Optional<DienThoai>dienthoai=dienThoaiService.find(dao.getall().get(i).getProduct());
			if(dienthoai.isPresent()) {
				DienThoaiXK dienthoaixk=new DienThoaiXK();
				dienthoaixk.setMaxk(dao.getall().get(i).getIdxuatkho());
				dienthoaixk.setGiaban(dao.getall().get(i).getGiaban());
				dienthoaixk.setHinhanh(dienthoai.get().getHinhanh());
				dienthoaixk.setIsdelete(0);
				dienthoaixk.setMadt(dienthoai.get().getMadt());
				dienthoaixk.setMaloaidt(dienthoai.get().getMaloaidt());
				dienthoaixk.setName(dienthoai.get().getName());
				dienthoaixk.setNgayxuat(dao.getall().get(i).getNgaydat());
				dienthoaixk.setSoluong((long)dao.getall().get(i).getQuantity());
				dienthoai.get().setSoluong(dienthoai.get().getSoluong()-dienthoaixk.getSoluong());
				dienThoaiService.save(dienthoai.get()); 
				dienThoaiXKService.save(dienthoaixk);
				
			}
			Optional<PhuKien> phukien=phuKienService.find(dao.getall().get(i).getProduct());
			if(phukien.isPresent()){
				PhuKien phukienxk=new PhuKien();
				phukienxk.setId(random());
				phukienxk.setGiaban(dao.getall().get(i).getGiaban());
				phukienxk.setHinhanh(phukien.get().getHinhanh());
				phukienxk.setIdnhapkho(phukien.get().getIdnhapkho());
				phukienxk.setIsdelete(0);
				phukienxk.setMaloaipk(phukien.get().getMaloaipk());
				phukienxk.setMapk(phukien.get().getMapk());
				phukienxk.setNgaynhap(dao.getall().get(i).getNgaydat());
				phukienxk.setSoluong((long)dao.getall().get(i).getQuantity());
				phukienxk.setTenpk(phukien.get().getTenpk());
				phukienxk.setIdxuatkho(dao.getall().get(i).getIdxuatkho());
				phukien.get().setSoluonght(phukien.get().getSoluong()-dao.getall().get(i).getQuantity());
				//phukienxk.setSoluonght(dao.getall().get(i).getQuantity());
				phuKienService.save(phukien.get());
				phuKienService.save(phukienxk);
			}
		}
		return "redirect:/cuahang/";
	}
	public static  String name="";
	@RequestMapping("/guidi")
	public String guidi(ModelMap model) {
		model.addAttribute("ten",name);
		return "thankyou";
	}
	/*@RequestMapping("/iphone")
	public String iphone(ModelMap model) {
		model.addAttribute("USERS",loaiDTService.findAll());
		model.addAttribute("list1",dienThoaiService.findBynameLike("iphone"));
		return "layout/customer-layout";
	}
	@RequestMapping("/laptop")
	public String laptop(ModelMap model) {
		model.addAttribute("USERS",loaiDTService.findAll());
		model.addAttribute("list1",dienThoaiService.findBynameLike("laptop"));
		return "layout/customer-layout";
	}
	@RequestMapping("/tablet")
	public String tablet(ModelMap model) {
		model.addAttribute("USERS",loaiDTService.findAll());
		model.addAttribute("list1",dienThoaiService.findBynameLike("bang"));
		return "layout/customer-layout";
	}
	@RequestMapping("/samsum")
	public String samsum(ModelMap model) {
		String name="samsum";
		List<Products> lf=dienThoaiService.findBynameLike(name);
		model.addAttribute("USERS",loaiDTService.findAll());
		model.addAttribute("list1",lf );
		return "layout/customer-layout";
	}*/
	@RequestMapping("/timgi")
	public String timgi(ModelMap model,@RequestParam("name")String name) {
		List<DienThoai> lf=dienThoaiService.findlk("%"+name+"%");
		List<PhuKien> pk=phuKienService.findlk("%"+name+"%");
		model.addAttribute("USERS",loaiDTService.findAll());
		model.addAttribute("list1",lf );
		model.addAttribute("listpk",pk);
		return "layout/customer-layout";
	}
	/*@RequestMapping("/hangsx/{name}")
	public String hangsx(ModelMap model,@PathVariable(name="name")String name) {
		model.addAttribute("USERS",loaiDTService.findAll());
		model.addAttribute("list1",dienThoaiService.findBynameLike(name) );
		return "layout/customer-layout";
	}*/
	/*@RequestMapping("/demo")
	public String demo(ModelMap model,@RequestParam("name")String name) {
		List<Products> lf=dienThoaiService.findBynameLike(name);
		model.addAttribute("USERS",loaiDTService.findAll());
		List<Products> lj=new ArrayList<>();
		for(int i=0;i<12;i++) {
		lj.add(dienThoaiService.findAll().get(i))	;
		}
		model.addAttribute("list1",lj);
		model.addAttribute("lis",lf );
		return "layout/customer-layout";
	}*/
	@RequestMapping("/sapxep")
	//public String sapxep(ModelMap model,@RequestParam("sapxep")String gg ) {
		public String sapxep(ModelMap model ) {
		List<DienThoai> lh=new ArrayList<>();
		lh=dienThoaiService.getAll();
		DienThoai dd=new DienThoai();
//		if(gg.equals("1")) {
		for(int i=0;i<lh.size()-1;i++) {
			for(int j=i+1;j<lh.size();j++) {
				if(lh.get(i).getGiaban()>lh.get(j).getGiaban()) {
					dd=lh.get(j);
					lh.set(j,lh.get(i));
					lh.set(i,dd);
				}
			}
		}
		model.addAttribute("USERS",loaiDTService.findAll());
		model.addAttribute("list1",lh );
		model.addAttribute("l","0" );
		return "layout/customer-layout";
	}
	@RequestMapping("/sapxep1")
	//public String sapxep(ModelMap model,@RequestParam("sapxep")String gg ) {
		public String sapxep1(ModelMap model ) {
		List<DienThoai> lh=new ArrayList<>();
		lh=dienThoaiService.findAll();
		DienThoai dd=new DienThoai();
//		}else {
			for(int i=0;i<lh.size()-1;i++) {
				for(int j=i+1;j<lh.size();j++) {
					if(lh.get(i).getGiaban()<lh.get(j).getGiaban()) {
						dd=lh.get(j);
						lh.set(j,lh.get(i));
						lh.set(i,dd);
					}
				}
			}
			model.addAttribute("USERS",loaiDTService.findAll());
			model.addAttribute("list1",lh );
			model.addAttribute("l","1" );
			return "layout/customer-layout";
//		}
		//return "layout/customer-layout";
	}
}
