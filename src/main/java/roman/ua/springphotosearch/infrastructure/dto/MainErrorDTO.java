package roman.ua.springphotosearch.infrastructure.dto;

import roman.ua.springphotosearch.domain.NotAllowedContentTypeException;

import javax.validation.constraints.NotNull;

public class  MainErrorDTO {

    String code;
    @NotNull String message;

    public MainErrorDTO(String code, @NotNull String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void Object(Throwable throwable) {
        if (throwable.equals(NotAllowedContentTypeException.class)) {
            new MainErrorDTO(
            throwable.getMessage(),
            "Uploaded content should be an image!");
        }
        else new MainErrorDTO(
           "SERVER ERROR",
        "SERVER_ERROR_FIX_SOMETHING");
    }
}

