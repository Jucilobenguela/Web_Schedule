package com.benguela.backEnd_schedule.model;

import com.benguela.backEnd_schedule.util.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
public class Employer extends EntityBase implements UserDetails {
    private RoleEnum roles;
    int dayOff;
    Date starOfVacation;
    Date endOfVacation;
    int starWorkingHours;
    int endWorkingHours;
    Date notAvailableHours;
    private String password;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "userSchedule_id")
    private UserSchedule userSchedule;

    @OneToOne(mappedBy = "employer")
    private Client client;
    public Employer(String name, String password) {
        super(name);
        this.password = password;
    }
    public Employer(){

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(roles == RoleEnum.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.getName();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    public Date getStarOfVacation() {
        return starOfVacation;
    }

    public void setStarOfVacation(Date starOfVacation) {
        this.starOfVacation = starOfVacation;
    }

    public Date getEndOfVacation() {
        return endOfVacation;
    }

    public void setEndOfVacation(Date endOfVacation) {
        this.endOfVacation = endOfVacation;
    }

    public int getStarWorkingHours() {
        return starWorkingHours;
    }

    public void setStarWorkingHours(int starWorkingHours) {
        this.starWorkingHours = starWorkingHours;
    }

    public int getEndWorkingHours() {
        return endWorkingHours;
    }

    public void setEndWorkingHours(int endWorkingHours) {
        this.endWorkingHours = endWorkingHours;
    }

    public Date getNotAvailableHours() {
        return notAvailableHours;
    }

    public void setNotAvailableHours(Date notAvailableHours) {
        this.notAvailableHours = notAvailableHours;
    }



    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
