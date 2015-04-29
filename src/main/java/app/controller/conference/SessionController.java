package app.controller.conference;

import app.controller.Controller;
import app.domain.conference.Session;
import app.service.Service;
import app.service.conference.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Vince Bickers
 */
@RestController
public class SessionController extends Controller<Session> {

    @Autowired
    private SessionService service;

    @Override
    public Service<Session> getService() {
        return service;
    }

    @RequestMapping(value="/sessions", method = RequestMethod.GET)
    public Iterable<Session> list() {
        return super.list();
    }

    @RequestMapping(value="/sessions", method = RequestMethod.POST, consumes = "application/json")
    public Session create (@RequestBody Session entity) {
        return super.create(entity);
    }

    @RequestMapping(value="/sessions/{id}", method = RequestMethod.GET)
    public Session find(@PathVariable Long id) {
        return super.find(id);
    }

    @RequestMapping(value="/sessions/filter/{name}", method = RequestMethod.GET)
    public Iterable<Session> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @RequestMapping(value="/sessions/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id) {
        super.delete(id);
    }

    @RequestMapping(value="/sessions/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public Session update (@PathVariable Long id, @RequestBody Session entity) {
        return super.update(id, entity);
    }

    @RequestMapping(value = "/sessions/similar/{id}", method=RequestMethod.GET)
    public Iterable<Session> findSimilar(@PathVariable Long id) {
        return service.findSimilar(id);
    }
}
