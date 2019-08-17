package observer;

import lk.edu.ijse.dineMore.client.controller.ReceptionistApplicationController;

import java.rmi.Remote;

public interface Subject extends Remote {

    public void registerObserver(ReceptionistApplicationController receptionistApplicationController)throws Exception;

    public void unregisterObserver()throws Exception;

    public  void notifyObservers()throws Exception;
}
