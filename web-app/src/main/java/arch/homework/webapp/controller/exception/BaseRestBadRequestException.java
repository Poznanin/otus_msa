package arch.homework.webapp.controller.exception;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

/**
 * Базовый BadRequestException.
 *
 * @author Даниил Староверов
 * @see BaseRestException
 */
public abstract class BaseRestBadRequestException extends BaseRestException {

    protected BaseRestBadRequestException(@NonNull final String message) {
        super(message);
    }

    protected BaseRestBadRequestException(@NonNull final String message, @Nullable final Throwable cause) {
        super(message, cause);
    }

    @Override
    @NonNull
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
