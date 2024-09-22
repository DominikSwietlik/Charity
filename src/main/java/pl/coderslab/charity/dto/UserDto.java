package pl.coderslab.charity.dto;

public class UserDto {

    private String name;
    private String password;
    private String surname;
    private String mail;

    public UserDto(String name, String password, String surname, String mail) {
        super();
        this.name = name;
        this.password = password;
        this.surname = surname;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDto [name=" + name + ", password=" + password + ", surname=" + surname + ", mail=" + mail + "]";
    }
}