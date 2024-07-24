package br.com.fk.churchmanagement.api.repository;

import br.com.fk.churchmanagement.api.entity.EventDrawPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EventDrawPersonRepository extends JpaRepository<EventDrawPerson, Long> {

    @Query(value = """
                    SELECT edp.id
                      FROM event_day_person edp
                      JOIN person p on p.id = edp.person_id
                      LEFT JOIN event_draw_person dp ON edp.id = dp.event_day_person_id AND p.id = dp.person_id
                     WHERE dp.id IS NULL
                       AND edp.event_id= :eventId
                       AND DATE(edp.event_day) = DATE(NOW())
                     ORDER BY RAND()
                     LIMIT 1;
            """, nativeQuery = true)
    Long willDrawPerson(@Param("eventId") Long eventId);

    @Query(value = """
                    SELECT p.id
                      FROM person p
                     INNER JOIN(
                            SELECT COUNT(edp.person_id) as frequencia, edp.person_id
                              FROM event_day_person edp
                             WHERE edp.event_id= :eventId
                             GROUP BY edp.person_id
                            HAVING COUNT(edp.person_id) > 5
                             ORDER BY frequencia desc) as tmp on tmp.person_id = p.id
                     ORDER BY random()
                     LIMIT 1;
            """, nativeQuery = true)
    Long willDrawPeoplePresent(@Param("eventId") Long eventId);

}
