package com.eventmanager.controller.admin;

import com.eventmanager.editor.PartnerEditor;
import com.eventmanager.model.Event;
import com.eventmanager.model.Partner;
import com.eventmanager.model.Reservation;
import com.eventmanager.service.EventService;
import com.eventmanager.service.PartnerService;
import com.eventmanager.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller("AdminEventController")
@RequestMapping("/admin/events")

public class EventController {

    private Event event;

    @Autowired
    private EventService eventService;

    @Autowired
    private PartnerService partnerService;

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

        List<Partner> partners = partnerService.findAllPartners();
        model.addAttribute("event", event);
        model.addAttribute("partners", partners);

        return "admin/event/edit";
    }

    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.POST)
    public String updateAction(@ModelAttribute("event") Event event, BindingResult result, ModelMap model, @PathVariable Integer id) {
        if (result.hasErrors())
            return "admin/event/edit";

        eventService.updateEvent(event);

        model.addAttribute("success", "Event " + event.getName() + " updated successfully");
        return "redirect:/admin/events/" + event.getId();
    }

    @RequestMapping(value = {"/{id}/delete"}, method = RequestMethod.GET)
    public String deleteAction(@PathVariable Integer id, HttpServletRequest request) {
        eventService.deleteEventById(id);

        return "redirect:" + request.getHeader("Referer");
    }

    @InitBinder
    public void initDataBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Partner.class, new PartnerEditor(partnerService));
    }
}
