package com.benguela.backEnd_schedule.service.serviceI;

import com.benguela.backEnd_schedule.model.Client;

public interface ClientServiceI {
     Client validate(Client client);
     void schedule(Client client);
}
