package it.engineering.springboot.application.customer.service;

import java.util.List;
import java.util.Optional;

import it.engineering.springboot.application.customer.dto.LicenseDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotExistException;

public interface LicenseService {

	Optional<LicenseDto> findById(Long id);

	List<LicenseDto> getAll();

	LicenseDto save(LicenseDto licenseDto) throws MyEntityExistException;

	Optional<LicenseDto> update(LicenseDto licenseDto);

	void delete(Long id) throws MyEntityNotExistException;
}
