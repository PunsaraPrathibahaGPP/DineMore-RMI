package business;


import business.custom.impl.*;

public class BoFactory {
    public enum  BOTypes {
        CUSTOMER, CHEF, BIKERIDER, CONFIRMEDFOOD, DELIVERY, DELIVERYDETAILS, FOOD, PLACEORDER, PREPAREDPRODUCT, PRODUCT, RECEPTIONIST ,ORDERQUEUE
    }
    private static BoFactory boFactory;

    private BoFactory(){

    }

    public static BoFactory getInstance(){
        if(boFactory==null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }
    public SuperBo getBO(BOTypes type){
        switch (type){
            case RECEPTIONIST:
                return new ReceptionistBoImpl();
            case CUSTOMER:
                return new CustomerBoImpl();
            case BIKERIDER:
                return new BikeRiderBoImpl();
            case CHEF:
                return new ChefBoImpl();
            case FOOD:
                return null;
            case ORDERQUEUE:
                return new OrderQueueBoImpl();
            case PRODUCT:
                return null;
            case DELIVERY:
                return null;
            case PLACEORDER:
                return new PlaceOrderBoImpl();
            case CONFIRMEDFOOD:
                return null;
            case DELIVERYDETAILS:
                return null;
            case PREPAREDPRODUCT:
                return null;
                default:
                    return null;
        }
    }
}
