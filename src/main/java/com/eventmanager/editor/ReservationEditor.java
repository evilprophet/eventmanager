package com.eventmanager.editor;

import com.eventmanager.service.ReservationService;

import java.beans.PropertyEditorSupport;

public class ReservationEditor extends PropertyEditorSupport {

    private ReservationService reservationService;

    public ReservationEditor(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public void setAsText(String text) {

        this.setValue(text);
    }

}
