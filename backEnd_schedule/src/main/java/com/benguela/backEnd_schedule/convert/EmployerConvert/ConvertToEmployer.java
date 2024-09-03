package com.benguela.backEnd_schedule.convert.EmployerConvert;

import com.benguela.backEnd_schedule.dto.request.employerDto.EmployerRequestCreate;
import com.benguela.backEnd_schedule.dto.request.employerDto.EmployerRequestLogin;
import com.benguela.backEnd_schedule.model.Employer;

public class ConvertToEmployer {

 public static   Employer employerCreate(EmployerRequestCreate employerRequestCreate){
     return new Employer(employerRequestCreate.name(), employerRequestCreate.password());
 }
}
