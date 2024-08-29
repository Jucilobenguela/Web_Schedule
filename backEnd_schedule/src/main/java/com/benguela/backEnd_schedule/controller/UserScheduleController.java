package com.benguela.backEnd_schedule.controller;

import com.benguela.backEnd_schedule.convert.ConvertToUserSchedule;
import com.benguela.backEnd_schedule.dto.request.UserScheduleRequestCreate;
import com.benguela.backEnd_schedule.dto.request.UserScheduleRequestLogin;
import com.benguela.backEnd_schedule.exeptions.UserScheduleException;
import com.benguela.backEnd_schedule.model.UserSchedule;
import com.benguela.backEnd_schedule.security.AuthService;
import com.benguela.backEnd_schedule.service.serviceI.UserScheduleServiceI;
import com.benguela.backEnd_schedule.service.serviceImpl.UserScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserScheduleController {
    @Autowired
    AuthService authService;


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
            authService.authenticateUser(userScheduleRequest.email(), userScheduleRequest.password());
        } catch (UserScheduleException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
}

