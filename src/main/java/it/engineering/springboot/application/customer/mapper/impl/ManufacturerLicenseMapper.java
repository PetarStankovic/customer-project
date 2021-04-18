package it.engineering.springboot.application.customer.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.dto.ManufacturerLicenseDto;
import it.engineering.springboot.application.customer.entity.ManufacturerLicenseEntity;
import it.engineering.springboot.application.customer.mapper.EntityDtoMapper;

@Component
public class ManufacturerLicenseMapper implements EntityDtoMapper<ManufacturerLicenseDto, ManufacturerLicenseEntity> {

	private final ManufacturerMapper manufacturerMapper;
	private final LicenseMapper licenseMapper;

	@Autowired
	public ManufacturerLicenseMapper(LicenseMapper licenseMapper, ManufacturerMapper manufacturerMapper) {
		this.manufacturerMapper = manufacturerMapper;
		this.licenseMapper = licenseMapper;
	}

	@Override
	public ManufacturerLicenseDto toDto(ManufacturerLicenseEntity entity) {
		return new ManufacturerLicenseDto(entity.getId(), entity.getAcceptedDate(),
				manufacturerMapper.toDto(entity.getManufacturer()), licenseMapper.toDto(entity.getLicense()));
	}

	@Override
	public ManufacturerLicenseEntity toEntity(ManufacturerLicenseDto dto) {
		return new ManufacturerLicenseEntity(dto.getId(), dto.getAcceptedDate(),
				manufacturerMapper.toEntity(dto.getManufacturer()), licenseMapper.toEntity(dto.getLicense()));
	}

}
