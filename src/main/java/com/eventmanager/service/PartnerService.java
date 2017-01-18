package com.eventmanager.service;

import com.eventmanager.model.Partner;

import java.util.List;

public interface PartnerService {

    void savePartner(Partner partner);

    void updatePartner(Partner partner);

    void deletePartnerById(int id);

    Partner findById(int id);

    List<Partner> findAllPartners();
}