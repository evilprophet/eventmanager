package com.eventmanager.dao;

import com.eventmanager.model.Event;
import com.eventmanager.model.Partner;

import java.util.List;

public interface EventDao {

    Event findById(int id);

    void save(Event event);

    void deleteById(int id);

    List<Event> findAllEvents();

    List<Event> findAvailableEvents();

    List<Event> findEventsByPartner(Partner partner);

    List<Event> findAvailableEventsByPartner(Partner partner);

}

