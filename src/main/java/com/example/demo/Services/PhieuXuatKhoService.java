package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.PhieuXuatKho;

public interface PhieuXuatKhoService {

	void deleteAll();

	void deleteAll(List<PhieuXuatKho> entities);

	void delete(PhieuXuatKho entity);

	void deleteById(Long id);

	long count();

	List<PhieuXuatKho> findAllById(List<Long> ids);

	List<PhieuXuatKho> findAll();

	boolean existsById(Long id);

	Optional<PhieuXuatKho> findById(Long id);

	List<PhieuXuatKho> saveAll(List<PhieuXuatKho> entities);

	PhieuXuatKho save(PhieuXuatKho entity);

	Optional<PhieuXuatKho> find(long id);

	List<PhieuXuatKho> getAll();

}
