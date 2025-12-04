
import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a number: ");
        String num = br.readLine();

        byte[] data = num.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");

        DatagramPacket dp = new DatagramPacket(data, data.length, ip, 5000);
        ds.send(dp); // send number

        byte[] buf = new byte[100];
        DatagramPacket reply = new DatagramPacket(buf, buf.length);
        ds.receive(reply); // receive result

        System.out.println("Result: " + new String(reply.getData()).trim());
        ds.close();
    }
}
