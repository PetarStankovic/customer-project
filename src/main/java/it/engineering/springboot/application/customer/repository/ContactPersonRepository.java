package it.engineering.springboot.application.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.engineering.springboot.application.customer.entity.ContactPersonEntity;

@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPersonEntity, Long> {

}
