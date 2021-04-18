package it.engineering.springboot.application.customer.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.springboot.application.customer.dto.CityDto;
import it.engineering.springboot.application.customer.dto.ManufacturerDto;
import it.engineering.springboot.application.customer.entity.CityEntity;
import it.engineering.springboot.application.customer.entity.ManufacturerEntity;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotExistException;
import it.engineering.springboot.application.customer.exception.MyManufacturerInvalidCityException;
import it.engineering.springboot.application.customer.mapper.impl.ManufacturerMapper;
import it.engineering.springboot.application.customer.repository.CityRepository;
import it.engineering.springboot.application.customer.repository.ManufacturerRepository;
import it.engineering.springboot.application.customer.service.ManufacturerService;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ManufacturerServiceImpl implements ManufacturerService {

	private ManufacturerRepository manufacturerRepository;
	
	private CityRepository cityRepository;

	private ManufacturerMapper manufacturerMapper;

	@Autowired
	public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository,
			ManufacturerMapper manufacturerMapper, CityRepository cityRepository) {
		this.manufacturerRepository = manufacturerRepository;
		this.manufacturerMapper = manufacturerMapper;
		this.cityRepository = cityRepository;
	}
	
	

	@Override
	public List<ManufacturerDto> getAll() {
		List<ManufacturerEntity> entities = manufacturerRepository.findAll();
		return entities.stream().map(entity -> {
			return manufacturerMapper.toDto(entity);
		}).collect(Collectors.toList());
		
		
	}

	@Override
	public Optional<ManufacturerDto> findById(Long id) {
		Optional<ManufacturerEntity> manufacturer = manufacturerRepository.findById(id);
		if (manufacturer.isPresent()) {
			return Optional.of(manufacturerMapper.toDto(manufacturer.get()));
		}
		return Optional.empty();
	}

	@Override
	public void delete(Long id) throws MyEntityNotExistException {
		Optional<ManufacturerEntity> entity = manufacturerRepository.findById(id);
		if (!entity.isPresent()) {
			throw new MyEntityNotExistException("Manufacturer with id: " + id + " doesn't exist!", null);
		}
		manufacturerRepository.delete(entity.get());
	}

	@Override
	public ManufacturerDto save(ManufacturerDto manufacturerDto) throws MyEntityExistException {
		Optional<ManufacturerEntity> entity = manufacturerRepository.findById(manufacturerDto.getId());
		if (entity.isPresent()) {
			throw new MyEntityExistException("Manufacturer already exists!", manufacturerMapper.toDto(entity.get()));
		}
		ManufacturerEntity manufacturer = manufacturerRepository.save(manufacturerMapper.toEntity(manufacturerDto));
		return manufacturerMapper.toDto(manufacturer);
	}

	@Override
	public Optional<ManufacturerDto> update(ManufacturerDto manufacturerDto) throws MyManufacturerInvalidCityException{
		Optional<CityEntity> cityEntity = cityRepository.findById(manufacturerDto.getCity().getCityCode());
		if(!cityEntity.isPresent()){
			throw new MyManufacturerInvalidCityException("Invalid city, can't update manufacturer!");
		}
		
		
		Optional<ManufacturerEntity> entity = manufacturerRepository.findById(manufacturerDto.getId());
		if (entity.isPresent()) {
			ManufacturerEntity manufacturerEntity = manufacturerRepository
					.save(manufacturerMapper.toEntity(manufacturerDto));
			return Optional.of(manufacturerMapper.toDto(manufacturerEntity));
		}
		return Optional.empty();
	}
}
