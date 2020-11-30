package com.example.demo.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.DiLamRepository;
import com.example.demo.models.DiLam;

@Service
public class DiLamServiceImpl implements DiLamService{
@Autowired
DiLamRepository diLamRepository;

@Override
public List<DiLam> getAll() {
	return diLamRepository.getAll();
}

@Override
public long sotien(long id, Date ngaydau, Date ngaycuoi) {
	return diLamRepository.sotien(id, ngaydau, ngaycuoi);
}

@Override
public Optional<DiLam> find(int id) {
	return diLamRepository.find(id);
}

@Override
public Optional<DiLam> findma(long idnhanvien) {
	return diLamRepository.findma(idnhanvien);
}

@Override
public List<DiLam> findup(String name) {
	return diLamRepository.findup(name);
}

@Override
public DiLam save(DiLam entity) {
	return diLamRepository.save(entity);
}

@Override
public List<DiLam> saveAll(List<DiLam>  entities) {
	return (List<DiLam>) diLamRepository.saveAll(entities);
}

@Override
public Optional<DiLam> findById(Long id) {
	return diLamRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return diLamRepository.existsById(id);
}

@Override
public Iterable<DiLam> findAll() {
	return diLamRepository.findAll();
}

@Override
public List<DiLam> findAllById(List<Long> ids) {
	return (List<DiLam>) diLamRepository.findAllById(ids);
}

@Override
public long count() {
	return diLamRepository.count();
}

@Override
public void deleteById(Long id) {
	diLamRepository.deleteById(id);
}

@Override
public void delete(DiLam entity) {
	diLamRepository.delete(entity);
}

@Override
public void deleteAll(List<DiLam> entities) {
	diLamRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	diLamRepository.deleteAll();
}

}
