package com.example.springproject.maneger;

import com.example.springproject.dto.UserDto;
import com.example.springproject.entity.User;
import com.example.springproject.exception.UserNotFound;
import com.example.springproject.mapper.UserMapper;
import com.example.springproject.repository.UserRepository;
import com.example.springproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;


    @Override
    public List<UserDto> findAll(int page, int count) {

        Page<User> pageableUserList = userRepository.findAll(PageRequest.of(page, count));


        return pageableUserList
                .stream().map(userMapper::toUserDto)
                .toList();
    }

    @Override
    public UserDto findById(int id) {

        return userRepository.findById(id)
                .stream().map(userMapper::toUserDto)
                .findFirst().orElseThrow(() -> new UserNotFound("User tapilmadi!!"));
    }


    @Override
    public void addUser(UserDto user) {
        userRepository.save(userMapper.toUserEntity(user));
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
