package com.sarthak.JWTAuth.Controllers.auth;

import com.sarthak.JWTAuth.Domain.Dao.AuthenticationRequest;
import com.sarthak.JWTAuth.Domain.Dao.AutheticationResponse;
import com.sarthak.JWTAuth.Domain.Dao.RegisterRequest;
import com.sarthak.JWTAuth.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private  final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AutheticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        //
        return ResponseEntity.ok(service.register(request));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AutheticationResponse> register(
            @RequestBody AuthenticationRequest request
    ){
        //
        return ResponseEntity.ok(service.authenticate(request));

    }
}
