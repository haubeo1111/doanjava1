package com.example.demo.Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.ThongKeRepository;
import com.example.demo.models.ThongKe;
@Controller
@RequestMapping("/ThongKe")
public class ThongKeController {
@Autowired
ThongKeRepository thongKeRepository;
public long random() {
	Random rd = new Random();
	long longNumber = rd.nextLong();
	if (longNumber < 0) {
		return (-1 * longNumber);
	}
	return longNumber;
}
SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
@RequestMapping("/banhang")
public String thongke(ModelMap model, @RequestParam(value = "ngaydau", defaultValue = "") String ngaydau,
		@RequestParam(value = "ngaycuoi", defaultValue = "") String ngaycuoi) throws ParseException  {
	if (ngaydau.equals("") || ngaycuoi.equals("")) {

		Calendar calendar = Calendar.getInstance();

		calendar.getTime();
		ngaycuoi = d.format(calendar.getTime());
		calendar.add(calendar.DATE, -30);
		ngaydau = d.format(calendar.getTime());
	}
	
	List<ThongKe>thongke=thongKeRepository.banhang(d.parse(ngaydau), d.parse(ngaycuoi));
model.addAttribute("thongke",thongke);
model.addAttribute("ten","Thống Kê Số Hàng Bán Được Trong Tháng");
model.addAttribute("ngaydau",ngaydau);
model.addAttribute("ngaycuoi",ngaycuoi);
model.addAttribute("ngay","/ThongKe/banhang");
	return "thongke/view-ThongKe";
}
@RequestMapping("/nhapkho")
public String nhapkho(ModelMap model, @RequestParam(value = "ngaydau", defaultValue = "") String ngaydau,
		@RequestParam(value = "ngaycuoi", defaultValue = "") String ngaycuoi) throws ParseException  {
	if (ngaydau.equals("") || ngaycuoi.equals("")) {

		Calendar calendar = Calendar.getInstance();

		calendar.getTime();
		ngaycuoi = d.format(calendar.getTime());
		calendar.add(calendar.DATE, -30);
		ngaydau = d.format(calendar.getTime());
	}
	
	List<ThongKe>thongke=thongKeRepository.nhapkho(d.parse(ngaydau), d.parse(ngaycuoi));
model.addAttribute("thongke",thongke);
model.addAttribute("ten","Thống Kê Số Hàng  Được Nhập Trong Tháng");
model.addAttribute("ngaydau",ngaydau);
model.addAttribute("ngaycuoi",ngaycuoi);
model.addAttribute("ngay","/ThongKe/nhapkho");
	return "thongke/view-ThongKe";
}
}
