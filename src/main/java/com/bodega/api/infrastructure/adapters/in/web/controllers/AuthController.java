package com.bodega.api.infrastructure.adapters.in.web.controllers;

import com.bodega.api.infrastructure.adapters.in.web.configuracion.TokenService;
import com.bodega.api.infrastructure.adapters.in.web.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Valida credenciales contra la BD usando tu CustomUserDetailsService
        Authentication authentication = authenticationManager.authenticate(
                //authenticationManager empaqueta un objeto para validarlo  pero
                //tienes que asignar los datos correspondientes con los metodos get
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword())
        );

        // Genera y retorna el token JWT de 5 minutos
        return tokenService.generateToken(authentication);
    }


@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody UserDTO registerRequest) {
    // Aquí puedes procesar el registro con tu servicio o repositorio
    return ResponseEntity.ok("Usuario registrado exitosamente en la base de datos");
}

}


// DTO interno para recibir las credenciales
class LoginRequest {
    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}