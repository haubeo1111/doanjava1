package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.KhongDiLamRepository;
import com.example.demo.models.KhongDiLam;

@Service
public class KhongDiLamServiceImpl implements KhongDiLamService{
@Autowired
KhongDiLamRepository khongDiLamRepository;

@Override
public List<KhongDiLam> getAll() {
	return khongDiLamRepository.getAll();
}

@Override
public Optional<KhongDiLam> find(int id) {
	return khongDiLamRepository.find(id);
}

@Override
public Optional<KhongDiLam> findma(long idnhanvien) {
	return khongDiLamRepository.findma(idnhanvien);
}

@Override
public List<KhongDiLam> findup(String name) {
	return khongDiLamRepository.findup(name);
}

@Override
public KhongDiLam save(KhongDiLam entity) {
	return khongDiLamRepository.save(entity);
}

@Override
public List<KhongDiLam>  saveAll(List<KhongDiLam> entities) {
	return (List<KhongDiLam>) khongDiLamRepository.saveAll(entities);
}

@Override
public Optional<KhongDiLam> findById(Long id) {
	return khongDiLamRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return khongDiLamRepository.existsById(id);
}

@Override
public List<KhongDiLam> findAll() {
	return (List<KhongDiLam>) khongDiLamRepository.findAll();
}

@Override
public List<KhongDiLam> findAllById(List<Long> ids) {
	return (List<KhongDiLam>) khongDiLamRepository.findAllById(ids);
}

@Override
public long count() {
	return khongDiLamRepository.count();
}

@Override
public void deleteById(Long id) {
	khongDiLamRepository.deleteById(id);
}

@Override
public void delete(KhongDiLam entity) {
	khongDiLamRepository.delete(entity);
}

@Override
public void deleteAll(List<KhongDiLam> entities) {
	khongDiLamRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	khongDiLamRepository.deleteAll();
}

}
