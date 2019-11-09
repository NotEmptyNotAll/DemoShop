package com.example.demo.rest.Entity;

import org.springframework.http.HttpStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.security.Timestamp;

@Entity
public class Persistent_Logins {


    @NotNull
    private  String username;

    @Id
    @NotNull
    private String series;

    @NotNull
    private  String token;

    @NotNull
    private Timestamp talast_used;

    public Persistent_Logins() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getTalast_used() {
        return talast_used;
    }

    public void setTalast_used(Timestamp talast_used) {
        this.talast_used = talast_used;
    }
}
