package com.smart_home.kafka.event;

import lombok.Builder;

@Builder
public record AlertingEvent (
        Long userId,
        String message,
        double threshold,
        double energyConsumed,
        String email
){

}
