import java.rmi.Naming;

public class DateTimeClient {
    public static void main(String[] args) {
        try {
            DateTimeInterface obj = (DateTimeInterface) Naming.lookup("rmi://localhost:1099/DateTimeService");
            System.out.println("Current Date and Time: " + obj.getDateTime());
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
