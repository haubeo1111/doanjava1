package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.DienThoaiNK;

public interface DienThoaiNKService {

	void deleteAll();

	void deleteAll(List<DienThoaiNK> entities);

	void delete(DienThoaiNK entity);

	void deleteById(Long id);

	long count();

	List<DienThoaiNK> findAllById(List<Long> ids);

	List<DienThoaiNK> findAll();

	boolean existsById(Long id);

	Optional<DienThoaiNK> findById(Long id);

	List<DienThoaiNK> saveAll(List<DienThoaiNK> entities);

	List<DienThoaiNK> findByNameLike(String name);

	DienThoaiNK save(DienThoaiNK entity);

	List<DienThoaiNK> findlk(String name);

	List<DienThoaiNK> findup(String name);

	Optional<DienThoaiNK> find(long id);

	List<DienThoaiNK> getAllnk(long mank);

	List<DienThoaiNK> getAll();

}
