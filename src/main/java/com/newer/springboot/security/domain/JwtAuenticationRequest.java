package com.newer.springboot.security.domain;

import java.io.Serializable;

public class JwtAuenticationRequest implements Serializable {
    private static final long serialVersionUID = -6772892293419101520L;

    private String username;
    private String password;

    public JwtAuenticationRequest() {
    }

    public JwtAuenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
