package com.imt.event.Model.Repository;

import com.imt.event.Model.Entity.EventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<EventEntity, UUID> {

    EventEntity findFirstByTitle(String title);
    EventEntity findFirstByOrganizer(UUID organizer);
    List<EventEntity> findAll();
    Page<EventEntity> findAll(Pageable pageable);
}
