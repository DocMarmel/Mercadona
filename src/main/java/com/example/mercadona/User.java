package com.example.mercadona;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private String password;
    @Column(unique = true)
    private String mail;

    public User() {

    }

    public User(int id, String lastName, String firstName, String password, String mail) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.mail = mail;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {

        this.mail = mail;
    }
}
