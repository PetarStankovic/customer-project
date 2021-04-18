package it.engineering.springboot.application.customer.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.springboot.application.customer.dto.CityDto;
import it.engineering.springboot.application.customer.entity.CityEntity;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotExistException;
import it.engineering.springboot.application.customer.mapper.impl.CityMapper;
import it.engineering.springboot.application.customer.repository.CityRepository;
import it.engineering.springboot.application.customer.service.CityService;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class CityServiceImpl implements CityService {

	private final CityRepository cityRepository;

	private final CityMapper cityMapper;

	@Autowired
	public CityServiceImpl(CityRepository cityRepository, CityMapper cityMapper) {
		this.cityRepository = cityRepository;
		this.cityMapper = cityMapper;
	}

	public Optional<CityDto> findById(Long cityCode) {
		Optional<CityEntity> city = cityRepository.findById(cityCode);
		if (city.isPresent()) {
			return Optional.of(cityMapper.toDto(city.get())); // iz optional uzimamo objekat city
		}
		return Optional.empty();
	}

	@Override
	public List<CityDto> getAll() {
		List<CityEntity> entities = cityRepository.findAll();
		return entities.stream().map(entity -> {
			return cityMapper.toDto(entity);
		}).collect(Collectors.toList());
	}

	public CityDto save(CityDto cityDto) throws MyEntityExistException {
		Optional<CityEntity> entity = cityRepository.findById(cityDto.getCityCode());
		if (entity.isPresent()) {
			throw new MyEntityExistException("City already exists!", cityMapper.toDto(entity.get()));
		}
		CityEntity city = cityRepository.save(cityMapper.toEntity(cityDto));
		return cityMapper.toDto(city);
	}

	public Optional<CityDto> update(CityDto cityDto) {
		Optional<CityEntity> entity = cityRepository.findById(cityDto.getCityCode());
		if (entity.isPresent()) {
			CityEntity cityEntity = cityRepository.save(cityMapper.toEntity(cityDto));
			return Optional.of(cityMapper.toDto(cityEntity));
		}
		// ili baciti izuzetak: pogledati save() metodu
		return Optional.empty();
	}

	public void delete(Long cityCode) throws MyEntityNotExistException {
		Optional<CityEntity> entity = cityRepository.findById(cityCode);
		if (!entity.isPresent()) {
			throw new MyEntityNotExistException("City with code: " + cityCode + " doesn't exist!", null);
		}
		cityRepository.delete(entity.get());
	}

}
