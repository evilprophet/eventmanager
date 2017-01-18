package com.eventmanager.controller.client;

import com.eventmanager.model.Event;
import com.eventmanager.model.Partner;
import com.eventmanager.model.User;
import com.eventmanager.service.EventService;
import com.eventmanager.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/partners")
@SessionAttributes("roles")
public class PartnerController {

    @Autowired
    private
    PartnerService partnerService;

    @Autowired
    private
    EventService eventService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(ModelMap model) {

        List<Partner> partners = partnerService.findAllPartners();
        model.addAttribute("partners", partners);

        return "client/partner/index";
    }

    /**
     * This method will provide the medium to update an existing user.
     */
    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String show(@PathVariable Integer id, ModelMap model) {
        Partner partner = partnerService.findById(id);
        List<Event> events = eventService.findEventsByPartner(partner);
        model.addAttribute("partner", partner);
        model.addAttribute("events", events);

        return "client/partner/show";
    }
}
