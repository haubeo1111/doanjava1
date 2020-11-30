package com.example.demo.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.example.demo.models.DienThoai;
import com.example.demo.Repository.DienThoaiRepository;
import com.example.demo.Services.DangKyService;
import com.example.demo.Services.DienThoaiService;
import java.util.List;
@Service
public class vidu1 {
@Autowired
DienThoaiRepository dienThoaiRepository;
public List<DienThoai> getall(){
	return dienThoaiRepository.getAll();
}


}
