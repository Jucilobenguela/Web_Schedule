package com.benguela.backEnd_schedule.controller;

import com.benguela.backEnd_schedule.convert.ConvertToUserSchedule;
import com.benguela.backEnd_schedule.dto.request.UserScheduleRequestCreate;
import com.benguela.backEnd_schedule.dto.request.UserScheduleRequestLogin;
import com.benguela.backEnd_schedule.exeptions.UserScheduleException;
import com.benguela.backEnd_schedule.model.UserSchedule;
import com.benguela.backEnd_schedule.security.AuthService;
import com.benguela.backEnd_schedule.security.TokenService;
import com.benguela.backEnd_schedule.service.serviceImpl.UserScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserScheduleController {
    @Autowired
    AuthService authService;
    @Autowired
    TokenService tokenService;


    @Autowired
    UserScheduleService userScheduleServiceI;
    @PostMapping("/register")
    public ResponseEntity<UserSchedule> register(@RequestBody UserScheduleRequestCreate userScheduleRequestCreate) throws UserScheduleException {
        UserSchedule userSchedule = ConvertToUserSchedule.userScheduleRequestCreate(userScheduleRequestCreate);
        userSchedule.setPassword(authService.encoderPassword(userSchedule.getPassword()));
        userScheduleServiceI.createUser(userSchedule);
        return ResponseEntity.ok().body(userSchedule);
    }




    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserScheduleRequestLogin userScheduleRequest) throws UserScheduleException {
        try {
            Object object =  authService.authenticateUser(userScheduleRequest.email(),
                    userScheduleRequest.password());
            UserSchedule userSchedule;
            if (!(object instanceof UserSchedule)){
                throw new UserScheduleException("O objecto autenticado não é uma intância de UserSchedule");
            }
            userSchedule = (UserSchedule) object;
            String token = tokenService.generateToken(userSchedule.getEmail());
            HttpHeaders responseHeader= new HttpHeaders();
            responseHeader.set("Authorization","Bearer"+token);
            return ResponseEntity.ok().headers(responseHeader).body("User Authenticated");


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}

