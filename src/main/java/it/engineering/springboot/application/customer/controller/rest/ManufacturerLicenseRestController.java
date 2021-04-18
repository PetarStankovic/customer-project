package it.engineering.springboot.application.customer.controller.rest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/manufacturer-license")
@Transactional
public class ManufacturerLicenseRestController {

}
