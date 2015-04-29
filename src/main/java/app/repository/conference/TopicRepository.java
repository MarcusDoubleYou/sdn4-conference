package app.repository.conference;

import app.domain.conference.Topic;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.Map;

/**
 * @author: Vince Bickers
 */
public interface TopicRepository extends GraphRepository<Topic> {

    @Query("MATCH(t:Topic)<-[:HAS_TOPIC]-(s) return t, count(s) as hits ORDER BY hits DESC")
    Iterable<Map<String,Object>> getTopicsByPopularity();
}
