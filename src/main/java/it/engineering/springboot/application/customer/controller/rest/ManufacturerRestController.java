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

import it.engineering.springboot.application.customer.dto.ManufacturerDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotExistException;
import it.engineering.springboot.application.customer.exception.MyManufacturerInvalidCityException;
import it.engineering.springboot.application.customer.service.ManufacturerService;

@RestController
@RequestMapping("/api/manufacturer")
@Transactional
public class ManufacturerRestController {

	private final ManufacturerService manufacturerService;

	@Autowired
	public ManufacturerRestController(ManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}

	@GetMapping
	public @ResponseBody ResponseEntity<List<ManufacturerDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(manufacturerService.getAll());
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<ManufacturerDto> manufacturerDto = manufacturerService.findById(id);
		if (manufacturerDto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(manufacturerDto.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Manufacturer with id " + id + " does not exist!");
		}
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
		try {
			manufacturerService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted manufacturer with id: " + id);
		} catch (MyEntityNotExistException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PostMapping
	public @ResponseBody ResponseEntity<Object> save(@RequestBody ManufacturerDto manufacturerDto) {
		try {
			ManufacturerDto manufacturer = manufacturerService.save(manufacturerDto);
			return ResponseEntity.status(HttpStatus.OK).body(manufacturerDto);
		} catch (MyEntityExistException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Greska kod cuvanja manufacturera: " + manufacturerDto);
		}
	}

	@PutMapping
	public @ResponseBody ResponseEntity<ManufacturerDto> update(@RequestBody ManufacturerDto manufacturerDto) {
		try {
			Optional<ManufacturerDto> manufacturer = manufacturerService.update(manufacturerDto);
			return ResponseEntity.status(HttpStatus.OK).body(manufacturer.get());
		} catch (MyManufacturerInvalidCityException e) {
			e.getMessage();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(manufacturerDto);
		}
	}

}
