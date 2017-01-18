package com.eventmanager.service;

import com.eventmanager.model.Event;
import com.eventmanager.model.Partner;

import java.util.List;

public interface EventService {

    void saveEvent(Event user);

    void updateEvent(Event user);

    void deleteEventById(int id);

    Event findById(int id);

    List<Event> findAllEvents();

    List<Event> findAvailableEvents();

    List<Event> findEventsByPartner(Partner partner);

    List<Event> findAvailableEventsByPartner(Partner partner);
}