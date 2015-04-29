package app.controller.conference;

import app.controller.Controller;
import app.domain.conference.Track;
import app.service.Service;
import app.service.conference.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Vince Bickers
 */
@RestController
public class TrackController extends Controller<Track> {

    @Autowired
    private TrackService service;

    @Override
    public Service<Track> getService() {
        return service;
    }

    @RequestMapping(value="/tracks", method = RequestMethod.GET)
    public Iterable<Track> list() {
        return super.list();
    }

    @RequestMapping(value="/tracks", method = RequestMethod.POST, consumes = "application/json")
    public Track create (@RequestBody Track entity) {
        return super.create(entity);
    }

    @RequestMapping(value="/tracks/{id}", method = RequestMethod.GET)
    public Track find(@PathVariable Long id) {
        return super.find(id);
    }

    @RequestMapping(value="/tracks/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id) {
        super.delete(id);
    }

    @RequestMapping(value="/tracks/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public Track update (@PathVariable Long id, @RequestBody Track entity) {
        return super.update(id, entity);
    }

}
