package se.iths.grocerylistgenerator.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable (
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info(ex.getClass().getName());
        String errorMessage = "Malformed JSON request.";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, errorMessage, ex));
    }


//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
//        logger.info(ex.getClass().getName());
//        logger.error("Error: ", ex);
//        String errorMessage = "An unexpected error occured.";
//
//        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage, ex));
//    }


    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException ex){
        logger.info(ex.getClass().getName());
        String errorMessage = "Entity not found.";

        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, errorMessage, ex));

    }

    @ExceptionHandler({UnauthorizedException.class, AccessDeniedException.class})
    public ResponseEntity<Object> unauthorizedException(UnauthorizedException ex){
        logger.info(ex.getClass().getName());
        String errorMessage = "You are unauthorized!";

        return buildResponseEntity(new ApiError(HttpStatus.UNAUTHORIZED, errorMessage, ex));
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> badRequestException(BadRequestException ex){
        logger.info(ex.getClass().getName());
        String errorMessage = "Server can not process the request!";

        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, errorMessage, ex));
    }







}