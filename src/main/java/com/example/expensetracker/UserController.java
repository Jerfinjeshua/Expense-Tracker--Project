package com.example.expensetracker;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Add this line to allow requests from your frontend

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User registerUser(@RequestBody User user) {
        System.out.println("Received POST request to register user: " );
        return userService.registerUser(user);
    }

    //@GetMapping("/{username}")
    //public User getUserByUsername(@PathVariable String username) {
      //  return userService.findByUsername(username).orElse(null);
       
    //}
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        System.out.println("Received GET request for username: " + username);

        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get()); // Return the user with status 200
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if user is not found
        }
    }
    

}
