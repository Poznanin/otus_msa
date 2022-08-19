package arch.homework.webapp.controller;

import arch.homework.webapp.controller.dto.UserDto;
import arch.homework.webapp.controller.exception.BadIdError;
import arch.homework.webapp.controller.meta.HttpStatusCode;
import arch.homework.webapp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequestMapping(value = "/api/v1/user/",
        produces = APPLICATION_JSON_VALUE, consumes = {APPLICATION_JSON_VALUE})
@RestController
public class UserController {
    @NonNull
    private final UserService userService;

    @Autowired
    public UserController(@NonNull final UserService userService) {
        this.userService = userService;
    }

    private final static String EXAMPLE_USER_CREATE = " {\n" +
            "    \"id\": \"\",\n" +
            "    \"name\": \"Имя\",\n" +
            "    \"firstName\": \"Отчество\",\n" +
            "    \"lastName\": \"Фамилия\",\n" +
            "    \"mail\": \"Емейл\",\n" +
            "    \"phone\": \"Телефон\"\n" +
            "  }";


    @NonNull
    static UUID getUuid(@NotNull final String id) throws BadIdError {
        final UUID res;
        try {
            res = UUID.fromString(id);
        } catch (final IllegalArgumentException e) {
            log.info("Ошибка формата идентификатора: \n" + e);
            throw new BadIdError(id, format("Неверный формат идентификатора \"%s\"", id));
        }
        return res;
    }


    @NonNull
    @GetMapping(produces = APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @Operation(summary = "Возвращает список пользователей",
            responses = {
                    @ApiResponse(responseCode = HttpStatusCode.OK_CODE,
                            description = "Список пользователей",
                            content = {
                                    @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = UserDto[].class))
                            }
                    ),
                    @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR_CODE, description = "Непредвиденная ошибка",
                            content = {
                                    @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = ErrorMessage.class)
                                    )
                            }
                    )
            }
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity
                .ok()
                .body(userService.getUserList());
    }

    @NonNull
    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @Operation(summary = "Возвращает информацию о пользователе по его ID",
            responses = {
                    @ApiResponse(responseCode = HttpStatusCode.OK_CODE,
                            description = "Информация о пользователе",
                            content = {
                                    @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = UserDto.class))
                            }
                    ),
                    @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR_CODE, description = "Непредвиденная ошибка",
                            content = {
                                    @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = ErrorMessage.class)
                                    )
                            }
                    )
            }
    )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> getUserById(@Parameter(
            description = "Идентификатор пользователя",
            schema = @Schema(
                    description = "Идентификатор пользователя",
                    format = "uuid"),
            examples = {
                    @ExampleObject(name = "Идентификатор пользователя", value = "",
                            description = "Строковое представление GUID " +
                                    "для идентификатора пользователя")
            },
            required = true
    )
                                               @PathVariable(value = "id") @NotNull final String id
    ) {
        UUID uuid = getUuid(id);
        return ResponseEntity
                .ok()
                .body(userService.getUserById(uuid));
    }

    @PostMapping(path = "", produces = APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Производит создание пользователя.",
            responses = {
                    @ApiResponse(responseCode = HttpStatusCode.OK_CODE,
                            description = "Информация о пользователе",
                            content = {
                                    @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = UserDto.class))
                            }
                    ),
                    @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR_CODE, description = "Непредвиденная ошибка",
                            content = {
                                    @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = ErrorMessage.class)
                                    )
                            }
                    )
            }
    )
    @ResponseStatus(HttpStatus.OK)
    @NonNull
    ResponseEntity<UserDto> createUser(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные создаваемого пользователя",
                    content = @Content(
                            schema = @Schema(
                                    description = "Данные создаваемого пользователя",
                                    example = EXAMPLE_USER_CREATE),
                            mediaType = APPLICATION_JSON_VALUE
                    ),
                    required = true
            )
            @RequestBody @Valid @NotNull final UserDto userDto) {
        return ResponseEntity
                .ok()
                .body(userService.createUser(userDto));
    }

    @PutMapping(path = "{id}", produces = APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Производит обновление информации о пользователе.",
            responses = {
                    @ApiResponse(responseCode = HttpStatusCode.OK_CODE,
                            description = "Информация о пользователе",
                            content = {
                                    @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = UserDto.class))
                            }
                    ),
                    @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR_CODE, description = "Непредвиденная ошибка",
                            content = {
                                    @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = ErrorMessage.class)
                                    )
                            }
                    )
            }
    )
    @ResponseStatus(HttpStatus.OK)
    @NonNull
    ResponseEntity<UserDto> updateUser(
            @Parameter(
                    description = "Идентификатор пользователя",
                    schema = @Schema(
                            description = "Идентификатор пользователя",
                            format = "uuid"),
                    examples = {
                            @ExampleObject(name = "Идентификатор пользователя", value = "",
                                    description = "Строковое представление GUID " +
                                            "для идентификатора пользователя")
                    },
                    required = true
            )
            @PathVariable(value = "id") @NotNull final String id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные обновляемого пользователя",
                    content = @Content(
                            schema = @Schema(
                                    description = "Данные обновляемого пользователя",
                                    example = EXAMPLE_USER_CREATE),
                            mediaType = APPLICATION_JSON_VALUE
                    ),
                    required = true
            )
            @RequestBody() @Valid @NotNull final UserDto userDto){
        UUID uuid = getUuid(id);
        userDto.setId(uuid);
        return ResponseEntity
                .ok()
                .body(userService.updateUser(userDto));
    }


    @DeleteMapping(path = "{id}", produces = APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    @Operation(summary = "Удаляет пользователя",
            description = "Удалить пользователя по его id",
            responses = {
                    @ApiResponse(responseCode = HttpStatusCode.INTERNAL_SERVER_ERROR_CODE, description = "Непредвиденная ошибка",
                            content = {
                                    @Content(mediaType = APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = ErrorMessage.class)
                                    )
                            }
                    )
            }
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @NonNull
    ResponseEntity<Void> deleteUser(
            @Parameter(
                    description = "Идентификатор пользователя",
                    schema = @Schema(
                            description = "Идентификатор пользователя",
                            format = "uuid"),
                    examples = {
                            @ExampleObject(name = "Идентификатор пользователя", value = "",
                                    description = "Строковое представление GUID " +
                                            "для идентификатора пользователя")
                    },
                    required = true
            )
            @PathVariable(value = "id") @NotNull final String id) {
        UUID uuid = getUuid(id);
        userService.deleteUserByIs(uuid);
        return ResponseEntity.noContent().build();
    }

}
