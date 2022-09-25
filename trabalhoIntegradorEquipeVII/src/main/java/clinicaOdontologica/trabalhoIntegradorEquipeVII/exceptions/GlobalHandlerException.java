package clinicaOdontologica.trabalhoIntegradorEquipeVII.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ProcessErrorException.class)
    public ResponseEntity<ResponseException> handlerProcessErrorException(ProcessErrorException exception) {
        ResponseException responseException = new ResponseException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseException> handlerResourceNotFoundException(ResourceNotFoundException exception) {
        ResponseException responseException = new ResponseException(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(responseException, HttpStatus.NOT_FOUND);
    }
}
