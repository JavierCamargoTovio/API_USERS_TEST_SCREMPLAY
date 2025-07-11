package co.com.test.users.util.enums;
/**
 * Listado de los códigos de estado HTTP mapeados para las respuestas de la api
 */
public enum HttpStatusCodes {
    OK(200),
    CREATED(201),
    DELETE(204),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    INTERNAL_SERVER_ERROR(500);
    private final int httpStatusCode;

    HttpStatusCodes(int code) {
        this.httpStatusCode = code;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }
}
