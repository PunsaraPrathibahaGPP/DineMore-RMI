package service.custom;

import dto.CustomerDTO;
import entity.Customer;
import service.SuperService;

import java.util.ArrayList;

public interface CustomerService extends SuperService{
    public boolean addTOQueue(CustomerDTO customerDTO) throws Exception;

    public boolean addCustomerService(CustomerDTO customerDTO)throws Exception;

    public boolean updateCustomer(CustomerDTO customerDTO)throws Exception;

    public CustomerDTO searchCustomer(String customerNIC)throws Exception;

    public CustomerDTO searchCustomerByID(int customerID)throws Exception;

    public boolean deleteCustomer(String customerNIC)throws Exception;
}
