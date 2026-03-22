package com.gpm.ems.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.twilio.Twilio;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class TwilioConfig {

    private static final Logger logger = LoggerFactory.getLogger(TwilioConfig.class);

    @Value("${TWILIO_ACCOUNT_SID}")
    private String accountSid;

    @Value("${TWILIO_AUTH_TOKEN}")
    private String authToken;

    @Value("${TWILIO_PHONE_NUMBER}")
    private String twilioNumber;

    @PostConstruct
    public void init() {
        if (accountSid == null || authToken == null || twilioNumber == null ||
                accountSid.isEmpty() || authToken.isEmpty() || twilioNumber.isEmpty()) {
            logger.error("Twilio configuration values are missing! Please check application.properties.");
            throw new IllegalStateException("Twilio configuration is incomplete. Check environment variables.");
        }

        Twilio.init(accountSid, authToken);
        logger.info("Twilio Initialized Successfully!");
        logger.info("TWILIO_ACCOUNT_SID: {}", accountSid);
        logger.info("TWILIO_PHONE_NUMBER: {}", twilioNumber);
    }

    public String getTwilioNumber() {
        return twilioNumber;
    }

    public String getAccountSid() {
        return accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }
}
