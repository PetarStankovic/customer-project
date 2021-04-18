package it.engineering.springboot.application.customer.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.springboot.application.customer.dto.LicenseDto;
import it.engineering.springboot.application.customer.entity.LicenseEntity;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotExistException;
import it.engineering.springboot.application.customer.mapper.impl.LicenseMapper;
import it.engineering.springboot.application.customer.repository.LicenseRepository;
import it.engineering.springboot.application.customer.service.LicenseService;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class LicenseServiceImpl implements LicenseService {

	private final LicenseMapper licenseMapper;
	private final LicenseRepository licenseRepository;

	@Autowired
	public LicenseServiceImpl(LicenseMapper licenseMapper, LicenseRepository licenseRepository) {
		this.licenseMapper = licenseMapper;
		this.licenseRepository = licenseRepository;
	}

	@Override
	public Optional<LicenseDto> findById(Long id) {
		Optional<LicenseEntity> license = licenseRepository.findById(id);
		if (license.isPresent()) {
			return Optional.of(licenseMapper.toDto(license.get()));
		}
		return Optional.empty();
	}

	@Override
	public List<LicenseDto> getAll() {
		List<LicenseEntity> entities = licenseRepository.findAll();
		return entities.stream().map(entity -> {
			return licenseMapper.toDto(entity);
		}).collect(Collectors.toList());
	}

	@Override
	public LicenseDto save(LicenseDto licenseDto) throws MyEntityExistException {
		Optional<LicenseEntity> entity = licenseRepository.findById(licenseDto.getId());
		if (entity.isPresent()) {
			throw new MyEntityExistException("License already exists!", licenseMapper.toDto(entity.get()));
		}
		LicenseEntity license = licenseRepository.save(licenseMapper.toEntity(licenseDto));
		return licenseMapper.toDto(license);
	}

	@Override
	public Optional<LicenseDto> update(LicenseDto licenseDto){
		Optional<LicenseEntity> entity = licenseRepository.findById(licenseDto.getId());
		if (entity.isPresent()) {
			LicenseEntity license = licenseRepository.save(licenseMapper.toEntity(licenseDto));
			return Optional.of(licenseMapper.toDto(license));
		}
		return Optional.empty();
	}

	@Override
	public void delete(Long id) throws MyEntityNotExistException {
		Optional<LicenseEntity> entity = licenseRepository.findById(id);
		if (!entity.isPresent()) {
			throw new MyEntityNotExistException("License with id: " + id + " doesn't exist!", null);
		}
		licenseRepository.delete(entity.get());

	}

}
