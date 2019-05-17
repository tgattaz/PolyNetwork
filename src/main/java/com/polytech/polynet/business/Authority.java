package com.polytech.polynet.business;

import javax.persistence.*;

//@Entity
//@Table(name = "authorities")
public class Authority {

    public Authority() {}

    //@Id
    //@OneToOne
    //@JoinColumn(name="username")
    private String username;

    //@Column(name="authority")
    private String authority;

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
