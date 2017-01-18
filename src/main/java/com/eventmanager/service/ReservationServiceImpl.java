package com.eventmanager.service;

import com.eventmanager.dao.ReservationDao;
import com.eventmanager.model.Event;
import com.eventmanager.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("reservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao dao;

    public void saveReservation(Reservation reservation) {
        dao.save(reservation);
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
            entity.setConfirmed(reservation.getConfirmed());
        }
    }

    public void deleteReservationById(int id) {
        dao.deleteById(id);
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
