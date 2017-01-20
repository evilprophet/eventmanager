package com.eventmanager.editor;

import com.eventmanager.model.Event;
import com.eventmanager.service.EventService;

import java.beans.PropertyEditorSupport;

public class EventEditor extends PropertyEditorSupport {

    private EventService eventService;

    public EventEditor(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void setAsText(String text) {
        Integer id = Integer.parseInt(text);
        Event event = eventService.findById(id);
        this.setValue(event);
    }

}
