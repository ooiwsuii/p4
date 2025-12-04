import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.util.Date;

public class DateTimeServer extends UnicastRemoteObject implements DateTimeInterface {

    protected DateTimeServer() throws RemoteException {
        super();
    }

    @Override
    public String getDateTime() throws RemoteException {
        Date d = new Date();
        return d.toString();
    }

    public static void main(String[] args) {
        try {
            DateTimeServer obj = new DateTimeServer();
            Naming.rebind("rmi://localhost:1099/DateTimeService", obj);
            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
