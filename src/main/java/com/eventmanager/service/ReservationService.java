package com.eventmanager.service;

import com.eventmanager.model.Event;
import com.eventmanager.model.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation findById(int id);

    Reservation findByUuid(String uuid);

    void saveReservation(Reservation reservation);

    void updateReservation(Reservation reservation);

    void deleteReservationById(Integer id);

    List<Reservation> findAllReservations();

    List<Reservation> findReservationsByEvent(Event event);
}