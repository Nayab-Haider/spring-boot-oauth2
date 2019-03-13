package com.oauth.example.oauth.controller;

import com.oauth.example.oauth.util.LoginDTO;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authenticate")
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        return null;

    }
}
