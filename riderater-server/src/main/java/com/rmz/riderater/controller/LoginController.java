package com.rmz.riderater.controller;

import com.rmz.riderater.model.User;
import com.rmz.riderater.repository.UserRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
public class LoginController {

    private final UserRepo userRepo;
    private final HttpSessionRequestCache requestCache = new HttpSessionRequestCache();

    public LoginController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/loginSuccess")
    public void loginSuccess(@AuthenticationPrincipal OAuth2User principal, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String googleId = principal.getAttribute("sub");
        String username = principal.getAttribute("name");
        String email = principal.getAttribute("email");

        Optional<User> userOptional = userRepo.findByGoogleId(googleId);
        if (userOptional.isEmpty()) {
            User newUser = new User();
            newUser.setGoogleId(googleId);
            newUser.setUsername(username);
            newUser.setEmail(email);
            newUser.setRole("USER");
            userRepo.save(newUser);
        }

        response.sendRedirect("http://localhost:5174");
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "You have been logged out";
    }
}