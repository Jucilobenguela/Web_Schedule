package com.benguela.backEnd_schedule.util;

public enum RoleEnum {
    ADMIN("Admin"),
    USER("User");
    private final String roleName;
    private RoleEnum(String roleName){
        this.roleName=roleName;
    }

    public String getRoleName() {
       return this.roleName;
    }
}
