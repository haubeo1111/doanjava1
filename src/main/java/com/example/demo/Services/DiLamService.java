package com.example.demo.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.DiLam;

public interface DiLamService {

	void deleteAll();

	void deleteAll(List<DiLam> entities);

	void delete(DiLam entity);

	void deleteById(Long id);

	long count();

	List<DiLam> findAllById(List<Long> ids);

	Iterable<DiLam> findAll();

	boolean existsById(Long id);

	Optional<DiLam> findById(Long id);

	List<DiLam> saveAll(List<DiLam>  entities);

	DiLam save(DiLam entity);

	List<DiLam> findup(String name);

	Optional<DiLam> findma(long idnhanvien);

	Optional<DiLam> find(int id);

	List<DiLam> getAll();

	long sotien(long id, Date ngaydau, Date ngaycuoi);

}
