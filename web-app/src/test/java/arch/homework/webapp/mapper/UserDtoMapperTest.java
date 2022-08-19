package arch.homework.webapp.mapper;

import arch.homework.webapp.controller.dto.UserDto;
import arch.homework.webapp.dao.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserDtoMapperTest {

    @Test
    void userToUserDto() {
        User user = new User(UUID.randomUUID(),"name", "first_name","last_name","mail","phone");
        UserDto userDto = UserDtoMapper.INSTANCE.userToUserDto(user);
        Assertions.assertNotNull(userDto.getId());
    }

    @Test
    void userDtoToUser() {
        UserDto userDto = new UserDto(UUID.randomUUID(),"name", "first_name","last_name","mail","phone");
        User user = UserDtoMapper.INSTANCE.userDtoToUser(userDto);
        Assertions.assertNotNull(user.getId());
    }
}