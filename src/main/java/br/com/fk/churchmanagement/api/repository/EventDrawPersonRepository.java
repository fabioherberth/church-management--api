package br.com.fk.apimultipleservices.repository;

import br.com.fk.apimultipleservices.entity.EventDrawPerson;
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
                      ORDER BY random()
                      LIMIT 1;
            """, nativeQuery = true)
    Long willDrawPerson(@Param("eventId") Long eventId);

}
