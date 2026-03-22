package com.gpm.ems.service;

import com.gpm.ems.config.TwilioConfig;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    private final TwilioConfig twilioConfig;

    @Autowired
    public SmsService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    public String sendSms(String to, String messageBody) {
        if (to == null || !to.matches("^\\+\\d{10,15}$")) {
            throw new IllegalArgumentException("Invalid phone number format: " + to);
        }

        try {
            String fromNumber = twilioConfig.getTwilioNumber();

            Message message = Message.creator(
                    new PhoneNumber(to),
                    new PhoneNumber(fromNumber),
                    messageBody
            ).create();

            return message.getSid();

        } catch (ApiException e) {
            throw new RuntimeException("Twilio API Error: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Failed to send SMS: " + e.getMessage());
        }
    }
}
