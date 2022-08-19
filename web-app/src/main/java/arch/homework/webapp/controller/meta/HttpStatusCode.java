package arch.homework.webapp.controller.meta;

/**
 * Строковые константы кодов HTTP-статусов.
 *
 * @author Иван Стрельцов
 */
public final class HttpStatusCode {
    // 2xx Успех
    public static final String OK_CODE = "200";
    public static final String NO_CONTENT = "204";

    // 4xx Ошибки клиента
    public static final String BAD_REQUEST_CODE = "400";

    public static final String FORBIDDEN_CODE = "403";

    public static final String NOT_FOUND_CODE = "404";

    // 5xx Ошибки сервера
    public static final String INTERNAL_SERVER_ERROR_CODE = "500";

    private HttpStatusCode() {
    }

}
