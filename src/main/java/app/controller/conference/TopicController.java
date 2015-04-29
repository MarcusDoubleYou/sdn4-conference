package app.controller.conference;

import app.controller.Controller;
import app.domain.conference.Topic;
import app.service.Service;
import app.service.conference.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author: Vince Bickers
 */
@RestController
public class TopicController extends Controller<Topic> {

    @Autowired
    private TopicService service;

    @Override
    public Service<Topic> getService() {
        return service;
    }

    @RequestMapping(value="/topics", method = RequestMethod.GET)
    public Iterable<Topic> list() {
        return super.list();
    }

    @RequestMapping(value="/topics", method = RequestMethod.POST, consumes = "application/json")
    public Topic create (@RequestBody Topic entity) {
        return super.create(entity);
    }

    @RequestMapping(value="/topics/{id}", method = RequestMethod.GET)
    public Topic find(@PathVariable Long id) {
        return super.find(id);
    }

    @RequestMapping(value="/topics/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id) {
        super.delete(id);
    }

    @RequestMapping(value="/topics/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public Topic update (@PathVariable Long id, @RequestBody Topic entity) {
        return super.update(id, entity);
    }

    @RequestMapping("/topics/popular")
    public Iterable<Map<String,Object>> popularTopics() {
        return service.getTopicsByPopularity();
    }

}
