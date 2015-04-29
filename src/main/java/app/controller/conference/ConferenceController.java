package app.controller.conference;

import app.controller.Controller;
import app.domain.conference.Conference;
import app.service.ImportService;
import app.service.Service;
import app.service.conference.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Vince Bickers
 */
@RestController
public class ConferenceController extends Controller<Conference> {

    @Autowired
    private ConferenceService service;


    @Autowired
    ImportService importService;

    @RequestMapping("/conferences/import")
    public Iterable<Conference> reload() {
        importService.reload("conference.cql");
        return list();
    }

    @Override
    public Service<Conference> getService() {
        return service;
    }

    @RequestMapping(value="/conferences", method = RequestMethod.GET)
    public Iterable<Conference> list() {
        return super.list();
    }

    @RequestMapping(value="/conferences", method = RequestMethod.POST, consumes = "application/json")
    public Conference create (@RequestBody Conference entity) {
        return super.create(entity);
    }

    @RequestMapping(value="/conferences/{id}", method = RequestMethod.GET)
    public Conference find(@PathVariable Long id) {
        return super.find(id);
    }

    @RequestMapping(value="/conferences/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id) {
        super.delete(id);
    }

    @RequestMapping(value="/conferences/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public Conference update (@PathVariable Long id, @RequestBody Conference entity) {
        return super.update(id, entity);
    }
    
}
