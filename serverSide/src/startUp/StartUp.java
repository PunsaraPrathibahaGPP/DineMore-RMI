package startUp;

import service.impl.ServiceFactoryImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Locale;

public class StartUp {
    public static void main(String[] args){
        try {
            Registry registry = LocateRegistry.createRegistry(5060);
            registry.rebind("dineMore", ServiceFactoryImpl.getInstance());
            System.out.println("Server is Running Successfully...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
