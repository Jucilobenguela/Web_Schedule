package com.benguela.backEnd_schedule.security;

import com.benguela.backEnd_schedule.Repository.EmployerRepository;
import com.benguela.backEnd_schedule.Repository.UserScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class AuthorizationService implements UserDetailsService {
        @Autowired
        UserScheduleRepository userRepository;
        @Autowired
        EmployerRepository employeeRepository;

        /**
         * Tenta carregar um usuário com base no nome de usuário
         * Se não encontrar um usuário com o nome de usuário fornecido,
         * tenta carregar um funcionário com base no nome de usuário
         * Se ainda assim não encontrar nenhum usuário, lança uma exceção
         *
         * @param username
         * @return
         * @throws UsernameNotFoundException
         */
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            UserDetails user = userRepository.findByEmail(username);
            if (user == null) {
                user = employeeRepository.findByName(username);
            }
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            return user;
        }
    }
