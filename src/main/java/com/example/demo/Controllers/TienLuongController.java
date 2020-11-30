package com.example.demo.Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.ChucVuRepository;
import com.example.demo.Repository.TienLuongRepository;
import com.example.demo.Services.BangChamCongService;
import com.example.demo.Services.BangLuongService;
import com.example.demo.Services.ChucVuService;
import com.example.demo.Services.DiLamService;
import com.example.demo.Services.EmployeeService;
import com.example.demo.Services.KhongDiLamService;
import com.example.demo.Services.NhaNuocService;
import com.example.demo.Services.PhongBanService;
import com.example.demo.Services.PhuCapService;
import com.example.demo.Services.TangCaService;
import com.example.demo.Services.TienLuongService;
import com.example.demo.models.BangChamCong;
import com.example.demo.models.BangLuong;
import com.example.demo.models.ChucVu;
import com.example.demo.models.DiLam;
import com.example.demo.models.Employee;
import com.example.demo.models.KhongDiLam;
import com.example.demo.models.NhaNuoc;
import com.example.demo.models.PhongBan;
import com.example.demo.models.PhuCap;
import com.example.demo.models.TangCa;
import com.example.demo.models.TienLuong;

@Controller
@RequestMapping("/TienLuong")
public class TienLuongController {
	SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
	@Autowired
	TienLuongRepository tienLuongRepository;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	TienLuongService tienLuongService;
	@Autowired
	ChucVuRepository chucVuService;
	@Autowired
	PhongBanService phongBanService;
	@Autowired
	BangLuongService bangLuongService;
	@Autowired
	BangChamCongService bangChamCongService;
	@Autowired
	PhuCapService phuCapService;
	@Autowired
	TangCaService tangCaService;
	@Autowired
	NhaNuocService nhaNuocService;
	@Autowired
	DiLamService diLamService;
	@Autowired
	KhongDiLamService khongDiLamService;

	@ModelAttribute("nhanvien")
	public List<Employee> getall() {
		return employeeService.getAll();
	}

	@ModelAttribute("chucvu")
	public List<ChucVu> getall1() {
		return chucVuService.findAll();
	}

	@ModelAttribute("phongban")
	public List<PhongBan> getall2() {
		return phongBanService.getAll();
	}

	@ModelAttribute("bangluong")
	public List<BangLuong> getall3() {
		return bangLuongService.getAll();
	}

	@ModelAttribute("bangChamCong")
	public List<BangChamCong> getall4() {
		return bangChamCongService.getAll();
	}

	@ModelAttribute("phucap")
	public List<PhuCap> getall5() {
		return phuCapService.getAll();
	}

	@ModelAttribute("tangca")
	public List<TangCa> getall6() {
		return tangCaService.getAll();
	}

	@ModelAttribute("nhanuoc")
	public List<NhaNuoc> getall7() {
		return nhaNuocService.getAll();
	}

	@ModelAttribute("dilam")
	public List<DiLam> getall8() {
		return diLamService.getAll();
	}

	@ModelAttribute("khongdilam")
	public List<KhongDiLam> getall9() {
		return khongDiLamService.getAll();
	}

	public long random() {
		Random rd = new Random();
		long longNumber = rd.nextLong();
		if (longNumber < 0) {
			return (-1 * longNumber);
		}
		return longNumber;
	}

	@RequestMapping("/")
	public String tienluong(ModelMap model, @RequestParam(value = "ngaydau", defaultValue = "") String ngaydau,
			@RequestParam(value = "ngaycuoi", defaultValue = "") String ngaycuoi) throws ParseException {
		if (ngaydau.equals("") || ngaycuoi.equals("")) {

			Calendar calendar = Calendar.getInstance();

			calendar.getTime();
			ngaycuoi = d.format(calendar.getTime());
			calendar.add(calendar.DATE, -30);
			ngaydau = d.format(calendar.getTime());

		}

		List<TienLuong> tl = new ArrayList<>();
		// TienLuong tienluong =new TienLuong();

		for (int i = 0; i < employeeService.getAll().size(); i++) {
			TienLuong tienluong = new TienLuong();
			int gio = 0;
			int workday = 0;
			long pc = 0;
			float hsl = 0;
			long tien = 0;
			long sotien = 0;
			long tienpc = 0;
			double tientc = 0;
			tienluong.setId(random());
			tienluong.setIdemployee(employeeService.getAll().get(i).getId());
			for (int j = 0; j < phuCapService.getAll().size(); j++) {
				if (phuCapService.getAll().get(j).getIdchucvu() == employeeService.getAll().get(i).getChucvuid()) {
					pc = phuCapService.getAll().get(j).getSotien() + pc;
				}

			}
			for (int k = 0; k < bangLuongService.getAll().size(); k++) {
				if (employeeService.getAll().get(i).getChucvuid() == bangLuongService.getAll().get(k).getChucvuid()) {
					hsl = bangLuongService.getAll().get(k).getHesoluong();
				}
			}
			// Calendar calendar = Calendar.getInstance();
			// workday=tienLuongService.ngaylam(employeeService.getAll().get(i).getId());
			workday = tienLuongRepository.ngaylams(employeeService.getAll().get(i).getId(), d.parse(ngaycuoi),
					d.parse(ngaydau));
			tienluong.setSongay(workday);
			for (int l = 0; l < tangCaService.getAll().size(); l++) {
				if (tangCaService.getAll().get(l).getIdemployee() == employeeService.getAll().get(i).getId()) {
					// gio=gio+tangCaService.getAll().get(l).getGio();
					tienpc = tangCaService.tongtien(tangCaService.getAll().get(l).getIdemployee(), d.parse(ngaydau),
							d.parse(ngaycuoi));

				}
			}
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(d.parse(ngaydau));
			int nam=calendar1.get(calendar1.YEAR);
			NhaNuoc nhanuoc = nhaNuocService.nam(nam).get();
			for (int k = 0; k < diLamService.getAll().size(); k++) {
				if (diLamService.getAll().get(k).getIdnhanvien() == employeeService.getAll().get(i).getId()) {
					sotien = diLamService.sotien(employeeService.getAll().get(i).getId(), d.parse(ngaydau),
							d.parse(ngaycuoi));
				}

			}
			// long sotien=diLamService.sotien(employeeService.getAll().get(i).getId(),
			// d.parse(ngaydau), d.parse(ngaycuoi));
			tien = (long) ((pc + hsl * nhanuoc.getLuongcoban()) * workday/27 + tienpc + sotien);

			tienluong.setLuong(tien);
			tienluong.setLuongthuc((long) (tien * (1 - nhanuoc.getBhtainan() * 0.01 - nhanuoc.getBhyte() * 0.01))
					- nhanuoc.getQuydoan());
			tienluong.setNgaydauthang(d.parse(ngaydau));
			tienluong.setNgaycuoithang(d.parse(ngaycuoi));
			tienluong.setIsdelete(0);
			// tienLuongService.save(tienluong);
			tl.add(tienluong);
			// System.out.println("kich koee"+tl.get(1).getLuong());
		}
//	System.out.println("kich koee"+tl.get(1).getLuong());
		// Page<TienLuong> page = tienLuongRepository.findall1(PageRequest.of(0, 5));
		model.addAttribute("tienluong", tl);
		model.addAttribute("ngaydau", ngaydau);
		model.addAttribute("ngaycuoi", ngaycuoi);
		model.addAttribute("ngay", "/TienLuong/");

		return "view-TienLuong";
	}
	@RequestMapping("/chitiet")
	public String chitiet(ModelMap model,@RequestParam(name="idnhanvien",defaultValue = "-1")Long idnhanvien,
			@RequestParam(name="ngaydau1",defaultValue = "a")String ngaydau,
			@RequestParam(name="ngaycuoi1",defaultValue = "a")String ngaycuoi) throws ParseException {
		Optional<Employee> nhanvien=employeeService.find(idnhanvien);
		model.addAttribute("name",nhanvien.get().getName());
		model.addAttribute("chucvu",chucVuService.findById(nhanvien.get().getChucvuid()).get().getTencv());
		model.addAttribute("listpc",phuCapService.findcv(nhanvien.get().getChucvuid()));
		long tienpc = tangCaService.tongtien(nhanvien.get().getId(), d.parse(ngaydau),
				d.parse(ngaycuoi));
		long sotien = diLamService.sotien(nhanvien.get().getId(), d.parse(ngaydau),
				d.parse(ngaycuoi));
		model.addAttribute("tienpc",tienpc);
		int workday = tienLuongRepository.ngaylams(idnhanvien, d.parse(ngaycuoi),
				d.parse(ngaydau));
		model.addAttribute("ngaylam",workday);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d.parse(ngaydau));
		int nam=calendar.get(calendar.YEAR);
		double tiencong=tienLuongService.tiennv(nhanvien.get().getChucvuid(), nam);
		model.addAttribute("tiencong",tiencong);
		NhaNuoc nhanuoc = nhaNuocService.nam(nam).get();
		long pc=0;
		for (int j = 0; j < phuCapService.getAll().size(); j++) {
		
			if (phuCapService.getAll().get(j).getIdchucvu() ==nhanvien.get().getChucvuid()) {
				pc = phuCapService.getAll().get(j).getSotien() + pc;
			}

		}
		long tienl=(long) ((pc + tiencong) * workday/27 + tienpc + sotien);
		long tongtien=(long) (((pc + tiencong) * workday/27 + tienpc + sotien)*(1 - nhanuoc.getBhtainan() * 0.01 - nhanuoc.getBhyte() * 0.01)-20000);
		model.addAttribute("tongtien",tongtien);
		model.addAttribute("tienluong",tienl);
		model.addAttribute("bhyt",nhanuoc.getBhyte()*tongtien/100);
		model.addAttribute("bhtn",nhanuoc.getBhtainan()*tongtien/100);
		return "view-chitiet";
	}
}
