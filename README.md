# 🚀 Scalable One-on-One Chat Application with WebSockets and Spring Boot

Welcome to the **One-on-One Chat Application** built with **Java**, **Spring Boot**, **WebSockets**, and **PostgreSQL**. This project highlights the journey of developing a real-time chat system capable of handling scalable user interactions while ensuring message persistence and scalability.

## 🛠️ **Technologies Used**

- **Java**: Robust backend logic.
- **Spring Boot**: Simplified backend development and configuration.
- **WebSockets**: Real-time communication, enabling instant message exchange.
- **PostgreSQL**: Relational database for message storage and persistence.
- **JavaScript**: Frontend dynamics and user interaction with WebSocket.

## 💡 **Key Features & Functionalities**

- **Real-Time Messaging**: Leveraging WebSockets for seamless, low-latency, real-time communication between users.
- **Message Persistence**: Secure message storage using PostgreSQL, ensuring data reliability and easy message retrieval.
- **Scalability**: Designed to scale horizontally, allowing for efficient handling of multiple concurrent users.
- **User Presence Management**: Real-time tracking of online/offline users, enhancing user experience and chat interactivity.

---

## 🧠 **Technical Challenges & Solutions**

### 1. **Handling WebSocket Connections at Scale**
   - **Challenge**: WebSocket connections need to be managed efficiently to ensure real-time communication across multiple users.
   - **Solution**: A combination of session management techniques and **Spring’s WebSocket integration** was used to handle connections. For each new connection, user details are stored temporarily in the session, allowing for easy management of message broadcasts.

### 2. **Ensuring Persistent Data Storage**
   - **Challenge**: Storing chat messages reliably and retrieving them quickly when needed.
   - **Solution**: **PostgreSQL** was chosen for its relational model, providing structured storage of users and messages. Efficient querying ensured fast retrieval of historical chat data while maintaining the integrity of messages.

### 3. **Scalability of the Chat Application**
   - **Challenge**: The application needed to scale horizontally to accommodate a growing number of users.
   - **Solution**: **Load balancing and clustering** were considered in the architecture design. For the current iteration, horizontal scaling is achievable by adding additional WebSocket servers to distribute the load.

---

## 🏗️ **Architecture & Design**

The architecture of the chat application follows a **monolithic design** with a focus on **real-time communication** through WebSockets and **persistent data management** through PostgreSQL.

### Key Components:
- **WebSocket Configuration**: Handles bidirectional communication between the client and the server for real-time interaction.
- **PostgreSQL Database**: Stores user credentials, chat messages, and session data, ensuring durability.
- **Spring Boot Application**: Manages backend logic, including WebSocket sessions, user interaction, and message handling.
- **Frontend (JavaScript)**: Dynamically updates the UI based on messages and WebSocket events.

---

## 📚 **Learning Outcomes & Insights**

1. **Real-Time Communication with WebSockets**:
   - Understanding WebSocket’s ability to facilitate full-duplex communication was crucial. It allowed the system to send messages instantly to users, making it perfect for a chat application.
   - **Takeaway**: WebSocket provides an efficient and scalable method for real-time communication.

2. **Spring Boot's Power in Building Scalable Apps**:
   - Using Spring Boot simplified the backend development process with automatic configuration and built-in tools for managing REST APIs, WebSocket connections, and more.
   - **Takeaway**: Spring Boot accelerates development while providing robust and scalable solutions for complex architectures.

3. **PostgreSQL as a Reliable Data Store**:
   - PostgreSQL, as a relational database, was ideal for storing chat messages and user information. The database schema was designed to allow quick retrieval and efficient queries.
   - **Takeaway**: Relational databases like PostgreSQL are great for structured data storage and querying, especially in chat applications that require reliable message persistence.

4. **Message Broadcasting to Multiple Clients**:
   - Broadcasting messages to multiple connected users in real time was achieved using WebSocket’s `@SendTo` annotation in Spring Boot. It allows sending messages to all connected users or to specific clients.
   - **Takeaway**: Real-time broadcast can be seamlessly implemented using WebSocket and Spring Boot integration.

---

## 🌍 **Results and Impacts**

- **Real-Time Interaction**: The application provides users with an engaging chat experience where messages are delivered instantly, with no noticeable delay.
- **Scalable Infrastructure**: The system is built to scale horizontally, handling multiple concurrent users without compromising on performance.
- **Reliable Data Persistence**: All messages and user interactions are securely stored in PostgreSQL, ensuring that even after a user logs out or the system is restarted, no data is lost.

**USER INTERFACE TO ENTER IN CHATROOM**

![User_Login](https://github.com/user-attachments/assets/cb30cf26-8c0b-4090-8733-32597490c744)


**USER A**
![chat_app_1](https://github.com/user-attachments/assets/4a7eb727-4d9b-4451-ab8a-f193454f905e)

**USER B**
![chat_app_2](https://github.com/user-attachments/assets/05de5c31-7d06-4975-9c59-c9aaa705f387)


---

## 🚀 **Future Improvements & Next Steps**

1. **End-to-End Encryption (E2E)**:
   - To enhance security, **end-to-end encryption (E2E)** will be implemented to ensure that messages are encrypted on the sender's device and only decrypted on the recipient’s device. This will guarantee that no one, including the server, can read private conversations.
   
2. **Microservices Architecture**:
   - Breaking the monolithic architecture into microservices would improve maintainability, scalability, and ease of deployment.
   
3. **Message Queues for Scalability**:
   - Implementing message queues like **RabbitMQ** or **Kafka** will improve the ability to handle a high throughput of messages, ensuring that the system can manage spikes in traffic without compromising performance.

4. **Push Notifications**:
   - Adding **push notifications** to notify users of new messages when they are not actively using the chat application will improve user engagement and retention.

---

## 📌 **Conclusion**

This project helped me gain hands-on experience in **real-time communication**, **scalable backend architecture**, and **data persistence** using **WebSockets**, **Spring Boot**, and **PostgreSQL**. It provided an opportunity to dive deeper into backend development, understanding the challenges of building a system capable of handling large numbers of concurrent users and messages efficiently.

Feel free to fork this repository, open issues, or contribute to its growth!

---

## 🤝 **Contributions**

Open to contributions! If you find any issues or have suggestions for improvements, feel free to submit a **pull request** or open an **issue**.

---

### **Contact**

Aditya | [LinkedIn]([https://linkedin.com/in/aditya](https://www.linkedin.com/in/aditya-gund/)) | [GitHub]([https://github.com/aditya](https://github.com/aditya-gund))

---

### **Credits**

- Special thanks to the open-source community for providing great tools like Spring Boot, WebSockets, and PostgreSQL.

---

**Note**: Add screenshots or diagrams in the specified placeholders for a more visually appealing README. Make sure to update the URLs to match your repository's links and images.
