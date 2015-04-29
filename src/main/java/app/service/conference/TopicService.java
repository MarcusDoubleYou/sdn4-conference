package app.service.conference;

import app.domain.conference.Topic;
import app.repository.conference.TopicRepository;
import app.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: Vince Bickers
 */
@Service
public class TopicService extends GenericService<Topic> {

    @Autowired
    private TopicRepository repository;

    @Override
    public GraphRepository<Topic> getRepository() {
        return repository;
    }

    public Iterable<Map<String, Object>> getTopicsByPopularity() {
        return repository.getTopicsByPopularity();
    }
}
