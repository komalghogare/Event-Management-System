package com.example.demo.controller;

package com.example.eventmanagement.controllers;

import com.example.eventmanagement.entities.Event;
import com.example.eventmanagement.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/list")
    public String eventList(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "event/list";
    }

    @GetMapping("/create")
    public String createEventForm(Model model) {
        return "event/create";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event) {
        eventService.createEvent(event);
        return "redirect:/events/list";
    }

    @GetMapping("/update/{id}")
    public String updateEventForm(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id).orElseThrow();
        model.addAttribute("event", event);
        return "event/update";
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable Long id, @ModelAttribute Event event) {
        eventService.updateEvent(id, event);
        return "redirect:/events/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/events/list";
    }
}

