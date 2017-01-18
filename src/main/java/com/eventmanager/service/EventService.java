package com.eventmanager.service;

import com.eventmanager.model.Event;
import com.eventmanager.model.Partner;

import java.util.List;

public interface EventService {

    Event findById(int id);

    void saveEvent(Event user);

    void updateEvent(Event user);

    void deleteEventById(Integer id);

    List<Event> findAllEvents();

    List<Event> findEventsByPartner(Partner partner);
}