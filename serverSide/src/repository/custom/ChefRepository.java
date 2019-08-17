/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.custom;

import entity.*;
import entity.Chef;
import java.sql.Connection;
import java.util.List;

import repository.SuperRepository;

/**
 *
 * @author Kasun
 */
public interface ChefRepository extends SuperRepository<Chef, Integer> {
    public int getLastChefID() throws Exception;

    public Chef searchByFirstName(String firstName)throws Exception;

    public boolean deleteChef(String firstName)throws Exception;

    public boolean saveEmployeeLoginDetails(EmployeeLogIn employeeLogIn)throws Exception;

    public List<PlaceOrder> getAllChefOrderQueue()throws Exception;
}
