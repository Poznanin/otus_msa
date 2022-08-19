package arch.homework.webapp.service.implement;

import arch.homework.webapp.controller.dto.UserDto;
import arch.homework.webapp.dao.entity.User;
import arch.homework.webapp.dao.repository.UserRepository;
import arch.homework.webapp.mapper.UserDtoMapper;
import arch.homework.webapp.service.UserService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserService selfInject;


    public UserServiceImpl(
            @NonNull final UserRepository userRepository,
            @NonNull @Lazy final UserService userService) {
        this.userRepository = userRepository;
        this.selfInject = userService;
    }


    @Override
    public @NonNull UserDto createUser(@NonNull UserDto userDto) {
        User user = UserDtoMapper.INSTANCE.userDtoToUser(userDto);
        return UserDtoMapper.INSTANCE.userToUserDto(userRepository.save(user));

    }

    @Override
    public @NonNull UserDto updateUser(@NonNull UserDto userDto) {
        User user = UserDtoMapper.INSTANCE.userDtoToUser(userDto);
        return UserDtoMapper.INSTANCE.userToUserDto(userRepository.save(user));
    }

    @Override
    public @NonNull UserDto getUserById(@NonNull UUID idUser) {
        return UserDtoMapper.INSTANCE.userToUserDto(userRepository.findById(idUser).get());
    }

    @Override
    public void deleteUserByIs(@NonNull UUID idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public @NonNull List<UserDto> getUserList() {

        return userRepository.findAll().parallelStream()
                .map(u -> UserDtoMapper.INSTANCE.userToUserDto(u))
                .toList();
    }
}
