package com.example.demo.service;

package com.example.eventmanagement.services;

import com.example.eventmanagement.entities.Organizer;
import com.example.eventmanagement.repositories.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Optional<Organizer> getOrganizerById(Long id) {
        return organizerRepository.findById(id);
    }

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Organizer updateOrganizer(Long id, Organizer organizerDetails) {
        Organizer organizer = organizerRepository.findById(id).orElseThrow();
        organizer.setName(organizerDetails.getName());
        organizer.setContactInfo(organizerDetails.getContactInfo());
        return organizerRepository.save(organizer);
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }
}

