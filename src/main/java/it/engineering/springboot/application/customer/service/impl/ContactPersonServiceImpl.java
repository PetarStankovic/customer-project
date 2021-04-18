package it.engineering.springboot.application.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.springboot.application.customer.dto.ContactPersonDto;
import it.engineering.springboot.application.customer.dto.LicenseDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotExistException;
import it.engineering.springboot.application.customer.service.ContactPersonService;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ContactPersonServiceImpl implements ContactPersonService{

	@Override
	public Optional<ContactPersonDto> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactPersonDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LicenseDto save(ContactPersonDto contactPersonDto) throws MyEntityExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ContactPersonDto> update(ContactPersonDto contactPersonDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws MyEntityNotExistException {
		// TODO Auto-generated method stub
		
	}

}
