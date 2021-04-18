package it.engineering.springboot.application.customer.mapper.impl;

import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.dto.LicenseDto;
import it.engineering.springboot.application.customer.entity.LicenseEntity;
import it.engineering.springboot.application.customer.mapper.EntityDtoMapper;

@Component
public class LicenseMapper implements EntityDtoMapper<LicenseDto, LicenseEntity> {

	@Override
	public LicenseDto toDto(LicenseEntity entity) {
		return new LicenseDto(entity.getId(), entity.getName());
	}

	@Override
	public LicenseEntity toEntity(LicenseDto dto) {
		return new LicenseEntity(dto.getId(), dto.getName());
	}

}
