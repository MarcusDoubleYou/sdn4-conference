package app.domain.conference;

import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * @author: Vince Bickers
 */
public class Session extends Entity {

    private Timeslot timeslot;

    @Relationship(type="IN_TRACK", direction= Relationship.OUTGOING)
    private Track track;

    @Relationship(type="PRESENTS", direction= Relationship.INCOMING)
    private Set<Speaker> presenters;

    @Relationship(type="HAS_TOPIC", direction= Relationship.OUTGOING)
    private Set<Topic> topics;

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Set<Speaker> getPresenters() {
        return presenters;
    }

    public void setPresenters(Set<Speaker> presenters) {
        this.presenters = presenters;
    }

    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }
}
