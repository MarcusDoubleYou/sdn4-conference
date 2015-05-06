package app.controller.conference;

import app.controller.Controller;
import app.domain.conference.Talk;
import app.service.Service;
import app.service.conference.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Vince Bickers
 */
@RestController
public class TalkController extends Controller<Talk> {

    @Autowired
    private TalkService service;

    @Override
    public Service<Talk> getService() {
        return service;
    }

    @RequestMapping(value="/talks", method = RequestMethod.GET)
    public Iterable<Talk> list() {
        return super.list();
    }

    @RequestMapping(value="/talks", method = RequestMethod.POST, consumes = "application/json")
    public Talk create (@RequestBody Talk entity) {
        return super.create(entity);
    }

    @RequestMapping(value="/talks/{id}", method = RequestMethod.GET)
    public Talk find(@PathVariable Long id) {
        return super.find(id);
    }

    @RequestMapping(value="/talks/filter/{name}", method = RequestMethod.GET)
    public Iterable<Talk> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @RequestMapping(value="/talks/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id) {
        super.delete(id);
    }

    @RequestMapping(value="/talks/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public Talk update (@PathVariable Long id, @RequestBody Talk entity) {
        return super.update(id, entity);
    }

    @RequestMapping(value = "/talks/similar/{id}", method=RequestMethod.GET)
    public Iterable<Talk> findSimilar(@PathVariable Long id) {
        return service.findSimilar(id);
    }
}
