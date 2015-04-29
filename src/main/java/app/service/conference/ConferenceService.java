package app.service.conference;

import app.domain.conference.Conference;
import app.repository.conference.ConferenceRepository;
import app.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

/**
 * @author: Vince Bickers
 */
@Service
public class ConferenceService extends GenericService<Conference> {

    @Autowired
    private ConferenceRepository repository;

    @Override
    public GraphRepository<Conference> getRepository() {
        return repository;
    }
}
