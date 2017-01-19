package com.eventmanager.controller.admin;

import com.eventmanager.model.Event;
import com.eventmanager.model.Reservation;
import com.eventmanager.service.EventService;
import com.eventmanager.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("AdminEventController")
@RequestMapping("/admin/events")
@SessionAttributes("roles")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String indexAction(ModelMap model) {
        List<Event> events = eventService.findAllEvents();
        model.addAttribute("events", events);

        return "admin/event/index";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String showAction(@PathVariable Integer id, ModelMap model) {
        Event event = eventService.findById(id);
        if (event == null)
            return "redirect:/admin/events";

        List<Reservation> reservations = reservationService.findReservationsByEvent(event);
        model.addAttribute("event", event);
        model.addAttribute("reservations", reservations);

        return "admin/event/show";
    }

    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.GET)
    public String editAction(@PathVariable Integer id, ModelMap model) {
        Event event = eventService.findById(id);
        if (event == null)
            return "redirect:/admin/events";

        model.addAttribute("event", event);

        return "admin/event/show";
    }

    @RequestMapping(value = {"/{id}/delete"}, method = RequestMethod.GET)
    public String deleteAction(@PathVariable Integer id, HttpServletRequest request) {
        eventService.deleteEventById(id);

        return "redirect:" + request.getHeader("Referer");
    }
}
