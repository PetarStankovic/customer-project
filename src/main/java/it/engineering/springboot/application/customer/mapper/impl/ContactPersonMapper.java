package it.engineering.springboot.application.customer.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.dto.ContactPersonDto;
import it.engineering.springboot.application.customer.entity.ContactPersonEntity;
import it.engineering.springboot.application.customer.mapper.EntityDtoMapper;

@Component
public class ContactPersonMapper implements EntityDtoMapper<ContactPersonDto, ContactPersonEntity> {

	private ManufacturerMapper manufacturerMapper;

	@Autowired
	public ContactPersonMapper(ManufacturerMapper manufacturerMapper) {
		this.manufacturerMapper = manufacturerMapper;
	}

	@Override
	public ContactPersonDto toDto(ContactPersonEntity entity) {
		return new ContactPersonDto(entity.getId(), entity.getFirstname(), entity.getLastname(),
				manufacturerMapper.toDto(entity.getManufacturer()));
	}

	@Override
	public ContactPersonEntity toEntity(ContactPersonDto dto) {
		return new ContactPersonEntity(dto.getId(), dto.getFirstname(), dto.getLastname(),
				manufacturerMapper.toEntity(dto.getManufacturer()));
	}

}
