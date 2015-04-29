package app.repository.conference;

import app.domain.conference.Conference;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author: Vince Bickers
 */
public interface ConferenceRepository extends GraphRepository<Conference> {

}
