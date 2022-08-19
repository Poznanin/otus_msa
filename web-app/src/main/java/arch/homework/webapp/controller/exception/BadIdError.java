package arch.homework.webapp.controller.exception;

import lombok.Getter;
import lombok.NonNull;

/**
 * Неверный формат идентификатора (не GUID).
 *
 * @author Сергей Новиков
 */
@Getter
public class BadIdError extends BaseRestBadRequestException {
    /**
     * Неверный текст.
     */
    @NonNull
    private final String badId;

    /**
     * Конструктор.
     *
     * @param badId   неверный текст
     * @param message сообщение
     */
    public BadIdError(@NonNull final String badId, @NonNull final String message) {
        super(message);
        this.badId = badId;
    }

    /**
     * Конструктор.
     *
     * @param badId   неверный текст
     * @param message сообщение
     * @param cause   причина ошибки
     */
    public BadIdError(@NonNull final String badId, @NonNull final String message, @NonNull final Throwable cause) {
        super(message, cause);
        this.badId = badId;
    }
}
