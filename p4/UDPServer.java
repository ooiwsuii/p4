import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(5000);
        byte[] buf = new byte[100];

        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        ds.receive(dp); // receive number

        String numStr = new String(dp.getData()).trim();
        int n = Integer.parseInt(numStr);

        String result = (n % 2 == 0) ? "Even Number" : "Odd Number";
        byte[] sendData = result.getBytes();

        DatagramPacket send = new DatagramPacket(
                sendData, sendData.length,
                dp.getAddress(), dp.getPort());

        ds.send(send); // send result
        ds.close();
    }
}
