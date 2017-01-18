package com.eventmanager.dao;

import com.eventmanager.model.Event;
import com.eventmanager.model.Reservation;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("reservationDao")
public class ReservationDaoImpl extends AbstractDao<Integer, Reservation> implements ReservationDao {

    public Reservation findById(int id) {
        Reservation reservation = getByKey(id);

        return reservation;
    }

    public Reservation findByUuid(String uuid) {
        Reservation reservation = (Reservation) getEntityManager()
                .createQuery("SELECT r FROM Reservation r WHERE r.uuid LIKE :uuid ORDER BY r.id ASC")
                .setParameter("uuid", uuid)
                .getSingleResult();

        return reservation;
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> findAllReservations() {
        List<Reservation> reservations = getEntityManager()
                .createQuery("SELECT r FROM Reservation r ORDER BY u.id ASC")
                .getResultList();

        return reservations;
    }

    public List<Reservation> findReservationsByEvent(Event event) {
        List<Reservation> reservations = getEntityManager()
                .createQuery("SELECT r FROM Reservation r WHERE r.event LIKE :event ORDER BY r.id ASC")
                .setParameter("event", event)
                .getResultList();

        return reservations;
    }

    public void save(Reservation reservation) {
        persist(reservation);
    }

    public void deleteById(Integer id) {
        Reservation reservation = (Reservation) getEntityManager()
                .createQuery("SELECT r FROM Reservation r WHERE r.id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();
        delete(reservation);
    }

    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if (collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

}
