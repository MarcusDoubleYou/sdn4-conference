package app.service.conference;

import app.domain.conference.Timeslot;
import app.repository.conference.TimeslotRepository;
import app.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Service;

/**
 * @author: Vince Bickers
 */
@Service
    public class TimeslotService extends GenericService<Timeslot> {

    @Autowired
    private TimeslotRepository repository;

    @Override
    public GraphRepository<Timeslot> getRepository() {
        return repository;
    }
}
