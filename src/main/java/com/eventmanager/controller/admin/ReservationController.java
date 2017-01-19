package com.eventmanager.controller.admin;

import com.eventmanager.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller("AdminReservationController")
@RequestMapping("/admin/reservations")
@SessionAttributes("roles")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


}
