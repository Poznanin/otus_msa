package arch.homework.webapp.mapper;

import arch.homework.webapp.controller.dto.UserDto;
import arch.homework.webapp.dao.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDtoMapper {
    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
