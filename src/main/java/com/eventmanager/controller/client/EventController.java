package com.eventmanager.controller.client;

import com.eventmanager.model.Event;
import com.eventmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller("ClientEventController")
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String indexAction(ModelMap model) {
        List<Event> events = eventService.findAvailableEvents();
        model.addAttribute("events", events);

        return "client/event/index";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String showAction(@PathVariable Integer id, ModelMap model) {
        Event event = eventService.findById(id);
        if (event == null || !event.isAvailable()) {
            return "redirect:/events";
        }
        model.addAttribute("event", event);

        return "client/event/show";
    }
}
