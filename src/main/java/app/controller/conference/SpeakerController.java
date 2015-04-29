package app.controller.conference;

import app.controller.Controller;
import app.domain.conference.Speaker;
import app.service.Service;
import app.service.conference.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Vince Bickers
 */
@RestController
public class SpeakerController extends Controller<Speaker> {

    @Autowired
    private SpeakerService service;

    @Override
    public Service<Speaker> getService() {
        return service;
    }

    @RequestMapping(value="/speakers", method = RequestMethod.GET)
    public Iterable<Speaker> list() {
        return super.list();
    }

    @RequestMapping(value="/speakers", method = RequestMethod.POST, consumes = "application/json")
    public Speaker create (@RequestBody Speaker entity) {
        return super.create(entity);
    }

    @RequestMapping(value="/speakers/{id}", method = RequestMethod.GET)
    public Speaker find(@PathVariable Long id) {
        return super.find(id);
    }

    @RequestMapping(value="/speakers/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id) {
        super.delete(id);
    }

    @RequestMapping(value="/speakers/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public Speaker update (@PathVariable Long id, @RequestBody Speaker entity) {
        return super.update(id, entity);
    }

}
