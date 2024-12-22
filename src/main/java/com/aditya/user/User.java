package com.aditya.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Setting the table name as "users"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use PostgreSQL ID generation strategy
    private Long id;

    @Column(nullable = false, unique = true) // Ensures nickname is unique
    private String nickName; // Assuming nickName is a unique field (non-primary key)

    @Enumerated(EnumType.STRING) // Enum values are stored as strings in the database
    @Column(nullable = false)
    private Status status;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
