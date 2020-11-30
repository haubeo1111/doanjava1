package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.DienThoaiXKRepository;
import com.example.demo.models.DienThoaiXK;

@Service
public class DienThoaiXKServiceImpl implements DienThoaiXKService{
@Autowired
DienThoaiXKRepository dienThoaiXKRepository;

@Override
public List<DienThoaiXK> getAll() {
	return dienThoaiXKRepository.getAll();
}

@Override
public List<DienThoaiXK> getAllnk(long maxk) {
	return dienThoaiXKRepository.getAllnk(maxk);
}

@Override
public Optional<DienThoaiXK> find(long id) {
	return dienThoaiXKRepository.find(id);
}

@Override
public List<DienThoaiXK> findup(String name) {
	return dienThoaiXKRepository.findup(name);
}

@Override
public DienThoaiXK save(DienThoaiXK entity) {
	return dienThoaiXKRepository.save(entity);
}

@Override
public List<DienThoaiXK> findlk(String name) {
	return dienThoaiXKRepository.findlk(name);
}

@Override
public List<DienThoaiXK> findByNameLike(String name) {
	return dienThoaiXKRepository.findByNameLike(name);
}

@Override
public List<DienThoaiXK>  saveAll(List<DienThoaiXK> entities) {
	return (List<DienThoaiXK>) dienThoaiXKRepository.saveAll(entities);
}

@Override
public Optional<DienThoaiXK> findById(Long id) {
	return dienThoaiXKRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return dienThoaiXKRepository.existsById(id);
}

@Override
public List<DienThoaiXK> findAll() {
	return (List<DienThoaiXK>) dienThoaiXKRepository.findAll();
}

@Override
public List<DienThoaiXK> findAllById(List<Long> ids) {
	return (List<DienThoaiXK>) dienThoaiXKRepository.findAllById(ids);
}

@Override
public long count() {
	return dienThoaiXKRepository.count();
}

@Override
public void deleteById(Long id) {
	dienThoaiXKRepository.deleteById(id);
}

@Override
public void delete(DienThoaiXK entity) {
	dienThoaiXKRepository.delete(entity);
}

@Override
public void deleteAll(List<DienThoaiXK> entities) {
	dienThoaiXKRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	dienThoaiXKRepository.deleteAll();
}

}
