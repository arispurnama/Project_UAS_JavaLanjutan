package com.neo.sihotel.controller;

import com.neo.sihotel.dto.LoginDto;
import com.neo.sihotel.dto.UserDto;
import com.neo.sihotel.repository.UserRepository;
import com.neo.sihotel.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {

    @Autowired
    UserService userService;

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;


    @Autowired
    public Index(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login", new LoginDto());

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("login") LoginDto loginDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
            return "redirect:/dashboard";
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            return "redirect:/login";
        }
    }

//    @GetMapping("/register")
//    public String showRegisterForm(Model model) {
//        model.addAttribute("user", new UserDto());
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String register(@ModelAttribute("user") UserDto userDto) {
//
//            User user = new User();
//            user.setName(userDto.getName());
//            user.setEmail(userDto.getEmail());
//            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//            user.setAdmin(userDto.getAdmin());
//            userRepository.save(user);
//
//
//        return "redirect:/account";
//    }
//    @PostMapping("/saveregister")
//    public String saveRegister(@ModelAttribute("user") User userDto) {
//
//        if (userDto.getId()!=null){
//            User model = userService.getUserById(userDto.getId());
//            model.setName(userDto.getName());
//            model.setEmail(userDto.getEmail());
//            model.setPassword(passwordEncoder.encode(userDto.getPassword()));
//            model.setAdmin(userDto.getAdmin());
//            userRepository.save(model);
//        }else{
//            User user = new User();
//            user.setName(userDto.getName());
//            user.setEmail(userDto.getEmail());
//            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//            user.setAdmin(userDto.getAdmin());
//            userRepository.save(user);
//        }
//
//        return "redirect:/account";
//    }
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
