package j6l12hw.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import j6l12hw.dto.UserDto;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserDto> findAll();

    UserDto findById(int id);

    UserDto save(UserDto userDto);

    void deleteById(int id);


}
