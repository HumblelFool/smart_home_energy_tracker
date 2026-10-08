package com.smart_home.usage_service.controller;

import com.smart_home.usage_service.dto.UsageDto;
import com.smart_home.usage_service.service.UsageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usage")
public class UsageController {
    public final UsageService usageService;

    public UsageController(UsageService usageService) {
        this.usageService = usageService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UsageDto>getUserDeviceUsage(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "3") int days){
        final  UsageDto usageDto=usageService.getXDaysForUser(userId,days);
        return ResponseEntity.ok(usageDto);
    }
}
