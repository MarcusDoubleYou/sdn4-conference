package app.repository.conference;

import app.domain.conference.Speaker;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author: Vince Bickers
 */
public interface SpeakerRepository extends GraphRepository<Speaker> {

}
