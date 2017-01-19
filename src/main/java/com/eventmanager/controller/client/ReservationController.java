package com.eventmanager.controller.client;

import com.eventmanager.model.Event;
import com.eventmanager.model.Reservation;
import com.eventmanager.service.EventService;
import com.eventmanager.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller("ClientReservationController")
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    private final EventService eventService;

    @Autowired
    public ReservationController(ReservationService reservationService, EventService eventService) {
        this.reservationService = reservationService;
        this.eventService = eventService;
    }

    @RequestMapping(value = {"/new"}, params = {"event_id"}, method = RequestMethod.GET)
    public String newAction(ModelMap model, @RequestParam(value = "event_id") Integer eventId, HttpServletRequest request) {
        Reservation reservation = new Reservation();
        Event event = eventService.findById(eventId);
        if (event == null || !event.isAvailable()) {
            return "redirect:/events";
        }
        String referrer = request.getHeader("referer");
        model.addAttribute("reservation", reservation);
        model.addAttribute("event", event);
        model.addAttribute("referrer", referrer);

        return "client/reservation/new";
    }

    @RequestMapping(value = {"/new"}, params = {"event_id"}, method = RequestMethod.POST)
    public String createAction(@Valid Reservation reservation, BindingResult result, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "client/reservation/new";
        }
        reservationService.saveReservation(reservation);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Registered successfully");

        return "redirect:/";
    }

    @InitBinder
    public void initDataBinder(WebDataBinder binder) {
        //binder.registerCustomEditor(Reservation.class, new ReservationEditor(reservationService));
    }
}
