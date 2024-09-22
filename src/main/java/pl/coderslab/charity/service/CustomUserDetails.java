package pl.coderslab.charity.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String mail;
    private String surname;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String mail, String surname) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.mail = mail;
        this.surname = surname;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getMail() {
        return mail;
    }


    public String getSurname() {
        return surname;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}