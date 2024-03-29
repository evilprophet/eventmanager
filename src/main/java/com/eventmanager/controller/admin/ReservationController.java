package com.eventmanager.controller.admin;

import com.eventmanager.exception.ReservationException;
import com.eventmanager.model.Reservation;
import com.eventmanager.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller("AdminReservationController")
@RequestMapping("/admin/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String indexAction(ModelMap model) {
        List<Reservation> reservations = reservationService.findAllReservations();
        model.addAttribute("reservations", reservations);

        return "admin/reservation/index";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String showAction(@PathVariable Integer id, ModelMap model) {
        Reservation reservation = reservationService.findById(id);
        if (reservation == null) {
            return "redirect:/admin/reservations";
        }
        model.addAttribute("reservation", reservation);

        return "admin/reservation/show";
    }

    @RequestMapping(value = {"/{id}/delete"}, method = RequestMethod.GET)
    public String deleteAction(@PathVariable Integer id, final RedirectAttributes redirectAttributes, HttpServletRequest request) {
        try {
            reservationService.deleteReservationById(id);
        } catch (ReservationException e) {
            redirectAttributes.addFlashAttribute("css", "danger");
            redirectAttributes.addFlashAttribute("msg", e.getMessage());
        }

        return "redirect:" + request.getHeader("referer");
    }
}
