package com.benguela.backEnd_schedule.model;

import com.benguela.backEnd_schedule.util.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class UserSchedule extends EntityBase implements UserDetails {
    private String email;
    private String password;
    private boolean enable;
    private RoleEnum roles;
   @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "userSchedule")
    private Set<Employer> employerSet;


    public UserSchedule(String userName, String email, String password) {
       super(userName);
        this.email = email;
        this.password = password;
    }
    public UserSchedule(){
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(roles == RoleEnum.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.getName();
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


    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password=password;
    }
}
