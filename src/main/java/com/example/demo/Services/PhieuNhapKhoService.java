package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.PhieuNhapKho;

public interface PhieuNhapKhoService {

	void deleteAll();

	void deleteAll(List<PhieuNhapKho> entities);

	void delete(PhieuNhapKho entity);

	void deleteById(Long id);

	long count();

	List<PhieuNhapKho> findAllById(List<Long> ids);

	List<PhieuNhapKho> findAll();

	boolean existsById(Long id);

	Optional<PhieuNhapKho> findById(Long id);

	List<PhieuNhapKho> saveAll(List<PhieuNhapKho> entities);

	PhieuNhapKho save(PhieuNhapKho entity);

	Optional<PhieuNhapKho> find(long id);

	List<PhieuNhapKho> getAll();

}
