package com.imt.event.service;

import com.imt.event.Model.Entity.EventEntity;
import com.imt.event.Model.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private View error;

    public List<EventEntity> getFirstEvents(){
        List<EventEntity> events = eventRepository.findAll();
        return events.subList(0,Math.min(events.size(),10));
    }

    public EventEntity getEventById(UUID id){
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("No event found with id: " + id));
    }

    public EventEntity createEvent(EventEntity event){
        return eventRepository.save(event);
    }

    public EventEntity updateEvent(EventEntity eventEntity) {
        Optional<EventEntity> existingEvent = eventRepository.findById(eventEntity.getId());
        if (existingEvent.isPresent()) {
            return eventRepository.save(eventEntity); // Mise à jour et sauvegarde
        } else {
            throw new RuntimeException("Event not found with ID: " + eventEntity.getId());
        }
    }

    public boolean deleteEvent(UUID id) {
        Optional<EventEntity> Event = eventRepository.findById(id);
        if (Event.isPresent()) {
            eventRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }


    }
}
