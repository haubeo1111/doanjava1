package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.LayOut;
import com.example.demo.models.LoaiDT;

@Repository
public interface LayOutRepository extends CrudRepository<LayOut,Long>{
	@Query(value = "select * from layout ",nativeQuery=true)
	List<LoaiDT> getAll();
	@Query(value="select vt.tenvt from vaitro vt \r\n" + 
			" inner join qluser qlu on qlu.idvaitro=vt.id \r\n" + 
			" where qlu.tendangnhap=? and vt.isdelete=0",nativeQuery = true)
      String tenvt(String name);
}
