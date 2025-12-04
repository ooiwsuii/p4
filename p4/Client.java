import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        System.out.print("Enter a number: ");
        pw.println(br.readLine());

        System.out.println("Result: " + in.readLine());

        s.close();
    }
}
