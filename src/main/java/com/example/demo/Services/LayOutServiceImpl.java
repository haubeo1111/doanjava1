package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LayOutRepository;
import com.example.demo.models.LayOut;
import com.example.demo.models.LoaiDT;

@Service
public class LayOutServiceImpl implements LayOutService{
@Autowired
LayOutRepository layOutRepository;

@Override
public List<LoaiDT> getAll() {
	return layOutRepository.getAll();
}

@Override
public String tenvt(String name) {
	return layOutRepository.tenvt(name);
}

@Override
public LayOut save(LayOut entity) {
	return layOutRepository.save(entity);
}

@Override
public List<LayOut>  saveAll(List<LayOut> entities) {
	return (List<LayOut>) layOutRepository.saveAll(entities);
}

@Override
public Optional<LayOut> findById(Long id) {
	return layOutRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return layOutRepository.existsById(id);
}

@Override
public List<LayOut> findAll() {
	return (List<LayOut>) layOutRepository.findAll();
}

@Override
public List<LayOut> findAllById(List<Long> ids) {
	return (List<LayOut>) layOutRepository.findAllById(ids);
}

@Override
public long count() {
	return layOutRepository.count();
}

@Override
public void deleteById(Long id) {
	layOutRepository.deleteById(id);
}

@Override
public void delete(LayOut entity) {
	layOutRepository.delete(entity);
}

@Override
public void deleteAll(List<LayOut> entities) {
	layOutRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	layOutRepository.deleteAll();
}

}
