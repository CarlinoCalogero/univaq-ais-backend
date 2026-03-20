package it.univaq.aisbackend.controller;

import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorController {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ErrorController.class);

    public ErrorController() {
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleException(Exception e) {
        log.error("An error occured : " + e.getMessage());
        Map<String, Object> errorMap = new HashMap();
        errorMap.put("message", e.getMessage());
        errorMap.put("code", 500);
        errorMap.put("timestamp", Instant.now().toEpochMilli());
        return ResponseEntity.internalServerError().body(errorMap);
    }
}

