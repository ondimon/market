package ru.dimon.shop.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.dimon.shop.dto.UserDto;
import ru.dimon.shop.entities.User;


@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    UserDto fromUser(User user);
}
