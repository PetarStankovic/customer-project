package it.engineering.springboot.application.customer.dto;

import java.time.LocalDate;

public class ManufacturerLicenseDto implements MyDto {

	private Long id;

	private LocalDate acceptedDate;

	private ManufacturerDto manufacturer;

	private LicenseDto license;

	public ManufacturerLicenseDto() {
		// TODO Auto-generated constructor stub
	}

	public ManufacturerLicenseDto(Long id, LocalDate acceptedDate, ManufacturerDto manufacturer, LicenseDto license) {
		super();
		this.id = id;
		this.acceptedDate = acceptedDate;
		this.manufacturer = manufacturer;
		this.license = license;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(LocalDate acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public ManufacturerDto getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerDto manufacturer) {
		this.manufacturer = manufacturer;
	}

	public LicenseDto getLicense() {
		return license;
	}

	public void setLicense(LicenseDto license) {
		this.license = license;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceptedDate == null) ? 0 : acceptedDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((license == null) ? 0 : license.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManufacturerLicenseDto other = (ManufacturerLicenseDto) obj;
		if (acceptedDate == null) {
			if (other.acceptedDate != null)
				return false;
		} else if (!acceptedDate.equals(other.acceptedDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (license == null) {
			if (other.license != null)
				return false;
		} else if (!license.equals(other.license))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ManufacturerLicenseDto [id=" + id + ", acceptedDate=" + acceptedDate + ", manufacturer=" + manufacturer
				+ ", license=" + license + "]";
	}

}
