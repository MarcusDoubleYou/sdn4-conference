package app.domain.conference;

import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * @author: Vince Bickers
 */
public class Speaker extends Entity {

    @Relationship(type="PRESENTS")
    private Set<Talk> talksPresented;

    @Relationship(type="REGISTERED_FOR", direction= Relationship.OUTGOING)
    private Conference conference;

    public Set<Talk> getTalksPresented() {
        return talksPresented;
    }

    public void setTalksPresented(Set<Talk> talksPresented) {
        this.talksPresented = talksPresented;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
