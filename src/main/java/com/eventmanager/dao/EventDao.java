package com.eventmanager.dao;

import com.eventmanager.model.Event;
import com.eventmanager.model.Partner;

import java.util.List;

public interface EventDao {

    Event findById(int id);

    void save(Event event);

    void deleteById(Integer id);

    List<Event> findAllEvents();

    List<Event> findEventsByPartner(Partner partner);

}

