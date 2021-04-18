package it.engineering.springboot.application.customer.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.engineering.springboot.application.customer.dto.LicenseDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotExistException;
import it.engineering.springboot.application.customer.service.LicenseService;

@RestController
@RequestMapping(path = "/api/license")
@Transactional
public class LicenseRestController {

	private final LicenseService licenseService;

	@Autowired
	public LicenseRestController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}

	@GetMapping
	public @ResponseBody ResponseEntity<List<LicenseDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(licenseService.getAll());
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<LicenseDto> licenseDto = licenseService.findById(id);
		if (licenseDto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(licenseDto.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("License with id " + id + " doesn't exist!");
		}
	}

	@PostMapping
	public @ResponseBody ResponseEntity<Object> save(@RequestBody LicenseDto licenseDto) {
		try {
			LicenseDto license = licenseService.save(licenseDto);
			return ResponseEntity.status(HttpStatus.OK).body(license);
		} catch (MyEntityExistException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Greska kod cuvanja licence: " + licenseDto);
		}
	}

	@PutMapping
	public @ResponseBody ResponseEntity<LicenseDto> update(@RequestBody LicenseDto licenseDto) {

		Optional<LicenseDto> license = licenseService.update(licenseDto);

		if (license.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(license.get());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(licenseDto);
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
		try {
			licenseService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted license with id: " + id);
		} catch (MyEntityNotExistException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
