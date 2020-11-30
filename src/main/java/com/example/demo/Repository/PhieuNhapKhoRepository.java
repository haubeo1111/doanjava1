package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.NhaNuoc;
import com.example.demo.models.PhieuNhapKho;

@Repository
public interface PhieuNhapKhoRepository extends CrudRepository<PhieuNhapKho,Long> {
	@Query(value = "select * from PhieuNhapKho where isdelete=0 order by ngaytao desc ",nativeQuery=true)
	List<PhieuNhapKho> getAll();
	@Query(value = "select * from PhieuNhapKho where id=? and isdelete=0 ",nativeQuery=true)
	Optional<PhieuNhapKho> find(long id);
}
