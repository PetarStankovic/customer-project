package it.engineering.springboot.application.customer.service;

import java.util.List;
import java.util.Optional;

import it.engineering.springboot.application.customer.dto.ManufacturerDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotExistException;
import it.engineering.springboot.application.customer.exception.MyManufacturerInvalidCityException;

public interface ManufacturerService {

	List<ManufacturerDto> getAll();

	Optional<ManufacturerDto> findById(Long id);

	void delete(Long id) throws MyEntityNotExistException;

	ManufacturerDto save(ManufacturerDto manufacturerDto) throws MyEntityExistException;

	Optional<ManufacturerDto> update(ManufacturerDto manufacturerDto) throws MyManufacturerInvalidCityException;

}
