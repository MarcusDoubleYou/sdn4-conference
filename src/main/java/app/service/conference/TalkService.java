package app.service.conference;

import app.domain.conference.Talk;
import app.repository.conference.SessionRepository;
import app.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

/**
 * @author: Vince Bickers
 */
@Service
public class TalkService extends GenericService<Talk> {

    @Autowired
    private SessionRepository repository;

    @Override
    public GraphRepository<Talk> getRepository() {
        return repository;
    }

    public Iterable<Talk> findByName(String name) {
        return repository.findByName(name);
    }

    public Iterable<Talk> findSimilar(Long id) {
        return repository.findSimilar(id);
    }
}
