package com.benguela.backEnd_schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")

public class ServiceController {
    @Autowired
    
    @PostMapping("/register")
    public ResponseEntity<> register(ServiceRequest serviceRequest){

    }
}
