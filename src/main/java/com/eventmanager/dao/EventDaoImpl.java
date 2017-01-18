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
            initializeCollection(event.getReservations());
        }

        return event;
    }

    @SuppressWarnings("unchecked")
    public List<Event> findAllEvents() {
        return (List<Event>) getEntityManager()
                .createQuery("SELECT e FROM Event e ORDER BY e.name ASC")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Event> findAvailableEvents() {
        return (List<Event>) getEntityManager()
                .createQuery("SELECT e FROM Event e " +
                        "WHERE e.freeAmount > 0 AND e.publishedAt < NOW() AND e.closedAt > NOW() " +
                        "ORDER BY e.name ASC")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Event> findEventsByPartner(Partner partner) {
        return (List<Event>) getEntityManager()
                .createQuery("SELECT e FROM Event e WHERE e.partner LIKE :partner ORDER BY e.name ASC")
                .setParameter("partner", partner)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Event> findAvailableEventsByPartner(Partner partner) {
        return (List<Event>) getEntityManager()
                .createQuery("SELECT e FROM Event e " +
                        "WHERE e.partner LIKE :partner AND e.freeAmount > 0 AND e.publishedAt < NOW() AND e.closedAt > NOW() " +
                        "ORDER BY e.name ASC")
                .setParameter("partner", partner)
                .getResultList();
    }

    public void save(Event event) {
        persist(event);
    }

    public void deleteById(int id) {
        Event event = (Event) getEntityManager()
                .createQuery("SELECT e FROM Event e WHERE e.id LIKE :id")
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
