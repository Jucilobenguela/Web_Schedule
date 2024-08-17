package com.benguela.backEnd_schedule.controller;

import com.benguela.backEnd_schedule.dto.request.ServiceProvidedRequest;
import com.benguela.backEnd_schedule.dto.response.ServiceProvidedResponse;
import com.benguela.backEnd_schedule.service.serviceI.ServiceProvidedServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")

public class ServiceProvidedController {
    @Autowired
    ServiceProvidedServiceI serviceProvidedServiceI;

    @PostMapping("/register")
    public ResponseEntity<ServiceProvidedResponse> register(ServiceProvidedRequest serviceProvidedRequest){
        return ResponseEntity.ok().body(new ServiceProvidedResponse());

    }
}
