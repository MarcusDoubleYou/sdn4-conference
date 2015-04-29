package app.service.conference;

import app.domain.conference.Session;
import app.repository.conference.SessionRepository;
import app.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

/**
 * @author: Vince Bickers
 */
@Service
public class SessionService extends GenericService<Session> {

    @Autowired
    private SessionRepository repository;

    @Override
    public GraphRepository<Session> getRepository() {
        return repository;
    }

    public Iterable<Session> findByName(String name) {
        return repository.findByName(name);
    }

    public Iterable<Session> findSimilar(Long id) {
        return repository.findSimilar(id);
    }
}
