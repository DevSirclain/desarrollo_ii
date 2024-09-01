package cl.rodrigo.epe.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UtilityNotFoundException extends RuntimeException{

    public UtilityNotFoundException(String x) {
        super(x);
    }
}
