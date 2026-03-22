package com.gpm.ems.controller;

import com.gpm.ems.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/sms")
@CrossOrigin(origins = "http://localhost:3000")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping("/send")
    public ResponseEntity<Map<String, String>> sendSms(
            @RequestParam String to,
            @RequestParam String message) {

        Map<String, String> response = new HashMap<>();
        try {
            String sid = smsService.sendSms(to, message);
            response.put("status", "success");
            response.put("message", "Message sent successfully!");
            response.put("sid", sid);
            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            response.put("status", "failed");
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            response.put("status", "failed");
            response.put("message", "Failed to send SMS: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
