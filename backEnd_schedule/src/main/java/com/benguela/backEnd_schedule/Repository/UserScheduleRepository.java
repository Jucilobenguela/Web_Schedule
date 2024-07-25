package com.benguela.backEnd_schedule.Repository;

import com.benguela.backEnd_schedule.model.UserSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;


@Repository
public interface UserScheduleRepository extends JpaRepository<UserSchedule, Long> {


    UserDetails findByEmail(String userEmail);
}
