package com.benguela.backEnd_schedule.service.serviceI;

import com.benguela.backEnd_schedule.exeptions.employerException.EmployerExisting;
import com.benguela.backEnd_schedule.model.Employer;

import java.util.List;

public interface EmployerServiceI {
    void login(Employer employer);
    void registerInfo(Employer employer);
    Employer create(Employer employer) throws EmployerExisting;
    Employer save(Employer employer) throws EmployerExisting;
    List<Employer> getListEmployer();

}
