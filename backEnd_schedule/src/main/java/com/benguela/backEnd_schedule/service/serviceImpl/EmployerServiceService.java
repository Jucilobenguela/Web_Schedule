package com.benguela.backEnd_schedule.service.serviceImpl;

import com.benguela.backEnd_schedule.Repository.EmployerRepository;
import com.benguela.backEnd_schedule.exeptions.employerException.EmployerExisting;
import com.benguela.backEnd_schedule.model.Employer;
import com.benguela.backEnd_schedule.service.serviceI.EmployerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployerServiceService implements EmployerServiceI {
    @Autowired
    EmployerRepository employerRepository;
    @Override
    public void login(Employer employer) {

    }

    @Override
    public void registerInfo(Employer employer) {

    }

    @Override
    public Employer create(Employer employer) throws EmployerExisting {
        if (employer == null){
            throw new EmployerExisting("Employer null");
        }
        return save(employer);
    }

    @Override
    public Employer save(Employer employer) throws EmployerExisting {
        Employer employerDb = employerRepository.findByName(employer.getName());
        if (employerDb==null){
            return employerRepository.save(employer);
        }else {
            throw new EmployerExisting("Usuario existente");
        }
    }

    @Override
    public List<Employer> getListEmployer() {

        return employerRepository.findAll();
    }
}
