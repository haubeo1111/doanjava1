package com.example.demo.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TangCa;
import com.example.demo.models.TangCa;

@Repository
public interface TangCaRepository extends CrudRepository<TangCa,Long>{
	@Query(value = "select * from TangCa where isdelete=0",nativeQuery=true)
	List<TangCa> getAll();
	@Query(value = "select * from TangCa where id=? and isdelete=0",nativeQuery=true)
	Optional<TangCa> find(long id);
	
	@Query(value = " select sum(tc.tongtien) from tangca tc \r\n" + 
			" where tc.idemployee= ? and tc.ngaytang>=? and tc.ngaytang <=? and isdelete=0",nativeQuery=true)
	long tongtien(long id,Date ngaydau,Date ngaycuoi);
	@Query(value = " select sum(tc.gio) from tangca tc \r\n" + 
			" where tc.idemployee= ? and tc.ngaytang>=? and tc.ngaytang <=? and isdelete=0",nativeQuery=true)
	int sogio(long id,Date ngaydau,Date ngaycuoi);
	@Query(value = "SELECT * FROM TangCa WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<TangCa> findup(String name);
}
