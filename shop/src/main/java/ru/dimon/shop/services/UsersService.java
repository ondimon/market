package ru.dimon.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dimon.shop.dto.UserDto;
import ru.dimon.shop.entities.User;
import ru.dimon.shop.mappers.UserMapper;
import ru.dimon.shop.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements UserDetailsService {
    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User findByUsername(String username) {
        return usersRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
    }

    public User findById(Long id) {
       return usersRepository.findById(id).orElseThrow(
                                () -> new UsernameNotFoundException(String.format("Can't found user with %d", id)));
    }

    public UserDto findByUsernameDto(String username) {
        User user = findByUsername(username);
        return UserMapper.MAPPER.fromUser(user);
    }

    public User saveOrUpdate(User user) {
        return usersRepository.save(user);
    }

    public List<User> findAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                                                                      user.getPassword(),
                                                                      true,
                                                                      true,
                                                                      true,
                                                                      !user.isLocked(),
                                                                      roles);
    }

}