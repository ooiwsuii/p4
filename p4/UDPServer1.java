import java.net.*;

public class UDPServer1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] buf = new byte[100];

        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        ds.receive(dp); // receive number

        String numStr = new String(dp.getData()).trim();
        int n = Integer.parseInt(numStr);

        // factorial logic (simple)
        int fact = 1;
        for (int i = 1; i <= n; i++)
            fact *= i;

        byte[] result = String.valueOf(fact).getBytes();

        DatagramPacket reply = new DatagramPacket(
                result, result.length,
                dp.getAddress(), dp.getPort());

        ds.send(reply); // send factorial
        ds.close();
    }
}
