package com.benguela.backEnd_schedule.Repository;

import com.benguela.backEnd_schedule.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer,Long> {

    Employer findByName(String name);
}
