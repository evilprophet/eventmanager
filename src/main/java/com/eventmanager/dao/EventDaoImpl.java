package com.eventmanager.dao;

import com.eventmanager.model.Event;
import com.eventmanager.model.Partner;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("eventDao")
public class EventDaoImpl extends AbstractDao<Integer, Event> implements EventDao {

    public Event findById(int id) {
        Event event = getByKey(id);
        if (event != null) {
            initializeCollection(event.getReservtions());
        }

        return event;
    }

    @SuppressWarnings("unchecked")
    public List<Event> findAllEvents() {
        List<Event> events = getEntityManager()
                .createQuery("SELECT e FROM Event e ORDER BY e.name ASC")
                .getResultList();

        return events;
    }

    public List<Event> findEventsByPartner(Partner partner) {
        List<Event> events = getEntityManager()
                .createQuery("SELECT e FROM Event e WHERE e.partner_id LIKE :partner_id ORDER BY e.name ASC")
                .setParameter("partner_id", partner.getId())
                .getResultList();

        return events;
    }

    public void save(Event event) {
        persist(event);
    }

    public void deleteById(Integer id) {
        Event event = (Event) getEntityManager()
                .createQuery("SELECT e FROM Event e WHERE u.id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();
        delete(event);
    }

    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if (collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

}
