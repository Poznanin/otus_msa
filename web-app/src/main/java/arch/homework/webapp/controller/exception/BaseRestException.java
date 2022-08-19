package arch.homework.webapp.controller.exception;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

/**
 * Абстрактный базовый {@link RuntimeException}.
 * Необходимо наследовать данный exception и переопределить метод {@link #getStatus()}, обозначив возвращаемое
 * значение Http статуса сервиса при возникновении этой ошибки.
 *
 * @author Даниил Староверов
 */
public abstract class BaseRestException extends RuntimeException {

    protected BaseRestException(@NonNull final String message) {
        super(message);
    }

    protected BaseRestException(@NonNull final String message, @Nullable final Throwable cause) {
        super(message, cause);
    }

    @NonNull
    public abstract HttpStatus getStatus();
}
