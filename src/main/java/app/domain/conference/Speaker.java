package app.domain.conference;

import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * @author: Vince Bickers
 */
public class Speaker extends Entity {

    @Relationship(type="PRESENTS")
    private Set<Session> sessionsPresented;

    @Relationship(type="REGISTERED_FOR", direction= Relationship.OUTGOING)
    private Conference conference;

    public Set<Session> getSessionsPresented() {
        return sessionsPresented;
    }

    public void setSessionsPresented(Set<Session> sessionsPresented) {
        this.sessionsPresented = sessionsPresented;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
