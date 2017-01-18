package com.eventmanager.service;

import com.eventmanager.model.Partner;

import java.util.List;

public interface PartnerService {

    Partner findById(int id);

    void savePartner(Partner partner);

    void updatePartner(Partner partner);

    void deletePartnerById(Integer id);

    List<Partner> findAllPartners();
}