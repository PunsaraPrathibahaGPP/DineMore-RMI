/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.custom;


import entity.Customer;
import repository.SuperRepository;

/**
 *
 * @author Kasun
 */
public interface CustomerRespitory extends SuperRepository<Customer, Integer> {

    public int getLastCustID() throws Exception;

    public Customer findByCustomerID(Customer customer) throws Exception;
}
