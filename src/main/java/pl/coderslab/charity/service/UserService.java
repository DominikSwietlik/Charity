package pl.coderslab.charity.service;


import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.entity.User;

public interface UserService {
    User findByMail(String mail);

    User save(UserDto userDto);

}