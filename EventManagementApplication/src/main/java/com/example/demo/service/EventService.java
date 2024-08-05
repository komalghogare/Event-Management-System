package com.example.demo.service;

package com.example.eventmanagement.services;

import com.example.eventmanagement.entities.Event;
import com.example.eventmanagement.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = eventRepository.findById(id).orElseThrow();
        event.setEventName(eventDetails.getEventName());
        event.setEventDate(eventDetails.getEventDate());
        event.setDescription(eventDetails.getDescription());
        event.setOrganizer(eventDetails.getOrganizer());
        event.setVenue(eventDetails.getVenue());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public List<Event> getEventsByVenueId(Long venueId) {
        return eventRepository.findByVenueId(venueId);
    }

    public List<Event> getEventsByOrganizerId(Long organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }
}
