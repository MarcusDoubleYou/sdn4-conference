package app.controller.conference;

import app.controller.Controller;
import app.domain.conference.Timeslot;
import app.service.Service;
import app.service.conference.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Vince Bickers
 */
@RestController
public class TimeslotController extends Controller<Timeslot> {

    @Autowired
    private TimeslotService service;

    @Override
    public Service<Timeslot> getService() {
        return service;
    }

    @RequestMapping(value="/timeslots", method = RequestMethod.GET)
    public Iterable<Timeslot> list() {
        return super.list();
    }

    @RequestMapping(value="/timeslots", method = RequestMethod.POST, consumes = "application/json")
    public Timeslot create (@RequestBody Timeslot entity) {
        return super.create(entity);
    }

    @RequestMapping(value="/timeslots/{id}", method = RequestMethod.GET)
    public Timeslot find(@PathVariable Long id) {
        return super.find(id);
    }

    @RequestMapping(value="/timeslots/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id) {
        super.delete(id);
    }

    @RequestMapping(value="/timeslots/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public Timeslot update (@PathVariable Long id, @RequestBody Timeslot entity) {
        return super.update(id, entity);
    }

}
