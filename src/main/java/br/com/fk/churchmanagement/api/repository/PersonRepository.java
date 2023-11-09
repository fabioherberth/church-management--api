package br.com.fk.churchmanagement.api.repository;

import br.com.fk.churchmanagement.api.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
