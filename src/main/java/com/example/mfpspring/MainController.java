package com.example.mfpspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
//    private List<User> users = new ArrayList<>();
@Autowired
    private UserRepository userRepository;
    @GetMapping(path="/users")
    public List<User> getUsers(){
//        User user = new User();
//        user.setId(1L);
//        user.setName("Egor");
//        users.add(user);
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
//        user.setId(10L);
//        users.add(user);
        return userRepository.save(user);
    }
}
