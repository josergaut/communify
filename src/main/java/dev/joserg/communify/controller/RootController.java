package dev.joserg.communify.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RootController {

    @GetMapping("/public")
    public JwtAuthenticationToken publicResource(JwtAuthenticationToken jwtAuthenticationToken) {
        return jwtAuthenticationToken;
    }

    @GetMapping("/private")
    @PreAuthorize("hasAuthority('SCOPE_Root.Private')")
    public JwtAuthenticationToken privateResource(JwtAuthenticationToken jwtAuthenticationToken) {
        return jwtAuthenticationToken;
    }
}
