import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DigitToWordInterface extends Remote {
    String convertToWords(String number) throws RemoteException;
}
