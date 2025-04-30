# 🧑‍💻 Java Socket Chat Application

This is a **simple two-way chat application** built using **Java Sockets**.
It demonstrates basic networking concepts including `ServerSocket`, `Socket`, `InputStream`, `OutputStream`, and multi-threading for concurrent message handling.

## 📌 Features

- Server and client communication via TCP/IP
- Bi-directional real-time chat
- Multi-threaded design for asynchronous message handling
- Console-based interface
- Graceful exit handling via keyword (`exit`)

## 🚀 How It Works

### 📡 Server
- Listens on port `7777`
- Accepts incoming client connections
- Starts separate threads for **reading** and **writing** messages

### 💬 Client
- Connects to `localhost:7777`
- Sends and receives messages in real time
- Uses separate threads for input/output

## 🛠️ Technologies Used

- Java (JDK 8 or above)
- Core Java Libraries: `java.net`, `java.io`, `java.util`
- Threads for concurrency

## 🧾 How to Run

1. Clone or download this repository.
2. Open the project in your Java IDE (like Eclipse or IntelliJ).
3. Compile and run `Server.java`.
4. In a separate console or terminal, compile and run `Client.java`.
5. Start chatting!

### ⚠️ Note:
- The server must be running **before** the client starts.
- Use `exit` to terminate the chat from either side.


## 📚 Learning Outcome

- Understanding of Java networking using sockets
- Implementing multi-threading in Java
- Handling I/O streams and real-time data transfer

## 📦 Project Status

✅ Completed — Ready to demonstrate basic Java socket communication.

## 📝 License

This project is open-source and free to use.

---

