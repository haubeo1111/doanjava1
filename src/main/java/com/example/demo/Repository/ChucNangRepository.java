package com.example.demo.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ChucNang;
import com.example.demo.models.ChucNang;
import com.example.demo.models.QLUser;


@Repository
public interface ChucNangRepository extends CrudRepository<ChucNang,Long>{
	@Query(value = "select * from ChucNang where isdelete=0 order by cncha",nativeQuery=true)
	List<ChucNang> getAll();
	@Query(value = "select * from ChucNang where id=? and isdelete=0",nativeQuery=true)
	Optional<ChucNang> find(Long id);
	@Query(value = "SELECT * FROM ChucNang WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<ChucNang> findup(String name);
	@Query(value = "SELECT * FROM ChucNang WHERE tencn LIKE ? and isdelete=0  ",nativeQuery=true)
	List<ChucNang> findlkk(String name);
	@Query(value ="select cn.id  from chucnang cn \r\n" + 
			"     inner join    userchucnang ucn on ucn.idcn=cn.id  \r\n" + 
			"	inner join qluser qlu on qlu.id=ucn.iduser \r\n" + 
			"	where qlu.id=?",nativeQuery = true)
	 List<ChucNang>chucnangus(long id);
}
