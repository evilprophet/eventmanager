package com.eventmanager.service;

import com.eventmanager.exception.ReservationException;
import com.eventmanager.model.Event;
import com.eventmanager.model.Reservation;

import java.util.List;

public interface ReservationService {

    void saveReservation(Reservation reservation);

    void updateReservation(Reservation reservation);

    void deleteReservationById(int id) throws ReservationException;

    Reservation findById(int id);

    Reservation findByUuid(String uuid);

    List<Reservation> findAllReservations();

    List<Reservation> findReservationsByEvent(Event event);
}