package com.example.restapi.exception;

import com.example.core.payload.GenericResponse;
import com.example.domain.exception.AlreadyExistsException;
import com.example.domain.exception.BaseException;
import com.example.domain.exception.NotFoundException;
import com.example.domain.service.interfaces.i18n.II18nMessageService;
import com.example.domain.util.constants.I18nConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final II18nMessageService messageService;

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<GenericResponse<Object>> handleAuthenticationException(AuthenticationException exception) {
        //log.error(); necessary log message here
        String errorMessage = messageService
                .getMessage(I18nConstants.LOGIN_BAD_CREDENTIALS, LocaleContextHolder.getLocale());
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(GenericResponse.builder()
                        .success(false)
                        .message(errorMessage)
                        .build());
    }

    @ExceptionHandler({Throwable.class})
    public ResponseEntity<GenericResponse<Object>> handleGenericException(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        String errorMessage = messageService
                .getMessage(I18nConstants.GLOBAL_UNHANDLED_ERROR, LocaleContextHolder.getLocale());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericResponse
                        .builder()
                        .success(false)
                        .message(errorMessage)
                        .build());
    }

    @ExceptionHandler({AlreadyExistsException.class})
    public ResponseEntity<GenericResponse<Object>> handleAlreadyExistsException(AlreadyExistsException exception) {
       // log.error(); necessary log message here
        String errorMessage = messageService
                .getMessage(exception.getMessage(), LocaleContextHolder.getLocale());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericResponse.builder()
                        .success(false)
                        .message(errorMessage)
                        .data(exception.getErrorCode())
                        .build()
                );
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<GenericResponse<Object>> handleNotFoundException(NotFoundException exception) {
        // log.error(); necessary log message here
        String errorMessage = messageService
                .getMessage(exception.getMessage(), LocaleContextHolder.getLocale());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericResponse.builder()
                        .success(false)
                        .message(errorMessage)
                        .data(exception.getErrorCode())
                        .build()
                );
    }

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<GenericResponse<Object>> handleBaseException(BaseException exception) {
        // log.error(); necessary log message here
        String errorMessage = messageService.getMessage(exception.getMessage()
                , LocaleContextHolder.getLocale()
                , exception.getArgs());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(GenericResponse.builder()
                        .success(false)
                        .message(errorMessage)
                        .data(exception.getErrorCode())
                        .build()
                );
    }

}
