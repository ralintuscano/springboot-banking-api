package org.example.spring_boot_bank_api.models.mappers;

import org.example.spring_boot_bank_api.models.dtos.request.user.UserRequestDTO;
import org.example.spring_boot_bank_api.models.dtos.response.user.UserResponseDTO;
import org.example.spring_boot_bank_api.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "name", ignore = true)
    User userRequestDTOtoUser(UserRequestDTO userRequestDTO);
    UserResponseDTO usertoUserResponseDTO(User user);
}
