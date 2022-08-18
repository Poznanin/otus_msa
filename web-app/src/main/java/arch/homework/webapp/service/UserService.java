package arch.homework.webapp.service;

import arch.homework.webapp.controller.dto.UserDto;
import arch.homework.webapp.dao.entity.User;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

public interface UserService {

    @NonNull
    public UserDto createUser(@NonNull final UserDto userDto);

    @NonNull
    public UserDto updateUser(@NonNull final UserDto userDto);

    @NonNull
    public UserDto getUserByIs(@NonNull final UUID idUser);


    public void deleteUserByIs(@NonNull final UUID idUser);

    @NonNull
    public List<UserDto> getUserList();

}
