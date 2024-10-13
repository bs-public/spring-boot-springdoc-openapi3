package com.springdoc.service;

import java.util.List;
import java.util.stream.Collectors;

import com.springdoc.dto.UserDTO;
import com.springdoc.entity.User;
import com.springdoc.mapper.UserMapper;
import com.springdoc.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserService(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  public UserDTO createUser(UserDTO userDto) {
    User user = userMapper.toEntity(userDto);
    return userMapper.toDto(userRepository.save(user));
  }

  public List<UserDTO> getAllUsers() {
    return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
  }

  public UserDTO getUserById(Long id) {
    return userRepository.findById(id).map(userMapper::toDto).orElse(null);
  }

  public UserDTO updateUser(Long id, UserDTO userDetailsDto) {
    return userRepository
        .findById(id)
        .map(
            user -> {
              user.setName(userDetailsDto.getName());
              user.setEmail(userDetailsDto.getEmail());
              return userMapper.toDto(userRepository.save(user));
            })
        .orElse(null);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
