package com.benguela.backEnd_schedule.convert;


import com.benguela.backEnd_schedule.dto.request.UserScheduleRequestCreate;
import com.benguela.backEnd_schedule.dto.request.UserScheduleRequestLogin;
import com.benguela.backEnd_schedule.model.UserSchedule;

public class  ConvertToUserSchedule {

    public static UserSchedule userScheduleRequestCreate(UserScheduleRequestCreate userScheduleRequestCreate) {
        return new UserSchedule(userScheduleRequestCreate.name(), userScheduleRequestCreate.email(),
                userScheduleRequestCreate.password());
    }
}