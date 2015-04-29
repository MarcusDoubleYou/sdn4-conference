package app.service.conference;

import app.domain.conference.Speaker;
import app.repository.conference.SpeakerRepository;
import app.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

/**
 * @author: Vince Bickers
 */
@Service
public class SpeakerService extends GenericService<Speaker> {

    @Autowired
    private SpeakerRepository repository;

    @Override
    public GraphRepository<Speaker> getRepository() {
        return repository;
    }
}
