package com.benguela.backEnd_schedule.security;

import com.benguela.backEnd_schedule.model.Employer;
import com.benguela.backEnd_schedule.model.UserSchedule;
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

    public Object authenticateUser(String username, String password) throws Exception {
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authResult = authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(authResult);

            if (authResult.getPrincipal() instanceof UserSchedule) {
                return  authResult.getPrincipal();
            } else if (authResult.getPrincipal() instanceof Employer) {
                return  authResult.getPrincipal();
            } else {
                throw new Exception("Usuário autenticado não é uma instância válida.");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public String encoderPassword(String password) throws NullPointerException {
        if(password.isEmpty()){
            throw new NullPointerException("Password Empty");
        }
        return passwordEncoder.encode(password);
    }
}
