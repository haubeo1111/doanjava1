package com.example.demo.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ChucNangRepository;
import com.example.demo.models.ChucNang;

@Service
public class ChucNangServiceImpl implements ChucNangService {
@Autowired
ChucNangRepository chucNangRepository;

@Override
//@Cacheable("allchucnang")
public List<ChucNang> getAll() {
	
	 System.out.println("Searching by ID  :");
	return chucNangRepository.getAll();
}



@Override
public List<ChucNang> findlkk(String name) {
	return chucNangRepository.findlkk(name);
}



@Override
public List<ChucNang> chucnangus(long id) {
	return chucNangRepository.chucnangus(id);
}



@Override
public Optional<ChucNang> find(long id) {
	return chucNangRepository.find(id);
}

@Override
public List<ChucNang> findup(String name) {
	return chucNangRepository.findup(name);
}

@Override
public ChucNang save(ChucNang entity) {
	return chucNangRepository.save(entity);
}

@Override
public List<ChucNang>  saveAll(List<ChucNang> entities) {
	return (List<ChucNang>) chucNangRepository.saveAll(entities);
}

@Override
public Optional<ChucNang> findById(Long id) {
	return chucNangRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return chucNangRepository.existsById(id);
}

@Override
public List<ChucNang> findAll() {
	return (List<ChucNang>) chucNangRepository.findAll();
}

@Override
public List<ChucNang> findAllById(List<Long> ids) {
	return (List<ChucNang>) chucNangRepository.findAllById(ids);
}

@Override
public long count() {
	return chucNangRepository.count();
}

@Override
public void deleteById(Long id) {
	chucNangRepository.deleteById(id);
}

@Override
public void delete(ChucNang entity) {
	chucNangRepository.delete(entity);
}

@Override
public void deleteAll(List<ChucNang> entities) {
	chucNangRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	chucNangRepository.deleteAll();
}

}
