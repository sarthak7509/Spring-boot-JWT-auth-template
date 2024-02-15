package com.sarthak.JWTAuth.Service;

import com.sarthak.JWTAuth.Domain.Dao.AuthenticationRequest;
import com.sarthak.JWTAuth.Domain.Dao.AutheticationResponse;
import com.sarthak.JWTAuth.Domain.Dao.RegisterRequest;
import com.sarthak.JWTAuth.Domain.Roles.Role;
import com.sarthak.JWTAuth.Domain.User;
import com.sarthak.JWTAuth.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    public AutheticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .role(Role.User)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AutheticationResponse.builder().token(jwtToken).build();
    }

    public AutheticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AutheticationResponse.builder().token(jwtToken).build();
    }
}
