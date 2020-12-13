package ru.dimon.market.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.dimon.market.dto.UserDto;
import ru.dimon.market.entities.User;


@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserDto fromUser(User user);
}
