package br.com.fk.churchmanagement.api.repository;

import br.com.fk.churchmanagement.api.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByNameIgnoreCase(String name);

    @Query(value = """
            SELECT *
              FROM person p
             WHERE p.id NOT IN(
                    SELECT edp.person_id
                      FROM event_day_person edp
                     WHERE DATE(edp.event_day) = DATE(NOW())
                     )
              ORDER BY p."name";""", nativeQuery = true)
    List<Person> getAllOrderByName();

}
