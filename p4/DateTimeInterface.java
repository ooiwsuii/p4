import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DateTimeInterface extends Remote {
    String getDateTime() throws RemoteException;
}
