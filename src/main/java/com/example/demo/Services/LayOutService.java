package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.LayOut;
import com.example.demo.models.LoaiDT;

public interface LayOutService {

	void deleteAll();

	void deleteAll(List<LayOut> entities);

	void delete(LayOut entity);

	void deleteById(Long id);

	long count();

	List<LayOut> findAllById(List<Long> ids);

	List<LayOut> findAll();

	boolean existsById(Long id);

	Optional<LayOut> findById(Long id);

	List<LayOut> saveAll(List<LayOut> entities);

	LayOut save(LayOut entity);

	List<LoaiDT> getAll();

	String tenvt(String name);

}
