package com.aditya.chat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat_notification")
public class ChatNotification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_id", nullable = false)
    private String senderId;

    @Column(name = "recipient_id", nullable = false)
    private String recipientId;

    @Column(nullable = false)
    private String content;
    public ChatNotification(Long id, String senderId, String recipientId, String content) {
        this.id = id;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.content = content;
    }

}

