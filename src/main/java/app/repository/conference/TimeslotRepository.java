package app.repository.conference;

import app.domain.conference.Timeslot;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author: Vince Bickers
 */
public interface TimeslotRepository extends GraphRepository<Timeslot> {

}
