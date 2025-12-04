import java.net.*;

public class CalcServer {
    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket(5000);

        byte[] buf = new byte[200];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        ds.receive(dp); // receive 2 numbers

        String received = new String(dp.getData()).trim();
        String[] parts = received.split(" ");

        int n1 = Integer.parseInt(parts[0]);
        int n2 = Integer.parseInt(parts[1]);

        int add = n1 + n2;
        int sub = n1 - n2;
        int mul = n1 * n2;
        String div = (n2 != 0) ? String.valueOf((double) n1 / n2) : "Undefined";

        String result = "Add = " + add +
                " | Sub = " + sub +
                " | Mul = " + mul +
                " | Div = " + div;

        byte[] sendData = result.getBytes();

        DatagramPacket reply = new DatagramPacket(
                sendData, sendData.length,
                dp.getAddress(), dp.getPort());

        ds.send(reply);
        ds.close();
    }
}
