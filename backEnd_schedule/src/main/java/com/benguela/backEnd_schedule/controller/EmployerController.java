package com.benguela.backEnd_schedule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employer")

public class EmployerController {
    @PostMapping("create")
    public ResponseEntity<?> create(){
       return ResponseEntity.ok().build();

    }
    @PutMapping
    public ResponseEntity<?> update(){
        return ResponseEntity.ok().build();

    }
    @PostMapping("login")
    public ResponseEntity<?> login(){
        return ResponseEntity.ok().build();

    }
    @DeleteMapping("")
    public ResponseEntity<?> delete(){
        return ResponseEntity.ok().build();

    }
    @PostMapping("register")
    public ResponseEntity<?> register(){
        return ResponseEntity.ok().build();

    }
    @GetMapping("")
    public ResponseEntity<?> getEmployerList(){
        return ResponseEntity.ok().build();

    }
}
