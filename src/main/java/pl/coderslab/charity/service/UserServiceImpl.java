package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User findByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getName(), passwordEncoder.encode(userDto.getPassword()),
                userDto.getSurname(), userDto.getMail());
        return userRepository.save(user);
    }

}