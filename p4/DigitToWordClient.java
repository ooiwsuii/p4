import java.rmi.Naming;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DigitToWordClient {
    public static void main(String[] args) {
        try {
            DigitToWordInterface obj = (DigitToWordInterface) Naming.lookup("rmi://localhost:1099/DigitToWordService");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter a number: ");
            String number = br.readLine();

            String result = obj.convertToWords(number);
            System.out.println("In Words: " + result);

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
