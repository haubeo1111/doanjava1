package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PhieuXuatKho;

@Repository
public interface PhieuXuatKhoRepository extends CrudRepository<PhieuXuatKho,Long>{
	@Query(value = "select * from PhieuXuatKho where isdelete=0",nativeQuery=true)
	List<PhieuXuatKho> getAll();
	@Query(value = "select * from PhieuXuatKho where id=? and isdelete=0",nativeQuery=true)
	Optional<PhieuXuatKho> find(long id);
}
