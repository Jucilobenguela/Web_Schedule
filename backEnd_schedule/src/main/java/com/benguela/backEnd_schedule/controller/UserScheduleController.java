package com.benguela.backEnd_schedule.controller;

import com.benguela.backEnd_schedule.convert.ConvertToUserSchedule;
import com.benguela.backEnd_schedule.dto.request.UserScheduleRequestCreate;
import com.benguela.backEnd_schedule.dto.request.UserScheduleRequestLogin;
import com.benguela.backEnd_schedule.dto.response.UserScheduleResponseCreate;
import com.benguela.backEnd_schedule.exeptions.UserScheduleException;
import com.benguela.backEnd_schedule.model.UserSchedule;
import com.benguela.backEnd_schedule.service.serviceI.UserScheduleServiceI;
import com.benguela.backEnd_schedule.service.serviceImpl.UserScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserScheduleController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserScheduleService userScheduleServiceI;
    @PostMapping("/register")
    public ResponseEntity<UserSchedule> register(@RequestBody UserScheduleRequestCreate userScheduleRequestCreate) throws UserScheduleException {
        UserSchedule userSchedule = ConvertToUserSchedule.userScheduleRequestCreate(userScheduleRequestCreate);
        userScheduleServiceI.createUser(userSchedule);
        return ResponseEntity.ok().body(userSchedule);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserScheduleRequestLogin userScheduleRequest) throws UserScheduleException {

        try {
            UserSchedule userSchedule = (UserSchedule) userScheduleServiceI.loadUserByUsername(userScheduleRequest.email());
            Authentication authentication = new UsernamePasswordAuthenticationToken(userSchedule.getEmail()
                    ,userSchedule.getPassword());
            authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch (Exception e){
            throw new UserScheduleException(e.getMessage());
        }





        return ResponseEntity.ok().build();
    }
}
