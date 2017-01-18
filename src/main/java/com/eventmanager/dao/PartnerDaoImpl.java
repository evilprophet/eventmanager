package com.eventmanager.dao;

import com.eventmanager.model.Partner;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("partnerDao")
public class PartnerDaoImpl extends AbstractDao<Integer, Partner> implements PartnerDao {

    public Partner findById(int id) {
        Partner partner = getByKey(id);
        if (partner != null) {
            initializeCollection(partner.getEvents());
        }

        return partner;
    }

    @SuppressWarnings("unchecked")
    public List<Partner> findAllPartners() {
        List<Partner> partners = getEntityManager()
                .createQuery("SELECT p FROM Partner p ORDER BY p.name ASC")
                .getResultList();

        return partners;
    }

    public void save(Partner partner) {
        persist(partner);
    }

    public void deleteById(Integer id) {
        Partner partner = (Partner) getEntityManager()
                .createQuery("SELECT p FROM Partner p WHERE p.id LIKE :id")
                .setParameter("id", id)
                .getSingleResult();
        delete(partner);
    }

    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if (collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

}
