package com.benguela.backEnd_schedule.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
@RestController
@RequestMapping("/web_schedule/user")
public class UserScheduleController {
    @PostMapping("/register")
    public ResponseEntity<?> register() {
      return ResponseEntity.ok().build();
    }

}
