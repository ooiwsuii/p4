import java.net.*;

public class MulticastClient {
    public static void main(String[] args) throws Exception {

        InetAddress group = InetAddress.getByName("224.0.0.5");
        NetworkInterface ni = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());

        MulticastSocket ms = new MulticastSocket(5000);
        ms.joinGroup(new InetSocketAddress(group, 5000), ni);

        byte[] buf = new byte[200];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        System.out.println("Waiting for multicast message...");
        ms.receive(dp);

        System.out.println("Received: " + new String(dp.getData()).trim());

        ms.leaveGroup(new InetSocketAddress(group, 5000), ni);
        ms.close();
    }
}
