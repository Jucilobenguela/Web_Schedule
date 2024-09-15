package com.benguela.backEnd_schedule.Repository;

import com.benguela.backEnd_schedule.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    public Company findByFiscalNumber(Integer fiscalNumber);
}
