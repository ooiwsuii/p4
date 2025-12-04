import java.net.*;
import java.io.*;

public class CalcClient {
    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter first number: ");
        String n1 = br.readLine();

        System.out.print("Enter second number: ");
        String n2 = br.readLine();

        String message = n1 + " " + n2;
        byte[] data = message.getBytes();

        InetAddress ip = InetAddress.getByName("localhost");

        DatagramPacket dp = new DatagramPacket(data, data.length, ip, 5000);
        ds.send(dp); // send two numbers

        byte[] buf = new byte[200];
        DatagramPacket reply = new DatagramPacket(buf, buf.length);
        ds.receive(reply);

        System.out.println("\nResults:\n" + new String(reply.getData()).trim());

        ds.close();
    }
}
