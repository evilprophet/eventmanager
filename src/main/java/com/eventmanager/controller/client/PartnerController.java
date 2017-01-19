package com.eventmanager.controller.client;

import com.eventmanager.model.Event;
import com.eventmanager.model.Partner;
import com.eventmanager.service.EventService;
import com.eventmanager.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller("ClientPartnerController")
@RequestMapping("/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private EventService eventService;

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String indexAction(ModelMap model) {
        List<Partner> partners = partnerService.findAllPartners();
        model.addAttribute("partners", partners);

        return "client/partner/index";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String showAction(@PathVariable Integer id, ModelMap model) {
        Partner partner = partnerService.findById(id);
        if (partner == null) {
            return "redirect:/partners";
        }
        List<Event> events = eventService.findAvailableEventsByPartner(partner);
        model.addAttribute("partner", partner);
        model.addAttribute("events", events);

        return "client/partner/show";
    }
}
