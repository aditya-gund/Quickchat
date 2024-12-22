package com.aditya.user;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    // Explicit constructor to replace @RequiredArgsConstructor
    public UserController(UserService userService) {
        this.userService = userService;
        System.out.println("UserController initialized with UserService.");
    }

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public User addUser(@Payload User user) {
        System.out.println("Received request to add user: " + user.getNickName());
        userService.saveUser(user);
        System.out.println("User added successfully: " + user.getNickName());
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public User disconnectUser(@Payload User user) {
        System.out.println("Received request to disconnect user: " + user.getNickName());
        userService.disconnect(user);
        System.out.println("User disconnected successfully: " + user.getNickName());
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers() {
        System.out.println("Received request to retrieve all connected users.");
        List<User> connectedUsers = userService.findConnectedUsers();
        System.out.println("Number of connected users retrieved: " + connectedUsers.size());
        connectedUsers.forEach(user -> 
            System.out.println("Connected user: " + user.getNickName())
        );
        return ResponseEntity.ok(connectedUsers);
    }
}
