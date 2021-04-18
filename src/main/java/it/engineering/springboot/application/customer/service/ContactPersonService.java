package it.engineering.springboot.application.customer.service;

import java.util.List;
import java.util.Optional;

import it.engineering.springboot.application.customer.dto.ContactPersonDto;
import it.engineering.springboot.application.customer.dto.LicenseDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotExistException;

public interface ContactPersonService {

	Optional<ContactPersonDto> findById(Long id);

	List<ContactPersonDto> getAll();

	LicenseDto save(ContactPersonDto contactPersonDto) throws MyEntityExistException;

	Optional<ContactPersonDto> update(ContactPersonDto contactPersonDto);

	void delete(Long id) throws MyEntityNotExistException;

}
