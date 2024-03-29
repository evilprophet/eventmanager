package com.eventmanager.dao;

import com.eventmanager.model.Partner;

import java.util.List;

public interface PartnerDao {

    Partner findById(int id);

    void save(Partner partner);

    void deleteById(int id);

    List<Partner> findAllPartners();

}

