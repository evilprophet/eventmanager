package com.eventmanager.dao;

import com.eventmanager.model.Event;
import com.eventmanager.model.Reservation;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("reservationDao")
public class ReservationDaoImpl extends AbstractDao<Integer, Reservation> implements ReservationDao {

    public Reservation findById(int id) {
        return getByKey(id);
    }

    public Reservation findByUuid(String uuid) {
        return (Reservation) getEntityManager()
                .createQuery("SELECT r FROM Reservation r WHERE r.uuid LIKE :uuid ORDER BY r.id ASC")
                .setParameter("uuid", uuid)
                .getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> findAllReservations() {
        return (List<Reservation>) getEntityManager()
                .createQuery("SELECT r FROM Reservation r ORDER BY r.id ASC")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> findReservationsByEvent(Event event) {
        return (List<Reservation>) getEntityManager()
                .createQuery("SELECT r FROM Reservation r WHERE r.event LIKE :event ORDER BY r.id ASC")
                .setParameter("event", event)
                .getResultList();
    }

    public void save(Reservation reservation) {
        persist(reservation);
    }

    public void deleteById(int id) {
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
