package observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer extends Remote {
    public void updateObservers()throws Exception;
}
