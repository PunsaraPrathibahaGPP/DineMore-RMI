package service;

import java.rmi.Remote;

public interface ServiceFactory extends Remote{
    public enum ServiceTypes{
        CUSTOMER,RECEPTIONIST,CHEF,BIKERIDER,REPORTS,ORDERQUEUE,PLACEORDER,USERLOGINSERVICE;
    }

    public SuperService getService(ServiceTypes type)throws Exception;
}
