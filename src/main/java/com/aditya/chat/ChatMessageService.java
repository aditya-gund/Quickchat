package com.aditya.chat;

import org.springframework.stereotype.Service;
import com.aditya.chatroom.ChatRoomService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageService {
    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;

    // Constructor for dependency injection
    public ChatMessageService(ChatMessageRepository repository, ChatRoomService chatRoomService) {
        this.repository = repository;
        this.chatRoomService = chatRoomService;
    }

    // Save method for ChatMessage
    public ChatMessage save(ChatMessage chatMessage) {
        System.out.println("Starting save operation for ChatMessage: " + chatMessage);

        var chatId = chatRoomService
                .getChatRoomId(chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow(() -> {
                    System.out.println("Failed to find Chat Room ID for senderId: " 
                        + chatMessage.getSenderId() + " and recipientId: " + chatMessage.getRecipientId());
                    return new RuntimeException("Chat room ID not found");
                });

        System.out.println("Chat Room ID found: " + chatId);

        chatMessage.setChatId(chatId);
        ChatMessage savedMessage = repository.save(chatMessage);

        System.out.println("ChatMessage saved successfully: " + savedMessage);
        return savedMessage;
    }

    // Method to find chat messages by senderId and recipientId
    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        System.out.println("Finding chat messages for senderId: " + senderId + " and recipientId: " + recipientId);

        var chatId = chatRoomService.getChatRoomId(senderId, recipientId, false);

        if (chatId.isPresent()) {
            System.out.println("Chat Room ID found: " + chatId.get());
            List<ChatMessage> messages = repository.findByChatId(chatId.get());
            System.out.println("Messages found: " + messages);
            return messages;
        } else {
            System.out.println("No Chat Room ID found for senderId: " + senderId + " and recipientId: " + recipientId);
            return new ArrayList<>();
        }
    }
}
