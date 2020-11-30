package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.DienThoaiXK;

public interface DienThoaiXKService {

	void deleteAll();

	void deleteAll(List<DienThoaiXK> entities);

	void delete(DienThoaiXK entity);

	void deleteById(Long id);

	long count();

	List<DienThoaiXK> findAllById(List<Long> ids);

	List<DienThoaiXK> findAll();

	boolean existsById(Long id);

	Optional<DienThoaiXK> findById(Long id);

	List<DienThoaiXK> saveAll(List<DienThoaiXK> entities);

	List<DienThoaiXK> findByNameLike(String name);

	List<DienThoaiXK> findlk(String name);

	DienThoaiXK save(DienThoaiXK entity);

	List<DienThoaiXK> findup(String name);

	Optional<DienThoaiXK> find(long id);

	List<DienThoaiXK> getAllnk(long maxk);

	List<DienThoaiXK> getAll();

}
