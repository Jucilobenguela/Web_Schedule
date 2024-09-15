package com.benguela.backEnd_schedule.service.serviceImpl;

import com.benguela.backEnd_schedule.Repository.CompanyRepository;
import com.benguela.backEnd_schedule.model.Client;
import com.benguela.backEnd_schedule.service.serviceI.ClientServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientServiceI {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Client validate(Client client) {
        return null;

    }

    @Override
    public void schedule(Client client) {

    }
}
