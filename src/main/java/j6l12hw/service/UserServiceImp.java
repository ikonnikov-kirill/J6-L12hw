package j6l12hw.service;


import j6l12hw.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import j6l12hw.dto.UserDto;
import j6l12hw.mapper.UserMapper;
import j6l12hw.model.Role;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        UserDto userDto = UserMapper.fromUser(userRepository.findUserByLogin(login));

        if (userDto == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new org.springframework.security.core.userdetails.User(
                userDto.getLogin(),
                userDto.getPassword(),
                mapRolesToAuthorities(userDto.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }


    @Override
    public List<UserDto> findAll() {
        return UserMapper.fromUsers(userRepository.findAll());
    }

    @Override
    public UserDto findById(int id) {
        return UserMapper.fromUser(userRepository.findById(id));
    }

    @Override
    public UserDto save(UserDto userDto) {
        userRepository.save(UserMapper.toUser(userDto));
        return userDto;
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

}

