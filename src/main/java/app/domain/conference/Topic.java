package app.domain.conference;

import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * @author: Vince Bickers
 */
public class Topic extends Entity {

    @Relationship(type="HAS_TOPIC", direction= Relationship.INCOMING)
    private Set<Session> sessions;

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }
}
