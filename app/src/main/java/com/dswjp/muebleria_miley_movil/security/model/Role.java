package com.dswjp.muebleria_miley_movil.security.model;

import com.dswjp.muebleria_miley_movil.enums.RolName;

public class Role {
    private String id;
    private RolName rolName;

    public Role() {
    }

    public Role(String id, RolName rolName) {
        this.id = id;
        this.rolName = rolName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RolName getRolName() {
        return rolName;
    }

    public void setRolName(RolName rolName) {
        this.rolName = rolName;
    }
}
