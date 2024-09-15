package com.benguela.backEnd_schedule.controller;

import com.benguela.backEnd_schedule.dto.request.client.ClientRequestSchedule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")

public class ClientController {
    @PostMapping("/{companyId}")
    public ResponseEntity<?> schedule(
           @PathVariable Integer companyId, @RequestBody ClientRequestSchedule requestSchedule){
        return ResponseEntity.ok().build();

    }
}
