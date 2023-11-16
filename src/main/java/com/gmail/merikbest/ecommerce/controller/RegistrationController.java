package com.gmail.merikbest.ecommerce.controller;

import com.gmail.merikbest.ecommerce.dto.RegistrationRequest;
import com.gmail.merikbest.ecommerce.mapper.AuthenticationMapper;;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.gmail.merikbest.ecommerce.constants.PathConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_REGISTRATION)
public class RegistrationController {

    private final AuthenticationMapper authenticationMapper;

    @PostMapping
    public ResponseEntity<String > registration(@Valid @RequestBody RegistrationRequest user, BindingResult bindingResult) {
        return ResponseEntity.ok(authenticationMapper.registerUser(user.getCaptcha(),user, bindingResult ));
    }

    @GetMapping(ACTIVATE_CODE)
    public ResponseEntity<String > activateEmailCode(@PathVariable String code) {
        return ResponseEntity.ok(authenticationMapper.activateUser(code));
    }
}
