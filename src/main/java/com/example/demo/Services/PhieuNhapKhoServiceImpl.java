package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PhieuNhapKhoRepository;
import com.example.demo.models.PhieuNhapKho;

@Service
public class PhieuNhapKhoServiceImpl implements PhieuNhapKhoService  {
@Autowired
PhieuNhapKhoRepository phieuNhapKhoRepository;

@Override
public List<PhieuNhapKho> getAll() {
	return phieuNhapKhoRepository.getAll();
}

@Override
public Optional<PhieuNhapKho> find(long id) {
	return phieuNhapKhoRepository.find(id);
}

@Override
public PhieuNhapKho save(PhieuNhapKho entity) {
	return phieuNhapKhoRepository.save(entity);
}

@Override
public List<PhieuNhapKho>  saveAll(List<PhieuNhapKho> entities) {
	return (List<PhieuNhapKho>) phieuNhapKhoRepository.saveAll(entities);
}

@Override
public Optional<PhieuNhapKho> findById(Long id) {
	return phieuNhapKhoRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return phieuNhapKhoRepository.existsById(id);
}

@Override
public List<PhieuNhapKho> findAll() {
	return (List<PhieuNhapKho>) phieuNhapKhoRepository.findAll();
}

@Override
public List<PhieuNhapKho> findAllById(List<Long> ids) {
	return (List<PhieuNhapKho>) phieuNhapKhoRepository.findAllById(ids);
}

@Override
public long count() {
	return phieuNhapKhoRepository.count();
}

@Override
public void deleteById(Long id) {
	phieuNhapKhoRepository.deleteById(id);
}

@Override
public void delete(PhieuNhapKho entity) {
	phieuNhapKhoRepository.delete(entity);
}

@Override
public void deleteAll(List<PhieuNhapKho> entities) {
	phieuNhapKhoRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	phieuNhapKhoRepository.deleteAll();
}

}
