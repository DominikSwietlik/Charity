package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByMail(String mail);

    User save(UserDto userDto);
}