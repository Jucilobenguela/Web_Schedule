package com.benguela.backEnd_schedule.security;

import com.benguela.backEnd_schedule.exeptions.UserScheduleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;


    public void authenticateUser(String email, String password) throws UserScheduleException {

        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(email
                    ,password);

            authenticationManager.authenticate(authentication);

            Authentication authResult = authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(authResult);
        }
        catch (Exception e){
            throw new UserScheduleException(e.getMessage());
        }
    }
    public String encoderPassword(String password) throws NullPointerException {
        if(password.isEmpty()){
            throw new NullPointerException("Password Empty");
        }
        return passwordEncoder.encode(password);
    }
}
