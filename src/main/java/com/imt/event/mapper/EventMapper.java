package com.imt.event.mapper;

import com.imt.event.Model.Entity.EventEntity;
import com.imt.event.dto.EventDto;

public class EventMapper {
    public static EventDto mapToDto(EventEntity entity) {
        return new EventDto(
                entity.getId(),
                entity.getTitle(),
                entity.getOrganizer(),
                entity.getDatetime()
        );}
