package com.eventmanager.editor;

import com.eventmanager.model.Partner;
import com.eventmanager.service.PartnerService;

import java.beans.PropertyEditorSupport;

public class PartnerEditor extends PropertyEditorSupport {

    private PartnerService partnerService;

    public PartnerEditor(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @Override
    public void setAsText(String text) {
        Integer id = Integer.parseInt(text);
        Partner p = partnerService.findById(id);
        this.setValue(p);
    }

}
