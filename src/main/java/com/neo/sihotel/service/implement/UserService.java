package com.neo.sihotel.service.implement;

import com.neo.sihotel.model.Employee;
import com.neo.sihotel.repository.UserRepository;
import com.neo.sihotel.dto.UserDto;
import com.neo.sihotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    UserRepository userRepository;



    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getSemuaUser() {
        List<User> daftarAkun = (List<User>) userRepository.findAll();
        List<UserDto> daftarAkunDto = new ArrayList<>();
        for (User akun : daftarAkun) {
            UserDto akunDto = new UserDto();
            akunDto.setName(akunDto.getName());
            akunDto.setEmail(akunDto.getEmail());
            akunDto.setPassword(akunDto.getPassword());
            daftarAkunDto.add(akunDto);
        }
        return daftarAkunDto;
    }

    public User getUserById(int id) {
        Optional<User> optionalEmployee = userRepository.findById(id);
        User user = null;
        if (optionalEmployee.isPresent()){
            user = optionalEmployee.get();
        }else{
            throw new RuntimeException("Employed is not found");
        }
        return user;
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }
}
