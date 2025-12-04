import java.rmi.server.UnicastRemoteObject;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class DigitToWordServer extends UnicastRemoteObject implements DigitToWordInterface {

    protected DigitToWordServer() throws RemoteException {
        super();
    }

    @Override
    public String convertToWords(String number) throws RemoteException {
        String[] words = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        StringBuilder sb = new StringBuilder();

        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(words[c - '0']).append(" ");
            } else {
                sb.append("? "); // for any non-digit character
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        try {
            DigitToWordServer obj = new DigitToWordServer();
            Naming.rebind("rmi://localhost:1099/DigitToWordService", obj);
            System.out.println("DigitToWord RMI Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
