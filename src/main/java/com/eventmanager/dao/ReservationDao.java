package com.eventmanager.dao;

import com.eventmanager.model.Reservation;
import com.eventmanager.model.Event;

import java.util.List;

public interface ReservationDao {

    Reservation findById(int id);

    Reservation findByUuid(String uuid);

    void save(Reservation partner);

    void deleteById(int id);

    List<Reservation> findAllReservations();

    List<Reservation> findReservationsByEvent(Event event);

}

