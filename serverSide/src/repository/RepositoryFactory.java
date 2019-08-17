/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import repository.custom.impl.*;

/**
 *
 * @author Kasun
 */
public class RepositoryFactory {

    private static RepositoryFactory respitoryFactory;

    public static enum RespitoryTypes {
        CUSTOMER, CHEF, ORDERS ,RECEPTIONIST ,BIKERIDER ,PLACEORDER
    }

    public RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        if (respitoryFactory == null) {
            respitoryFactory = new RepositoryFactory();
        }
        return respitoryFactory;
    }

    public SuperRepository getRepository(RespitoryTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerRepositoryImpl();
            case CHEF:
                return new ChefRepositoryImpl();
            case ORDERS:
                return null;
            case RECEPTIONIST:
                return new ReceptionistRepositoryImpl();
            case BIKERIDER:
                return new BikeRiderRepositoryImpl();
            case PLACEORDER:
                return new PlaceOrderRepositeryImpl();
            default:
                return null;
        }
    }
}
