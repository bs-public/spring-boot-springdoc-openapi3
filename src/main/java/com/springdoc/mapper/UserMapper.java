package com.springdoc.mapper;

import com.springdoc.dto.UserDTO;
import com.springdoc.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDTO toDto(User user);

  User toEntity(UserDTO userDTO);
}
