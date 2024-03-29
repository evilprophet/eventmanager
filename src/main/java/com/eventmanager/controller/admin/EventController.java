package com.eventmanager.controller.admin;

import com.eventmanager.editor.PartnerEditor;
import com.eventmanager.model.Event;
import com.eventmanager.model.Partner;
import com.eventmanager.model.Reservation;
import com.eventmanager.service.EventService;
import com.eventmanager.service.PartnerService;
import com.eventmanager.service.ReservationService;
import com.eventmanager.validator.EventValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller("AdminEventController")
@RequestMapping("/admin/events")

public class EventController {

    private final EventService eventService;

    private final PartnerService partnerService;

    private final ReservationService reservationService;

    private final EventValidator eventValidator;

    @Autowired
    public EventController(ReservationService reservationService, PartnerService partnerService, EventService eventService, EventValidator eventValidator) {
        this.reservationService = reservationService;
        this.partnerService = partnerService;
        this.eventService = eventService;
        this.eventValidator = eventValidator;
    }

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String indexAction(ModelMap model) {
        List<Event> events = eventService.findAllEvents();
        model.addAttribute("events", events);

        return "admin/event/index";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newAction(ModelMap model, @RequestParam(value = "partner_id", defaultValue = "-1") Integer partnerId) {
        if (!model.containsAttribute("event")) {
            Event event = new Event();
            Partner partner = partnerService.findById(partnerId);
            if (partner != null) {
                event.setPartner(partner);
            }
            model.addAttribute("event", event);
        }
        List<Partner> partners = partnerService.findAllPartners();
        model.addAttribute("partners", partners);

        return "admin/event/new";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String createAction(@Valid Event event, BindingResult result, ModelMap model, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.event", result);
            redirectAttributes.addFlashAttribute("event", event);
            return "redirect:/admin/events/new";
        }
        eventService.saveEvent(event);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Event " + event.getName() + " registered successfully");

        return "redirect:/admin/events";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String showAction(@PathVariable Integer id, ModelMap model) {
        Event event = eventService.findById(id);
        if (event == null) {
            return "redirect:/admin/events";
        }
        List<Reservation> reservations = reservationService.findReservationsByEvent(event);
        model.addAttribute("event", event);
        model.addAttribute("reservations", reservations);

        return "admin/event/show";
    }

    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.GET)
    public String editAction(@PathVariable Integer id, ModelMap model) {
        if (!model.containsAttribute("event")) {
            Event event = eventService.findById(id);
            if (event == null) {
                return "redirect:/admin/events";
            }
            model.addAttribute("event", event);
        }
        List<Partner> partners = partnerService.findAllPartners();
        model.addAttribute("partners", partners);

        return "admin/event/edit";
    }

    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.POST)
    public String updateAction(@Valid Event event, BindingResult result, ModelMap model, final RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.event", result);
            redirectAttributes.addFlashAttribute("event", event);
            return "redirect:" + request.getHeader("referer");
        }
        eventService.updateEvent(event);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Event " + event.getName() + " updated successfully");

        return "redirect:/admin/events/" + event.getId();
    }

    @RequestMapping(value = {"/{id}/delete"}, method = RequestMethod.GET)
    public String deleteAction(@PathVariable Integer id, HttpServletRequest request) {
        eventService.deleteEventById(id);

        return "redirect:" + request.getHeader("referer");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Partner.class, new PartnerEditor(partnerService));
        binder.addValidators(eventValidator);
    }
}
