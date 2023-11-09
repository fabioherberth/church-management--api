package br.com.fk.churchmanagement.api.repository;


import br.com.fk.churchmanagement.api.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
