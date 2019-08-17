package service.impl;

import service.ServiceFactory;
import service.SuperService;
import service.custom.impl.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {
    private  static ServiceFactory serviceFactory;
    private ServiceFactoryImpl() throws RemoteException {
    }

    public static ServiceFactory getInstance() throws RemoteException {
        if(serviceFactory==null){
            serviceFactory=new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch (type){
            case CHEF:
                return new ChefServiceImpl();
            case REPORTS:
                return null;
            case PLACEORDER:
                return new PlaceOrderServiceImpl();
            case CUSTOMER:
                return new CustomerServiceImpl();
            case BIKERIDER:
                return new BikeRiderServiceImpl();
            case ORDERQUEUE:
                return new OrderQueueServiceImpl();
            case RECEPTIONIST:
                return new ReceptionistServiceImpl();
            case USERLOGINSERVICE:
                return new UserLogInServiceImpl();
            default:
                return null;
        }
    }
}
