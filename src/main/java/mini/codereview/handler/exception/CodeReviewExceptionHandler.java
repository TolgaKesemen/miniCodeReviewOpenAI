package mini.codereview.handler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CodeReviewExceptionHandler {

    @ExceptionHandler(CoreReviewException.class)
    public ResponseEntity<String> handle(CoreReviewException ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body("LLM servisinde hata oluştu. message: " + ex.getMessage());
    }

}
