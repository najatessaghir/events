package com.imt.event.Model.Entity;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "eventTable")
public class EventEntity {

    @Id
    private UUID id;
    @Column
    private String title;
    @Column
    private UUID organizer;
    @Column
    private String description;
    @Column
    private double ticketPrice;
    @Column
    private LocalDateTime datetime;
    @ManyToOne
    private LocationEntity location;


    public EventEntity() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime date) {
        this.datetime = date;
    }

    public UUID getOrganizer() {
        return organizer;
    }

    public void setOrganizer(UUID organizer) {
        this.organizer = organizer;
    }

    public EventEntity(UUID id, String title, String description, double ticketPrice, LocalDateTime datetime, LocationEntity location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ticketPrice = ticketPrice;
        this.datetime = datetime;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventEntity that = (EventEntity) o;
        return Double.compare(ticketPrice, that.ticketPrice) == 0 && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(organizer, that.organizer) && Objects.equals(description, that.description) && Objects.equals(datetime, that.datetime) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, organizer, description, ticketPrice, datetime, location);
    }
}
