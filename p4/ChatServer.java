import java.net.*;
import java.io.*;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Server: ");
            String send = kb.readLine();
            out.println(send); // send to client

            String recv = in.readLine(); // receive from client
            System.out.println("Client: " + recv);

            if (send.equals("exit") || recv.equals("exit"))
                break;
        }

        s.close();
        ss.close();
    }
}
