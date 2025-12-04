import java.net.*;

public class MulticastServer {
    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket();
        String msg = "Hello from Multicast Server";

        InetAddress group = InetAddress.getByName("224.0.0.5"); // multicast group
        byte[] data = msg.getBytes();

        DatagramPacket dp = new DatagramPacket(data, data.length, group, 5000);
        ds.send(dp);

        System.out.println("Message sent to multicast group.");
        ds.close();
    }
}
