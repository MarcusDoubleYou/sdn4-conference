package app.repository.conference;

import app.domain.conference.Track;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author: Vince Bickers
 */
public interface TrackRepository extends GraphRepository<Track> {

}
