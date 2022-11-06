package com.PP.watchBandStore.controllers;


import com.PP.watchBandStore.beans.User;
import com.PP.watchBandStore.dto.LoginResDto;
import com.PP.watchBandStore.exceptions.SecurityException;
import com.PP.watchBandStore.services.WelcomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api/welcome/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class WellcomeController {
private final WelcomeService welcomeService;
    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(User user) throws SecurityException {
        welcomeService.register(user);
    }

    @PostMapping("login")
    public LoginResDto login(@Valid @RequestBody User user) throws SecurityException {
        String email = user.getEmail();
        String password = user.getPassword();
        UUID token = welcomeService.login(email, password);
        return new LoginResDto(email, token);
    }
}
