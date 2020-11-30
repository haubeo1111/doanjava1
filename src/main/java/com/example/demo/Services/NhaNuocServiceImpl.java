package com.example.demo.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.NhaNuocRepository;
import com.example.demo.models.NhaNuoc;

@Service
public class NhaNuocServiceImpl implements NhaNuocService   {
@Autowired
NhaNuocRepository nhaNuocRepository;

@Override
public List<NhaNuoc> getAll() {
	return nhaNuocRepository.getAll();
}

@Override
public Optional<NhaNuoc> nam(int nam) {
	return nhaNuocRepository.nam(nam);
}

@Override
public Optional<NhaNuoc> find(long id) {
	return nhaNuocRepository.find(id);
}

@Override
public List<NhaNuoc> findup(String name) {
	return nhaNuocRepository.findup(name);
}

@Override
public NhaNuoc save(NhaNuoc entity) {
	return nhaNuocRepository.save(entity);
}

@Override
public List<NhaNuoc>  saveAll(List<NhaNuoc> entities) {
	return (List<NhaNuoc>) nhaNuocRepository.saveAll(entities);
}

@Override
public Optional<NhaNuoc> findById(Long id) {
	return nhaNuocRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return nhaNuocRepository.existsById(id);
}

@Override
public List<NhaNuoc> findAll() {
	return (List<NhaNuoc>) nhaNuocRepository.findAll();
}

@Override
public List<NhaNuoc> findAllById(List<Long> ids) {
	return (List<NhaNuoc>) nhaNuocRepository.findAllById(ids);
}

@Override
public long count() {
	return nhaNuocRepository.count();
}

@Override
public void deleteById(Long id) {
	nhaNuocRepository.deleteById(id);
}

@Override
public void delete(NhaNuoc entity) {
	nhaNuocRepository.delete(entity);
}

@Override
public void deleteAll(List<NhaNuoc> entities) {
	nhaNuocRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	nhaNuocRepository.deleteAll();
}

}
