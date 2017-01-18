package com.eventmanager.controller.client;

import com.eventmanager.model.Event;
import com.eventmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/reservations")
@SessionAttributes("roles")
public class ReservationController {

    @Autowired
    private
    EventService eventService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/new"}, params = {"event_id"}, method = RequestMethod.GET)
    public String newAction(ModelMap model, @RequestParam(value = "event_id") Integer event_id, HttpServletRequest request) {
        Event event = eventService.findById(event_id);
        if (event == null || !event.isAvailable())
            return "redirect:/events";

        String referrer = request.getHeader("referer");
        model.addAttribute("event", event);
        model.addAttribute("referrer", referrer);

        return "client/reservation/new";
    }
}
