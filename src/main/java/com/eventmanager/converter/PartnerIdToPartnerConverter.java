package com.eventmanager.converter;

import com.eventmanager.model.Partner;
import com.eventmanager.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PartnerIdToPartnerConverter implements Converter<Object, Partner> {

    @Autowired
    private PartnerService partnerService;

    public Partner convert(Object element) {
        Integer id = Integer.parseInt((String) element);

        return partnerService.findById(id);
    }

}