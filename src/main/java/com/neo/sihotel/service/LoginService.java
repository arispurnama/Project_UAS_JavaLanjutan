package com.neo.sihotel.service;

import com.neo.sihotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    private UserRepository userRepository;
    private UserService userService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public LoginService(UserRepository userRepository, UserService userService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    public ResponseEntity<Map<String, String>> login(HttpServletRequest request, String id, String kataSandi) {

        Map<String, String> hasil = new HashMap<>();

        if (userRepository.findById(id).isPresent()) {
            try {
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(id, kataSandi);
                Authentication otentikasi = authenticationManager.authenticate(token);
                SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(otentikasi);
                HttpSession session = request.getSession(true);
                session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
                hasil.put("pesan", "Login berhasil, silakan tunggu.");
                return ResponseEntity.ok(hasil);
            } catch (BadCredentialsException badCredentialsException) {
                hasil.put("pesan", "Kata sandi salah.");
                return ResponseEntity.badRequest().body(hasil);
            }
        } else {
            hasil.put("pesan", "Akun tidak ditemukan.");
            return ResponseEntity.badRequest().body(hasil);
        }
    }
}
