package com.imt.event.dto;

import java.time.LocalDateTime;
import java.util.UUID;

// Assure-toi d'importer ou de définir ta classe "Location" correctement
import com.imt.event.Model.Entity.LocationEntity; // Remplace cette ligne si tu as ta propre entité Location

public record EventDto(
        UUID id,
        String title,
        String description,
        double ticketPrice,
        UUID organizer,
        LocationEntity location, // Utilisation de la bonne classe pour Location
        LocalDateTime datetime
) {
    // Constructeur non-canonique
    public EventDto(UUID id, String title, UUID organizer) {
        this(id, title, null, 0.0, organizer, null, LocalDateTime.now());  // Délégation au constructeur canonique
    }
}
