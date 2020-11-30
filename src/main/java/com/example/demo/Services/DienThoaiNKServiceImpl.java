package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.DienThoaiNKRepository;
import com.example.demo.models.DienThoaiNK;

@Service
public class DienThoaiNKServiceImpl implements DienThoaiNKService   {
@Autowired
DienThoaiNKRepository dienThoaiNKRepository;

@Override
public List<DienThoaiNK> getAll() {
	return dienThoaiNKRepository.getAll();
}

@Override
public List<DienThoaiNK> getAllnk(long mank) {
	return dienThoaiNKRepository.getAllnk(mank);
}

@Override
public Optional<DienThoaiNK> find(long id) {
	return dienThoaiNKRepository.find(id);
}

@Override
public List<DienThoaiNK> findup(String name) {
	return dienThoaiNKRepository.findup(name);
}

@Override
public List<DienThoaiNK> findlk(String name) {
	return dienThoaiNKRepository.findlk(name);
}

@Override
public DienThoaiNK save(DienThoaiNK entity) {
	return dienThoaiNKRepository.save(entity);
}

@Override
public List<DienThoaiNK> findByNameLike(String name) {
	return dienThoaiNKRepository.findByNameLike(name);
}

@Override
public List<DienThoaiNK> saveAll(List<DienThoaiNK> entities) {
	return (List<DienThoaiNK>) dienThoaiNKRepository.saveAll(entities);
}

@Override
public Optional<DienThoaiNK> findById(Long id) {
	return dienThoaiNKRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return dienThoaiNKRepository.existsById(id);
}

@Override
public List<DienThoaiNK> findAll() {
	return (List<DienThoaiNK>) dienThoaiNKRepository.findAll();
}

@Override
public List<DienThoaiNK> findAllById(List<Long> ids) {
	return (List<DienThoaiNK>) dienThoaiNKRepository.findAllById(ids);
}

@Override
public long count() {
	return dienThoaiNKRepository.count();
}

@Override
public void deleteById(Long id) {
	dienThoaiNKRepository.deleteById(id);
}

@Override
public void delete(DienThoaiNK entity) {
	dienThoaiNKRepository.delete(entity);
}

@Override
public void deleteAll(List<DienThoaiNK> entities) {
	dienThoaiNKRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	dienThoaiNKRepository.deleteAll();
}

}
