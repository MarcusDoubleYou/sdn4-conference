package app.domain.conference;

import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * @author: Vince Bickers
 */
public class Track extends Entity {

    @Relationship(type="IN_TRACK", direction= Relationship.INCOMING)
    private Set<Talk> talks;

    @Relationship(type="HAS_TRACK", direction= Relationship.INCOMING)
    private Conference conference;

    public Set<Talk> getTalks() {
        return talks;
    }

    public void setTalks(Set<Talk> talks) {
        this.talks = talks;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
