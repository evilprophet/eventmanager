package com.eventmanager.controller.client;

import com.eventmanager.editor.EventEditor;
import com.eventmanager.model.Event;
import com.eventmanager.model.Reservation;
import com.eventmanager.service.EventService;
import com.eventmanager.service.ReservationService;
import com.eventmanager.validator.ReservationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("ClientReservationController")
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    private final EventService eventService;

    private final ReservationValidator reservationValidator;

    @Autowired
    public ReservationController(ReservationService reservationService, EventService eventService, ReservationValidator reservationValidator) {
        this.reservationService = reservationService;
        this.eventService = eventService;
        this.reservationValidator = reservationValidator;
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newAction(ModelMap model, @RequestParam(value = "event_id", defaultValue = "-1") Integer eventId, HttpServletRequest request) {
        Event event = eventService.findById(eventId);
        List<Event> events = new ArrayList<>();
        Map<Integer, Double> eventPriceMap = new HashMap<>();
        if (event == null) {
            events = eventService.findAvailableEvents();
            for (Event item : events) {
                eventPriceMap.put(item.getId(), item.getPrice());
            }
        } else {
            if (event.isAvailable()) {
                events.add(event);
                eventPriceMap.put(event.getId(), event.getPrice());
            } else {
                return "redirect:/events";
            }
        }

        if (!model.containsAttribute("reservation")) {
            model.addAttribute("reservation", new Reservation());
        }
        String referrer = request.getHeader("referer");
        model.addAttribute("events", events);
        model.addAttribute("referrer", referrer);
        model.addAttribute("eventPriceMap", eventPriceMap);

        return "client/reservation/new";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String createAction(@Valid Reservation reservation, BindingResult result, final RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (result.hasErrors()) {
            String referrer = request.getHeader("referer");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.reservation", result);
            redirectAttributes.addFlashAttribute("reservation", reservation);
            return "redirect:" + referrer;
        }
        reservationService.saveReservation(reservation);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Registered successfully");
        redirectAttributes.addFlashAttribute("uuid", reservation.getUuid());
        redirectAttributes.addFlashAttribute("eventName", reservation.getEvent().getName());

        return "redirect:/";
    }

    @RequestMapping(value = {"/{uuid}"}, method = RequestMethod.GET)
    public String showAction(@PathVariable String uuid, ModelMap model) {
        Reservation reservation = reservationService.findByUuid(uuid);
        if (reservation == null) {
            return "redirect:/";
        }
        reservation.confirm();
        reservationService.updateReservation(reservation);
        model.addAttribute("reservation", reservation);

        return "client/reservation/show";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Event.class, new EventEditor(eventService));
        binder.addValidators(reservationValidator);
    }
}
