package com.example.demo.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DiLam;
import com.example.demo.models.DiLam;

@Repository
public interface DiLamRepository extends CrudRepository<DiLam,Long>{
	//@Query(value = "select id,idnhanvien,ditre,vesom,uutu,tinhtrang,ngaydilam,sotien,isdelete from DiLam where isdelete=0",nativeQuery=true)
	@Query(value = "select * from DiLam where isdelete=0",nativeQuery=true)
	List<DiLam> getAll();
	@Query(value = "select * from DiLam where id=? and isdelete=0",nativeQuery=true)
	Optional<DiLam> find(int id);
	@Query(value = " select sum(tc.sotien) from dilam tc \r\n" + 
			" where tc.idnhanvien= ? and tc.ngaydilam >=? and tc.ngaydilam <=? and isdelete=0",nativeQuery=true)
	Long sotien(long idemployee,Date ngaydau,Date ngaycuoi);
	@Query(value = "select * from DiLam where idnhanvien=? and isdelete=0",nativeQuery=true)
	Optional<DiLam> findma(long idnhanvien);
	@Query(value = "SELECT * FROM DiLam WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<DiLam> findup(String name);
}
