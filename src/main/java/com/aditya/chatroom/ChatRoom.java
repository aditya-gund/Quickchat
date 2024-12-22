package com.aditya.chatroom;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chat_room")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chat_id", nullable = false)
    private String chatId;

    @Column(name = "sender_id", nullable = false)
    private String senderId;

    @Column(name = "recipient_id", nullable = false)
    private String recipientId;
    // Default constructor
    public ChatRoom() {
    }
    // Constructor to allow creation of ChatRoom without @Builder
    public ChatRoom(String chatId, String senderId, String recipientId) {
        this.chatId = chatId;
        this.senderId = senderId;
        this.recipientId = recipientId;
    }
    public String getChatId() {
        return chatId;
    }

}
