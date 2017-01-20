package com.eventmanager.service;

import com.eventmanager.dao.ReservationDao;
import com.eventmanager.exception.ReservationException;
import com.eventmanager.model.Event;
import com.eventmanager.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Service("reservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao dao;

    private final EventService eventService;

    @Autowired
    public ReservationServiceImpl(ReservationDao dao, EventService eventService) {
        this.dao = dao;
        this.eventService = eventService;
    }

    public void saveReservation(Reservation reservation) {
        Event event = reservation.getEvent();
        event.setFreeAmount(event.getFreeAmount() - reservation.getAmount());
        String uuidBase = reservation.getEmail() + "|" + reservation.getTelephone() + "|" + event.getId() + new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").toString();
        reservation.setUuid(UUID.nameUUIDFromBytes(uuidBase.getBytes()).toString());
        reservation.setFinalPrice(reservation.getAmount() * reservation.getEvent().getPrice());
        dao.save(reservation);
        eventService.updateEvent(event);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateReservation(Reservation reservation) {
        Reservation entity = dao.findById(reservation.getId());
        if (entity != null) {
            entity.setEvent(reservation.getEvent());
            entity.setUuid(reservation.getUuid());
            entity.setReservationKey(reservation.getReservationKey());
            entity.setFirstName(reservation.getFirstName());
            entity.setLastName(reservation.getLastName());
            entity.setEmail(reservation.getEmail());
            entity.setTelephone(reservation.getTelephone());
            entity.setAmount(reservation.getAmount());
            entity.setFinalPrice(reservation.getFinalPrice());
            entity.setConfirmed(reservation.isConfirmed());
        }
    }

    public void deleteReservationById(int id) throws ReservationException {
        Reservation reservation = findById(id);
        if (!reservation.isConfirmed()) {
            Event event = reservation.getEvent();
            event.setFreeAmount(event.getFreeAmount() + reservation.getAmount());
            dao.deleteById(id);
            eventService.updateEvent(event);
        } else {
            throw new ReservationException("Confirmed reservation can't be deleted");
        }

    }

    public Reservation findById(int id) {
        return dao.findById(id);
    }

    public Reservation findByUuid(String uuid) {
        return dao.findByUuid(uuid);
    }

    public List<Reservation> findAllReservations() {
        return dao.findAllReservations();
    }

    public List<Reservation> findReservationsByEvent(Event event) {
        return dao.findReservationsByEvent(event);
    }

}
