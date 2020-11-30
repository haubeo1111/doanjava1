package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DiLam;
import com.example.demo.models.KhongDiLam;

@Repository
public interface KhongDiLamRepository extends CrudRepository<KhongDiLam,Long>{
	@Query(value = "select * from KhongDiLam where isdelete=0",nativeQuery=true)
	List<KhongDiLam> getAll();
	@Query(value = "select * from KhongDiLam where id=? and isdelete=0",nativeQuery=true)
	Optional<KhongDiLam> find(int id);
	@Query(value = "select * from KhongDiLam where idnhanvien=? and isdelete=0",nativeQuery=true)
	Optional<KhongDiLam> findma(long idnhanvien);
	@Query(value = "SELECT * FROM KhongDiLam WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<KhongDiLam> findup(String name);
}
