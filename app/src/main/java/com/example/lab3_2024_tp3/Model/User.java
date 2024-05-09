package com.example.lab3_2024_tp3.Model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    private long dni;
    private String lastname;
    private String name;
    private String mail;
    private String password;

    public User() {
    }

    public User(long dni, String lastname, String name, String mail, String password) {
        this.dni = dni;
        this.lastname = lastname;
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
