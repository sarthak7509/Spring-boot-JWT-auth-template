package com.sarthak.JWTAuth.Controllers.errors;

public class UserAleradyExist extends RuntimeException{
    public UserAleradyExist(String message) {
        super(message);
    }

    public UserAleradyExist(String message, Throwable cause) {
        super(message, cause);
    }
}
