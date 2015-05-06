package app.repository.conference;

import app.domain.conference.Talk;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * @author: Vince Bickers
 */
public interface SessionRepository extends GraphRepository<Talk> {

    Iterable<Talk> findByName(String name);

    @Query("MATCH(s:Session)-[:HAS_TOPIC]->()<-[:HAS_TOPIC]-(s2:Session) WHERE id(s) = {0} RETURN distinct s2")
    Iterable<Talk> findSimilar(Long session);

}
