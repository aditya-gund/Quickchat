package com.aditya.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNickName(String nickName); // Method to find user by nickName
    List<User> findAllByStatus(Status status); // Method to find users by status
}
