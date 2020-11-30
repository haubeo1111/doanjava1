package com.example.demo.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.NhaNuoc;

public interface NhaNuocService {

	void deleteAll();

	void deleteAll(List<NhaNuoc> entities);

	void delete(NhaNuoc entity);

	void deleteById(Long id);

	long count();

	List<NhaNuoc> findAllById(List<Long> ids);

	List<NhaNuoc> findAll();

	boolean existsById(Long id);

	Optional<NhaNuoc> findById(Long id);

	List<NhaNuoc> saveAll(List<NhaNuoc> entities);

	NhaNuoc save(NhaNuoc entity);

	List<NhaNuoc> findup(String name);

	Optional<NhaNuoc> find(long id);

	List<NhaNuoc> getAll();

	Optional<NhaNuoc> nam(int nam);

}
