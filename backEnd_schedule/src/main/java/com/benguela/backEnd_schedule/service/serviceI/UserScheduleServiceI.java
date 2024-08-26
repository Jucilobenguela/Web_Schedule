package com.benguela.backEnd_schedule.service.serviceI;

import com.benguela.backEnd_schedule.model.UserSchedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserScheduleServiceI {
    UserSchedule createUser(UserSchedule userSchedule);
    UserSchedule getUserById(Long id);
    UserSchedule getUserByEmail(String email);
    UserSchedule updateUser(Long id, UserSchedule updatedUser);
    void deleteUser(Long id);
    List<UserSchedule> getAllUsers();
    UserSchedule authenticate(String username, String password);
    void changePassword(Long userId, String oldPassword, String newPassword);
    void resetPassword(String email);
    boolean isEmailAvailable(String email);
    void assignRoleToUser(Long userId, String roleName);
    boolean isUserAuthorized(Long userId, String permission);
}
