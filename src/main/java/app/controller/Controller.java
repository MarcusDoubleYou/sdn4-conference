package app.controller;

import app.controller.exception.NotFoundException;
import app.domain.conference.Entity;
import app.service.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api")
public abstract class Controller<T> {

    public Iterable<T> list() {
        return getService().findAll();
    }

    public  T create (T entity) {
        return getService().createOrUpdate(entity);
    }

    public T find(Long id) {
        T entity = getService().find(id);
        if (entity != null) {
            return entity;
        }
        throw new NotFoundException();
    }

    public void delete (Long id) {
        if (getService().find(id) != null) {
            getService().delete(id);
        } else {
            throw new NotFoundException();
        }
    }

    public  T update (Long id, T entity) {
        if (getService().find(id) != null) {
            ((Entity)entity).setId(id);
            return getService().createOrUpdate(entity);
        }
        throw new NotFoundException();
    }

    public abstract Service<T> getService();
}
