package com.eventmanager.controller.admin;

import com.eventmanager.model.Event;
import com.eventmanager.model.Partner;
import com.eventmanager.service.EventService;
import com.eventmanager.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller("AdminPartnerController")
@RequestMapping("/admin/partners")
public class PartnerController {

    private final PartnerService partnerService;

    private final EventService eventService;

    @Autowired
    public PartnerController(PartnerService partnerService, EventService eventService) {
        this.partnerService = partnerService;
        this.eventService = eventService;
    }

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String indexAction(ModelMap model) {
        List<Partner> partners = partnerService.findAllPartners();
        model.addAttribute("partners", partners);

        return "admin/partner/index";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newAction(ModelMap model) {
        Partner partner = new Partner();
        model.addAttribute("partner", partner);

        return "admin/partner/new";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String createAction(@Valid Partner partner, BindingResult result, ModelMap model, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/partner/new";
        }
        partnerService.savePartner(partner);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Partner " + partner.getName() + " registered successfully");

        return "redirect:/admin/partners";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String showAction(@PathVariable Integer id, ModelMap model) {
        Partner partner = partnerService.findById(id);
        if (partner == null) {
            return "redirect:/admin/partners";
        }
        List<Event> events = eventService.findEventsByPartner(partner);
        model.addAttribute("partner", partner);
        model.addAttribute("events", events);

        return "admin/partner/show";
    }

    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.GET)
    public String editAction(@PathVariable Integer id, ModelMap model) {
        Partner partner = partnerService.findById(id);
        if (partner == null) {
            return "redirect:/admin/partners";
        }
        model.addAttribute("partner", partner);

        return "admin/partner/edit";
    }

    @RequestMapping(value = {"/{id}/edit"}, method = RequestMethod.POST)
    public String updateAction(@Valid Partner partner, BindingResult result, ModelMap model,
                               @PathVariable Integer id, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/partner/edit";
        }
        partnerService.updatePartner(partner);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Partner " + partner.getName() + " updated successfully");

        return "redirect:/admin/partners/" + partner.getId();
    }

    @RequestMapping(value = {"/{id}/delete"}, method = RequestMethod.GET)
    public String deleteAction(@PathVariable Integer id, HttpServletRequest request) {
        partnerService.deletePartnerById(id);

        return "redirect:" + request.getHeader("Referer");
    }
}
