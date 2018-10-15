package com.sap.meeting.room.assistant.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1.01/mra/meeting")
@RestController
public class MeetingController {

    @GetMapping(path = "/authors")
    public String authors() {
        String jsonString = "{\"authors\": [\"Stefan Misik\", \"Libor Bucek\"]}";
        
        return jsonString;
    }
}