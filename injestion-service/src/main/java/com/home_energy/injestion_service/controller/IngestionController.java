package com.home_energy.injestion_service.controller;

import com.home_energy.injestion_service.dto.EnergyUsageDto;
import com.home_energy.injestion_service.service.IngestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingestion")
public class IngestionController {

    private final IngestionService ingestionService;

    public IngestionController(IngestionService ingestionService){
        this.ingestionService=ingestionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void ingestionData(@RequestBody EnergyUsageDto usageDto){
        ingestionService.ingestionEnergyUsage(usageDto);
    }
}
