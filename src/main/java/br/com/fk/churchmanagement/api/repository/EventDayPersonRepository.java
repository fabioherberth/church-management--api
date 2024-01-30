package br.com.fk.churchmanagement.api.repository;

import br.com.fk.churchmanagement.api.entity.EventDayPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventDayPersonRepository extends JpaRepository<EventDayPerson, Long> {

    @Query(value = """
            SELECT edp.person_id
              FROM event_day_person edp
             WHERE edp.person_id IN(:peopleIds)
               AND DATE(edp.event_day) = DATE(now());
            """, nativeQuery = true)
    List<Long> checkAttendanceOnTheDay(@Param("peopleIds") List<Long> peopleIds);

    @Query(value = """
            SELECT p."name" AS name
              FROM event_day_person edp
             INNER JOIN person p on edp.person_id = p.id
             WHERE DATE(edp.event_day) = TO_DATE('2024-01-29','YYYY-MM-DD') -- DATE(NOW())
             ORDER BY p.name;
            """, nativeQuery = true)
    List<String> findTheListOfPeoplePresentByToday();

}
