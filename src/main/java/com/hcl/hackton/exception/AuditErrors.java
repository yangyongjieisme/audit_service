package com.hcl.hackton.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;
@AllArgsConstructor
public class AuditErrors {

    private HttpStatus status;
    private String message;
    private Map<String, String> errors;
}

