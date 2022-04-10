package com.neo.sihotel.controller;

import com.neo.sihotel.dto.UserDto;
import com.neo.sihotel.model.User;
import com.neo.sihotel.repository.UserRepository;
import com.neo.sihotel.service.implement.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;


    @Autowired
    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/account")
    public String account(Model model, String keyword){
        List<User> users = null;
        if (keyword != null) {
            users = userRepository.findByKeyword(keyword);
        }else{
            users = (List<User>) userRepository.findAll();
        }

        model.addAttribute("accounts", users);

        return "acount";
    }
    @GetMapping("/updateuser/{id}")
    public String UpdateEmploy(@PathVariable(value = "id") int id, Model model) {
        // get employe form service
        User user = userService.getUserById(id);

        //set employe as a model attribut to  pre-populate the form
        model.addAttribute("user", user);

        return "register";
    }

    @GetMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable(value = "id") int id) {
        userRepository.deleteById(id);

        return "redirect:/account";
    }
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserDto userDto) {

        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAdmin(userDto.getAdmin());
        userRepository.save(user);


        return "redirect:/account";
    }
    @PostMapping("/saveregister")
    public String saveRegister(@ModelAttribute("user") User userDto) {

        if (userDto.getId()!=null){
            User model = userService.getUserById(userDto.getId());
            model.setName(userDto.getName());
            model.setEmail(userDto.getEmail());
            model.setPassword(passwordEncoder.encode(userDto.getPassword()));
            model.setAdmin(userDto.getAdmin());
            userRepository.save(model);
        }else{
            User user = new User();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setAdmin(userDto.getAdmin());
            userRepository.save(user);
        }

        return "redirect:/account";
    }
}
