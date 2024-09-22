package pl.coderslab.charity.entity;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private String password;
    private String surname;
    private String mail;

    public User(String mail, String encode, String surname) {

    }

    public User(String name, String password, String surname, String mail) {
        super();
        this.name = name;
        this.password = password;
        this.surname = surname;
        this.mail = mail;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surename) {
        this.surname = surename;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", surname=" + surname + ", mail=" + mail + "]";
    }

}