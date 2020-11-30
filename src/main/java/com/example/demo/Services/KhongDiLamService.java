package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.KhongDiLam;

public interface KhongDiLamService {

	void deleteAll();

	void deleteAll(List<KhongDiLam> entities);

	void delete(KhongDiLam entity);

	void deleteById(Long id);

	long count();

	List<KhongDiLam> findAllById(List<Long> ids);

	List<KhongDiLam> findAll();

	boolean existsById(Long id);

	Optional<KhongDiLam> findById(Long id);

	List<KhongDiLam> saveAll(List<KhongDiLam> entities);

	KhongDiLam save(KhongDiLam entity);

	List<KhongDiLam> findup(String name);

	Optional<KhongDiLam> findma(long idnhanvien);

	Optional<KhongDiLam> find(int id);

	List<KhongDiLam> getAll();

}
