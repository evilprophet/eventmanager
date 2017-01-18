package com.eventmanager.service;

import com.eventmanager.dao.EventDao;
import com.eventmanager.model.Event;
import com.eventmanager.model.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("eventService")
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao dao;

    public Event findById(int id) {
        return dao.findById(id);
    }

    public List<Event> findEventsByPartner(Partner partner) {
        List<Event> events = dao.findEventsByPartner(partner);

        return events;
    }

    public void saveEvent(Event event) {
        dao.save(event);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateEvent(Event event) {
        Event entity = dao.findById(event.getId());
        if (entity != null) {
            entity.setPartner(event.getPartner());
            entity.setName(event.getName());
            entity.setDescription(event.getDescription());
            entity.setAmount(event.getAmount());
            entity.setFreeAmount(event.getFreeAmount());
            entity.setEventDate(event.getEventDate());
        }
    }

    public void deleteEventById(Integer id) {
        dao.deleteById(id);
    }

    public List<Event> findAllEvents() {
        return dao.findAllEvents();
    }

}
