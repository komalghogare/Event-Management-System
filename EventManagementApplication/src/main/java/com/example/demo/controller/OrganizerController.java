package com.example.demo.controller;

package com.example.eventmanagement.controllers;

import com.example.eventmanagement.entities.Organizer;
import com.example.eventmanagement.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/organizers")
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    @GetMapping("/list")
    public String organizerList(Model model) {
        List<Organizer> organizers = organizerService.getAllOrganizers();
        model.addAttribute("organizers", organizers);
        return "organizer/list";
    }

    @GetMapping("/create")
    public String createOrganizerForm(Model model) {
        return "organizer/create";
    }

    @PostMapping("/create")
    public String createOrganizer(@ModelAttribute Organizer organizer) {
        organizerService.createOrganizer(organizer);
        return "redirect:/organizers/list";
    }

    @GetMapping("/update/{id}")
    public String updateOrganizerForm(@PathVariable Long id, Model model) {
        Organizer organizer = organizerService.getOrganizerById(id).orElseThrow();
        model.addAttribute("organizer", organizer);
        return "organizer/update";
    }

    @PostMapping("/update/{id}")
    public String updateOrganizer(@PathVariable Long id, @ModelAttribute Organizer organizer) {
        organizerService.updateOrganizer(id, organizer);
        return "redirect:/organizers/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
        return "redirect:/organizers/list";
    }
}

