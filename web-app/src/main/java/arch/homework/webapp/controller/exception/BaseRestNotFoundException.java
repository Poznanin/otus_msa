package arch.homework.webapp.controller.exception;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

/**
 * Базовый NotFoundException.
 *
 * @author Даниил Староверов
 * @see BaseRestException
 */
public abstract class BaseRestNotFoundException extends BaseRestException {

    protected BaseRestNotFoundException(@NonNull final String message) {
        super(message);
    }

    protected BaseRestNotFoundException(@NonNull final String message, @Nullable final Throwable cause) {
        super(message, cause);
    }

    @Override
    @NonNull
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
