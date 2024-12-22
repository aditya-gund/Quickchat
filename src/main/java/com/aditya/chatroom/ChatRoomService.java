package com.aditya.chatroom;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    public Optional<String> getChatRoomId(
            String senderId,
            String recipientId,
            boolean createNewRoomIfNotExists
    ) {
        System.out.println("Searching for chat room between senderId: " + senderId + " and recipientId: " + recipientId);

        // Search for an existing chat room
        Optional<String> chatRoomId = chatRoomRepository
                .findBySenderIdAndRecipientId(senderId, recipientId)
                .map(chatRoom -> {
                    System.out.println("Chat room found: " + chatRoom.getChatId());
                    return chatRoom.getChatId();
                });

        // If not found and createNewRoomIfNotExists is true
        if (chatRoomId.isEmpty() && createNewRoomIfNotExists) {
            System.out.println("No existing chat room found. Creating a new chat room...");
            String newChatId = createChatId(senderId, recipientId);
            System.out.println("New chat room created with chatId: " + newChatId);
            return Optional.of(newChatId);
        }

        // If not found and createNewRoomIfNotExists is false
        if (chatRoomId.isEmpty()) {
            System.out.println("No existing chat room found, and createNewRoomIfNotExists is false.");
        }

        return chatRoomId;
    }

    private String createChatId(String senderId, String recipientId) {
        String chatId = String.format("%s_%s", senderId, recipientId);
        System.out.println("Generated chatId: " + chatId);

        // Create the ChatRoom instances
        System.out.println("Creating chat room entries for both sender and recipient...");
        ChatRoom senderRecipient = new ChatRoom(chatId, senderId, recipientId);
        ChatRoom recipientSender = new ChatRoom(chatId, recipientId, senderId);

        // Save both entries to the repository
        System.out.println("Saving chat room for sender-recipient pair...");
        chatRoomRepository.save(senderRecipient);
        System.out.println("Chat room saved for sender: " + senderId + " and recipient: " + recipientId);

        System.out.println("Saving chat room for recipient-sender pair...");
        chatRoomRepository.save(recipientSender);
        System.out.println("Chat room saved for recipient: " + recipientId + " and sender: " + senderId);

        return chatId;
    }
}
