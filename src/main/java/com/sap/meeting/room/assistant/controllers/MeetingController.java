package com.sap.meeting.room.assistant.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = MeetingController.PATH)
@RestController
public class MeetingController {

    public static final String PATH = "/api/v1.01/mra/meeting";

    @GetMapping(path = "/authors", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String authors() {
        String jsonString = "{\"authors\": [\"Stefan Misik\", \"Libor Bucek\"]}";
        
        return jsonString;
    }
}