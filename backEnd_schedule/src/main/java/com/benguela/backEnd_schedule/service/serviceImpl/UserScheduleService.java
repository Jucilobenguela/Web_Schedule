package com.benguela.backEnd_schedule.service.serviceImpl;

import com.benguela.backEnd_schedule.Repository.UserScheduleRepository;
import com.benguela.backEnd_schedule.exeptions.UserScheduleException;
import com.benguela.backEnd_schedule.model.UserSchedule;
import com.benguela.backEnd_schedule.service.serviceI.UserScheduleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserScheduleService implements UserScheduleServiceI, UserDetailsService {

    @Autowired
    UserScheduleRepository userScheduleRepository;


    /*
     * Cria um novo usuário.
     *
     * @param userSchedule O  usuário a ser criado.
     * @return O  usuário criado.
     */
    @Override
    public UserSchedule createUser(UserSchedule userSchedule) throws UserScheduleException {
        UserSchedule schedule = (UserSchedule) userScheduleRepository.findByEmail(userSchedule.getEmail());
        if (schedule != null){
            throw new UserScheduleException("Usuário já existente");
        }
        return  userScheduleRepository.save(userSchedule);
    }


    /*
     * Recupera um usuário pelo ID.
     *
     * @param id O ID do usuário.
     * @return O usuário correspondente ao ID.
     */
    @Override
    public UserSchedule getUserById(Long id) throws UserScheduleException {
        UserSchedule userSchedule = userScheduleRepository.findById(id).orElse(null);
        if (userSchedule == null) {
            throw new UserScheduleException("Usuário não encontrado");
        }
        return userSchedule;
    }

    /*
     * Recupera um usuário pelo email.
     *
     * @param email O email do usuário.
     * @return O usuário correspondente ao email.
     */
    @Override
    public UserSchedule getUserByEmail(String email) throws UserScheduleException {
        UserSchedule userSchedule = (UserSchedule) userScheduleRepository.findByEmail(email);
        if (userSchedule == null) {

            throw new UserScheduleException("Usuário não encontrado");
        }

        return userSchedule;
    }

    /*
     * Atualiza um usuário existente.
     *
     * @param id O ID  do usuário a ser atualizado.
     * @param updatedUser O usuário atualizado.
     * @return O  usuário atualizado.
     */
    @Override
    public UserSchedule updateUser(Long id, UserSchedule updatedUser) {
        return null;
    }

    /*
     * Exclui um  usuário pelo ID.
     *
     * @param id O ID do  usuário a ser excluído.
     */
    @Override
    public void deleteUser(Long id) {

    }

    /*
     * Recupera todos os usuários.
     *
     * @return Uma lista de todos os  usuários.
     */
    @Override
    public List<UserSchedule> getAllUsers() {
        return null;
    }

    /*
     * Autentica um usuário com base em seu nome de usuário e senha.
     *
     * @param username O nome de usuário.
     * @param password A senha do usuário.
     * @return O  usuário autenticado.
     */
    @Override
    public UserSchedule authenticate(String email, String password) {
     /*   Authentication authentication = new UsernamePasswordAuthenticationToken(email
                ,password);
        authenticationManager.authenticate(authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return  (UserSchedule) authentication.getPrincipal();*/
        return null;
    }

    /*
     * Altera a senha de um usuário.
     *
     * @param userId O ID do usuário.
     * @param oldPassword A senha antiga do usuário.
     * @param newPassword A nova senha do usuário.
     */
    @Override
    public void changePassword(Long userId, String oldPassword, String newPassword) {

    }

    /*
     * Reseta a senha de um usuário, enviando um email de recuperação.
     *
     * @param email O email do usuário.
     */
    @Override
    public void resetPassword(String email) {

    }

    /*
     * Verifica se um email está disponível para uso.
     *
     * @param email O email a ser verificado.
     * @return true se o email estiver disponível, false caso contrário.
     */
    @Override
    public boolean isEmailAvailable(String email) {
        return false;
    }

    /*
     * Atribui um papel (role) a um usuário.
     *
     * @param userId O ID do usuário.
     * @param roleName O nome do papel a ser atribuído.
     */
    @Override
    public void assignRoleToUser(Long userId, String roleName) {

    }

    /*
     * Verifica se um usuário tem a autorização necessária para uma determinada ação.
     *
     * @param userId O ID do usuário.
     * @param permission A permissão a ser verificada.
     * @return true se o usuário estiver autorizado, false caso contrário.
     */
    @Override
    public boolean isUserAuthorized(Long userId, String permission) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserSchedule userSchedule =   userScheduleRepository.findByEmail(email);
        if (userSchedule==null){
            throw new UsernameNotFoundException("Usuario com email: "+ email+" não encontrado");
        }
        return userSchedule;

    }

}