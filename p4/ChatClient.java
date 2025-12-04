import java.net.*;
import java.io.*;

public class ChatClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String recv = in.readLine(); // receive from server
            System.out.println("Server: " + recv);

            System.out.print("Client: ");
            String send = kb.readLine();
            out.println(send); // send to server

            if (send.equals("exit") || recv.equals("exit"))
                break;
        }

        s.close();
    }
}
