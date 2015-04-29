package app.domain.conference;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * @author: Vince Bickers
 */
@NodeEntity(label="Conference")
public class Conference extends Entity {

    @Relationship(type="HAS_TRACK", direction= Relationship.OUTGOING)
    private Set<Track> tracks;

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }
}
