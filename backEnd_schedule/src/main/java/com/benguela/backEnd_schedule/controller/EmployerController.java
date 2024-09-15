package com.benguela.backEnd_schedule.controller;

import com.benguela.backEnd_schedule.convert.EmployerConvert.ConvertToEmployer;
import com.benguela.backEnd_schedule.dto.request.employerDto.EmployerRequestCreate;
import com.benguela.backEnd_schedule.dto.request.employerDto.EmployerRequestLogin;
import com.benguela.backEnd_schedule.exeptions.UserScheduleException;
import com.benguela.backEnd_schedule.exeptions.employerException.EmployerExisting;
import com.benguela.backEnd_schedule.model.Employer;
import com.benguela.backEnd_schedule.security.AuthService;
import com.benguela.backEnd_schedule.security.TokenService;
import com.benguela.backEnd_schedule.service.serviceI.EmployerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/employer")

public class EmployerController {
    @Autowired
    EmployerServiceI employerServiceI;
    @Autowired
    AuthService authService;
    @Autowired
    TokenService tokenService;
    @PostMapping("/create")
    public ResponseEntity<?> create( @RequestBody EmployerRequestCreate employerRequestCreate) throws EmployerExisting {
       Employer employer= ConvertToEmployer.employerCreate(employerRequestCreate);
       employer.setPassword(authService.encoderPassword(employer.getPassword()));
        employerServiceI.create(employer);
       return ResponseEntity.ok().build();

    }
    @PutMapping
    public ResponseEntity<?> update(){
        return ResponseEntity.ok().build();

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody EmployerRequestLogin employerRequestLogin){
        try {
            Object object =  authService.authenticateUser(employerRequestLogin.name(),
                    employerRequestLogin.password());
            Employer employer;
            if (!(object instanceof Employer)){
                throw new UserScheduleException("O objecto autenticado não é uma intância de UserSchedule");

            }
            employer = (Employer) object;
            String token = tokenService.generateToken(employer.getName());
            HttpHeaders responseHeader= new HttpHeaders();
            responseHeader.set("Authorization","Bearer"+token);
            return ResponseEntity.ok().headers(responseHeader).body("User Authenticated");


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
    @DeleteMapping("")
    public ResponseEntity<?> delete(){
        return ResponseEntity.ok().build();

    }
    @PostMapping("/register")
    public ResponseEntity<?> register(){
        return ResponseEntity.ok().build();

    }
    @GetMapping()
    public ResponseEntity<?> getEmployerList(){
        return ResponseEntity.ok().body(employerServiceI.getListEmployer());
    }
}
