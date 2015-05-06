package app.domain.conference;

import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * @author: Vince Bickers
 */
public class Topic extends Entity {

    @Relationship(type="HAS_TOPIC", direction= Relationship.INCOMING)
    private Set<Talk> sessions;

    public Set<Talk> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Talk> sessions) {
        this.sessions = sessions;
    }
}
