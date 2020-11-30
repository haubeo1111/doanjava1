package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PhieuXuatKhoRepository;
import com.example.demo.models.PhieuXuatKho;

@Service
public class PhieuXuatKhoServiceImpl implements PhieuXuatKhoService {
	@Autowired
	PhieuXuatKhoRepository PhieuXuatKhoRepository;

	@Override
	public List<PhieuXuatKho> getAll() {
		return PhieuXuatKhoRepository.getAll();
	}

	@Override
	public Optional<PhieuXuatKho> find(long id) {
		return PhieuXuatKhoRepository.find(id);
	}

	@Override
	public PhieuXuatKho save(PhieuXuatKho entity) {
		return PhieuXuatKhoRepository.save(entity);
	}

	@Override
	public List<PhieuXuatKho>  saveAll(List<PhieuXuatKho> entities) {
		return (List<PhieuXuatKho>) PhieuXuatKhoRepository.saveAll(entities);
	}

	@Override
	public Optional<PhieuXuatKho> findById(Long id) {
		return PhieuXuatKhoRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return PhieuXuatKhoRepository.existsById(id);
	}

	@Override
	public List<PhieuXuatKho> findAll() {
		return (List<PhieuXuatKho>) PhieuXuatKhoRepository.findAll();
	}

	@Override
	public List<PhieuXuatKho> findAllById(List<Long> ids) {
		return (List<PhieuXuatKho>) PhieuXuatKhoRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return PhieuXuatKhoRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		PhieuXuatKhoRepository.deleteById(id);
	}

	@Override
	public void delete(PhieuXuatKho entity) {
		PhieuXuatKhoRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<PhieuXuatKho> entities) {
		PhieuXuatKhoRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		PhieuXuatKhoRepository.deleteAll();
	}
}
