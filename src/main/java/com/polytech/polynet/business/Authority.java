package com.polytech.polynet.business;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class Authority {

    @EmbeddedId
    private AuthorityId authorityId;

    public Authority(String username, String authority) {
        this.authorityId = new AuthorityId(username);
        this.authorityId.setAuthority((authority));
    }

    @Embeddable
    class AuthorityId implements Serializable {
        @Column(name = "username")
        private String username;

        @Column(name = "authority")
        private String authority;

        AuthorityId(String username) {
            this.username = username;
        }

        void setAuthority(String authority) {
            this.authority = authority;
        }
    }
}
