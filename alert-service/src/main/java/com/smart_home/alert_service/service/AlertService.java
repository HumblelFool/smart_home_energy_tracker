package com.smart_home.alert_service.service;

import com.smart_home.kafka.event.AlertingEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AlertService {

    private final EmailService emailService;
    public AlertService(EmailService emailService){
        this.emailService=emailService;
    }

    public void energyUsageAlert(AlertingEvent alertingEvent){
        log.info("Received alert event :{}",alertingEvent);

        //send email alert
        final String subject="Energy Usage Alert for User"+
                alertingEvent.getUserId();

        final String message="Alert :"+alertingEvent.getMessage()+
                "\nThreshold: "+alertingEvent.getThreshold()+
                "\nEnergy Consumed: "+alertingEvent.getEnergyConsumed();

        emailService.sendEmail(alertingEvent.getEmail(),
                subject,
                message,
                alertingEvent.getUserId());
    }
}
