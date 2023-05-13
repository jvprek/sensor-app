package com.example.sensorapp.rest;

import com.example.sensorapp.db.repository.SensorRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorAppAPI {


//
//
//    // Endpoint to retrieve all users
//    @GetMapping("/senso")
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    // Endpoint to create a new user
//    @PostMapping("/users")
//    public User createUser(@RequestBody User user) {
//        return userRepository.save(user);
//    }
//
//    // Endpoint to update an existing user
//    @PutMapping("/users/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("User not found"));
//
//        user.setName(updatedUser.getName());
//        user.setEmail(updatedUser.getEmail());
//
//        return userRepository.save(user);
//    }
//
//    // Endpoint to delete a user
//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
//        userRepository.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
}
