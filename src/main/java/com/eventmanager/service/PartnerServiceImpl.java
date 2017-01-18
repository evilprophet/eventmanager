package com.eventmanager.service;

import com.eventmanager.dao.PartnerDao;
import com.eventmanager.model.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("partnerService")
@Transactional
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerDao dao;

    public Partner findById(int id) {
        return dao.findById(id);
    }

    public void savePartner(Partner partner) {
        dao.save(partner);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updatePartner(Partner partner) {
        Partner entity = dao.findById(partner.getId());
        if (entity != null) {
            entity.setName(partner.getName());
            entity.setDescription(partner.getDescription());
            entity.setWebsite(partner.getWebsite());
            entity.setAddress(partner.getAddress());
            entity.setTelephone(partner.getTelephone());
            entity.setEmail(partner.getEmail());
        }
    }

    public void deletePartnerById(Integer id) {
        dao.deleteById(id);
    }

    public List<Partner> findAllPartners() {
        return dao.findAllPartners();
    }

}
