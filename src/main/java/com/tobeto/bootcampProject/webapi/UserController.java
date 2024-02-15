package com.tobeto.bootcampProject.webapi;

import com.tobeto.bootcampProject.dataacces.UserRepository;
import com.tobeto.bootcampProject.entities.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {this.userRepository = userRepository;}

    @RequestMapping("/getall")
    public List<User> findAll()  {
        return userRepository.findAll();
    }

    @RequestMapping("/add3")
    public void add() {
        User user = new User();
        user.setUsername("handenurduran");
        user.setEmail("handenurduran@gmail.com");
        userRepository.save(user);
    }
}
