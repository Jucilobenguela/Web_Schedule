package com.benguela.backEnd_schedule.controller;

import com.benguela.backEnd_schedule.dto.request.UserScheduleRequestLogin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserScheduleController {
    @PostMapping("/register")
    public ResponseEntity<?> register() {
        return ResponseEntity.ok().build();
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(UserScheduleRequestLogin userScheduleRequest) {
        return ResponseEntity.ok().build();
    }
}
