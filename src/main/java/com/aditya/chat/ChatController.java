package com.aditya.chat;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;

    public ChatController(SimpMessagingTemplate messagingTemplate, ChatMessageService chatMessageService) {
        this.messagingTemplate = messagingTemplate;
        this.chatMessageService = chatMessageService;
    }

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {
        System.out.println("Received message payload: " + chatMessage);

        // Save the message
        System.out.println("Saving chat message...");
        ChatMessage savedMsg = chatMessageService.save(chatMessage);
        System.out.println("Message saved: " + savedMsg);

        // Create the notification
        System.out.println("Creating chat notification...");
        ChatNotification notification = new ChatNotification(
                savedMsg.getId(),
                savedMsg.getSenderId(),
                savedMsg.getRecipientId(),
                savedMsg.getContent()
        );
        System.out.println("Notification created: " + notification);

        // Send the notification to the recipient
        System.out.println("Sending notification to recipient: " + chatMessage.getRecipientId());
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(), "/queue/messages", notification
        );
        System.out.println("Notification sent successfully to recipient.");
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable String senderId,
                                                               @PathVariable String recipientId) {
        System.out.println("Retrieving chat messages for senderId: " + senderId + " and recipientId: " + recipientId);

        // Retrieve the chat messages for the given sender and recipient
        List<ChatMessage> messages = chatMessageService.findChatMessages(senderId, recipientId);
        System.out.println("Found chat messages: " + messages);

        return ResponseEntity.ok(messages);
    }
}
