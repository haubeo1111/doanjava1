package com.example.demo.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.NhaNuoc;
import com.example.demo.models.NhaNuoc;

@Repository
public interface NhaNuocRepository extends CrudRepository<NhaNuoc,Long>{
	@Query(value = "select * from NhaNuoc where isdelete=0",nativeQuery=true)
	List<NhaNuoc> getAll();
	@Query(value = "select * from NhaNuoc where id=? and isdelete=0",nativeQuery=true)
	Optional<NhaNuoc> find(long id);
	@Query(value = "select * from NhaNuoc nn where  date_part('year',nn.nam)=?  and isdelete=0",nativeQuery=true)
	Optional<NhaNuoc> nam(int nam);
	@Query(value = "SELECT * FROM NhaNuoc WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<NhaNuoc> findup(String name);
}
