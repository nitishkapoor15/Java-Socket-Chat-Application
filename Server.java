import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

class Server{

    ServerSocket server;
    Socket socket;

    BufferedReader br;
    PrintWriter out;

    // Constructor
    public Server() {
        try {
            server = new ServerSocket(7777); // Create server on port 7777
            System.out.println("Server is ready to accept Connection");
            System.out.println("---------------Chat end : exit---------------------- ");
            System.out.println("waiting...");
            socket = server.accept();     // Wait for a client to connect
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            startReading(); // method to call
            startWriting(); // method to call

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /* ----------------------------------------------------------------- */
    public void startReading() {
        // thread is used to read data from the server
        Runnable r1 = () -> {

            System.out.println("reader started..");
            try {
                while (true) {

                    String msg = br.readLine(); // read a line
                    if (msg.equals("exit")) {

                        System.out.println("Client terminated the chat");
                        socket.close();
                        break; // terminate the loop
                    }
                    System.out.println("Server : " + msg);
                }
            } catch (Exception e) {
                // e.getStackTrace();
                System.out.println("Connection is Closed");
            }

        };
        new Thread(r1).start(); // call the thread

    }

    /* ----------------------------------------------------------------- */
    public void startWriting() {
        // thread is used o print data
        Runnable r2 = () -> {
            System.out.println("writer started..");
            try {
                while (!socket.isClosed()) {

                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in)); // to take input from the
                                                                                               // // console
                    String content = br1.readLine(); // to read a line

                    out.println(content);
                    out.flush();

                    if (content.equals("exit")) {
                        socket.close();
                        break;
                    }

                }
               

            } catch (Exception e) {
                System.out.println("Connection is Closed");
           
            }

        };

        // call the thread

        new Thread(r2).start();

    }
    /* ----------------------------------------------------------------- */

    public static void main(String[] args) {
        System.out.println("This is server...going to start server");

        // call the object
       new Server();

    }
}


