package com.fisunov_security.exception;
import lombok.Data;

import java.util.Date;

@Data
public class Apperror {

    private String message;

    private int statusCode;

    private Date timestamp;

    public Apperror(String message, int statusCode) {

        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = new Date();
    }

}
