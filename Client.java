import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;




public class Client {
    Socket socket;

    BufferedReader br;
    PrintWriter out;


    public Client(){
        try{
   System.out.println("Sending request to Server");
   socket = new Socket("127.0.0.1",7777);
          System.out.println("---------------Chat end : exit---------------------- ");

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
                    System.out.println("Client : " + msg);
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
        System.out.println("This is a Client...");
        new Client();
    }
    
}
