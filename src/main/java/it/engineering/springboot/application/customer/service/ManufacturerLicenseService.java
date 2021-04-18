package it.engineering.springboot.application.customer.service;

import java.util.List;
import java.util.Optional;

import it.engineering.springboot.application.customer.dto.LicenseDto;
import it.engineering.springboot.application.customer.dto.ManufacturerLicenseDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotExistException;

public interface ManufacturerLicenseService {

	Optional<ManufacturerLicenseDto> findById(Long id);

	List<ManufacturerLicenseDto> getAll();

	LicenseDto save(ManufacturerLicenseDto manufacturerLicenseDto) throws MyEntityExistException;

	Optional<ManufacturerLicenseDto> update(ManufacturerLicenseDto manufacturerLicenseDto);

	void delete(Long id) throws MyEntityNotExistException;
	
}
