package app.service.conference;

import app.domain.conference.Track;
import app.repository.conference.TrackRepository;
import app.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

/**
 * @author: Vince Bickers
 */
@Service
public class TrackService extends GenericService<Track> {

    @Autowired
    private TrackRepository repository;

    @Override
    public GraphRepository<Track> getRepository() {
        return repository;
    }
}
