package lk.edu.ijse.dineMore.client.proxy;

import service.ServiceFactory;
import service.SuperService;
import service.custom.*;
import service.custom.impl.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ProxyHandler implements ServiceFactory{
    private static ProxyHandler proxyHandler=null;
    private static ServiceFactory serviceFactory;
    private OrderQueueService orderQueueService;
    private PlaceOrderService placeOrderService;
    private CustomerService customerService;
    private ChefService chefService;
    private ReceptionistService receptionistService;
    private BikeRiderService bikeRiderService;

    public ProxyHandler(){
        try {
            this.placeOrderService = new PlaceOrderServiceImpl();
                    //(PlaceOrderService) this.serviceFactory.getService(ServiceTypes.PLACEORDER);
            this.customerService = new CustomerServiceImpl();
                    //(CustomerService) this.serviceFactory.getService(ServiceTypes.CUSTOMER);
            this.chefService = new ChefServiceImpl();
                    //(ChefService) this.serviceFactory.getService(ServiceTypes.CHEF);
            this.receptionistService = new ReceptionistServiceImpl();
                    //(ReceptionistService) this.serviceFactory.getService(ServiceTypes.RECEPTIONIST);
            this.bikeRiderService= new BikeRiderServiceImpl();
                    //(BikeRiderService) this.serviceFactory.getService(ServiceTypes.BIKERIDER);
            this.orderQueueService = new OrderQueueServiceImpl();
                    //(OrderQueueService) this.serviceFactory.getService(ServiceTypes.ORDERQUEUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ProxyHandler getInstance(){
        try {
            serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:5060/dineMore");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if(proxyHandler==null){
            return new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceTypes type) throws Exception {
        switch (type) {
            case ORDERQUEUE:
                return this.orderQueueService;
            case PLACEORDER:
                return this.placeOrderService;
            case CUSTOMER:
                return this.customerService;
            case CHEF:
                return this.chefService;
            case RECEPTIONIST:
                return this.receptionistService;
            case BIKERIDER:
                return this.bikeRiderService;
            case REPORTS:
                return null;
            default:
                return null;
        }
    }
}
