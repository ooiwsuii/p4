import java.net.*;

public class MathServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(6000);
        byte[] buf = new byte[100];

        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        ds.receive(dp); // receive number

        String numStr = new String(dp.getData()).trim();
        double n = Double.parseDouble(numStr);

        double sq = n * n;
        double sqrt = Math.sqrt(n);
        double cube = n * n * n;
        double cbr = Math.cbrt(n);

        String result = "Square=" + sq +
                " Sqrt=" + sqrt +
                " Cube=" + cube +
                " CubeRoot=" + cbr;

        byte[] sendData = result.getBytes();

        DatagramPacket reply = new DatagramPacket(
                sendData, sendData.length,
                dp.getAddress(), dp.getPort());

        ds.send(reply); // send all results
        ds.close();
    }
}
