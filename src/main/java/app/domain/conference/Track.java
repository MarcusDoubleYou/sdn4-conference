package app.domain.conference;

import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * @author: Vince Bickers
 */
public class Track extends Entity {

    @Relationship(type="IN_TRACK", direction= Relationship.INCOMING)
    private Set<Session> sessions;

    @Relationship(type="HAS_TRACK", direction= Relationship.INCOMING)
    private Conference conference;

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
