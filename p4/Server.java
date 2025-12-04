    import java.net.*;
    import java.io.*;

    public class Server {
        public static void main(String[] args) throws Exception {
            ServerSocket ss = new ServerSocket(5000);
            System.out.print("Server Started...............");
            Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

            int n = Integer.parseInt(br.readLine());
            boolean prime = true;

            if (n <= 1)
                prime = false;
            for (int i = 2; i <= n / 2; i++)
                if (n % i == 0)
                    prime = false;

            pw.println(prime ? "Prime Number" : "Not Prime");

            s.close();
            ss.close();
        }
    }
