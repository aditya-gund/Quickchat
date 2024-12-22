package com.aditya.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    // Explicit constructor to replace Lombok's @RequiredArgsConstructor
    public UserService(UserRepository repository) {
        this.repository = repository;
        System.out.println("UserService initialized with UserRepository.");
    }

    public void saveUser(User user) {
        System.out.println("Attempting to save user with nickname: " + user.getNickName());
        user.setStatus(Status.ONLINE);
        System.out.println("Setting user status to ONLINE for user: " + user.getNickName());
        repository.save(user);
        System.out.println("User saved successfully: " + user);
    }

    public void disconnect(User user) {
        System.out.println("Attempting to disconnect user with nickname: " + user.getNickName());
        
        // Use findByNickName instead of findById
        User storedUser = repository.findByNickName(user.getNickName()).orElse(null);
        if (storedUser != null) {
            System.out.println("User found in the repository: " + storedUser.getNickName());
            storedUser.setStatus(Status.OFFLINE);
            System.out.println("Setting user status to OFFLINE for user: " + storedUser.getNickName());
            repository.save(storedUser);
            System.out.println("User disconnected and status updated successfully: " + storedUser);
        } else {
            System.out.println("No user found with nickname: " + user.getNickName());
        }
    }

    public List<User> findConnectedUsers() {
        System.out.println("Retrieving all users with status: ONLINE");
        List<User> connectedUsers = repository.findAllByStatus(Status.ONLINE);
        System.out.println("Number of connected users found: " + connectedUsers.size());
        connectedUsers.forEach(user -> 
            System.out.println("Connected user: " + user.getNickName())
        );
        return connectedUsers;
    }
}
