package com.home_energy.injestion_service.service;

import com.home_energy.injestion_service.dto.EnergyUsageDto;
import kafka.event.EnergyUsageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IngestionService {

    private final KafkaTemplate<String, EnergyUsageEvent>kafkaTemplate;

    public IngestionService(KafkaTemplate<String,EnergyUsageEvent> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }
    public void ingestionEnergyUsage(EnergyUsageDto usageDto) {

        //Convert DTO to event
        EnergyUsageEvent event=EnergyUsageEvent.builder()
                .deviceId(usageDto.deviceId())
                .energyConsumed(usageDto.energyConsumed())
                .timestamp(usageDto.timestamp())
                .build();

        // Send to Kafka Topic
        kafkaTemplate.send("energy-usage",event);
        log.info("Ingested Energy Usage Event :{}",event);
    }
}
