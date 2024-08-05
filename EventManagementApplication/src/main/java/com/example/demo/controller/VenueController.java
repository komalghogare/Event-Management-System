package com.example.demo.controller;

package com.example.eventmanagement.controllers;

import com.example.eventmanagement.entities.Venue;
import com.example.eventmanagement.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/venues")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @GetMapping("/list")
    public String venueList(Model model) {
        List<Venue> venues = venueService.getAllVenues();
        model.addAttribute("venues", venues);
        return "venue/list";
    }

    @GetMapping("/create")
    public String createVenueForm(Model model) {
        return "venue/create";
    }

    @PostMapping("/create")
    public String createVenue(@ModelAttribute Venue venue) {
        venueService.createVenue(venue);
        return "redirect:/venues/list";
    }

    @GetMapping("/update/{id}")
    public String updateVenueForm(@PathVariable Long id, Model model) {
        Venue venue = venueService.getVenueById(id).orElseThrow();
        model.addAttribute("venue", venue);
        return "venue/update";
    }

    @PostMapping("/update/{id}")
    public String updateVenue(@PathVariable Long id, @ModelAttribute Venue venue) {
        venueService.updateVenue(id, venue);
        return "redirect:/venues/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
        return "redirect:/venues/list";
    }
}

