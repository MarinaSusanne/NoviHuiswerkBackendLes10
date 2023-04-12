package com.example.Huiswerkles10backend.Controllers;

import com.example.Huiswerkles10backend.dtos.input.AuthenticationRequest;
import com.example.Huiswerkles10backend.dtos.input.AuthenticationResponse;
import com.example.Huiswerkles10backend.filter.JwtRequestFilter;
import com.example.Huiswerkles10backend.services.CustomUserDetailsService;
import com.example.Huiswerkles10backend.utils.JwtUtil;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
public class AuthenticationController {

    /*inject authentionManager, userDetailService en jwtUtil*/

private final AuthenticationManager authenticationManager;

private final CustomUserDetailsService userDetailsService;

private final JwtUtil jwtUtil;

public AuthenticationController(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
}


    /*
         Deze methode geeft de principal (basis user gegevens) terug van de ingelogde gebruiker
     */
    @GetMapping(value = "/authenticated")
    public ResponseEntity<Object> authenticated(Authentication authentication, Principal principal) {
        //Principal.getname();
        return ResponseEntity.ok().body(principal);
    }
        /// kun je gewoon een get methode doen /authenticated en dan voeg je je tokens toe en dan geen body en geeft het je een Principal terug met info

    /*
    Deze methode geeft het JWT token terug wanneer de gebruiker de juiste inloggegevens op geeft.
     */

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        }
        catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password", ex);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}