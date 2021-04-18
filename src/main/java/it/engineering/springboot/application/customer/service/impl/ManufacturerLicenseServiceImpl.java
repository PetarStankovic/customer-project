package it.engineering.springboot.application.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.springboot.application.customer.dto.LicenseDto;
import it.engineering.springboot.application.customer.dto.ManufacturerLicenseDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotExistException;
import it.engineering.springboot.application.customer.service.ManufacturerLicenseService;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ManufacturerLicenseServiceImpl implements ManufacturerLicenseService{

	@Override
	public Optional<ManufacturerLicenseDto> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ManufacturerLicenseDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LicenseDto save(ManufacturerLicenseDto manufacturerLicenseDto) throws MyEntityExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ManufacturerLicenseDto> update(ManufacturerLicenseDto manufacturerLicenseDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws MyEntityNotExistException {
		// TODO Auto-generated method stub
		
	}

}
