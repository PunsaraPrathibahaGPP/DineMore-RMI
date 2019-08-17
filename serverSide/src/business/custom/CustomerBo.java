package business.custom;

import business.SuperBo;
import dto.CustomerDTO;
import entity.Customer;

import java.util.ArrayList;

public interface CustomerBo extends SuperBo {
    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;
    public boolean updateCustomer(CustomerDTO customerDTO)throws  Exception;
    public boolean deleteCustomer(String customerNic)throws Exception;
    public Customer searchCustomer(String customerNic)throws Exception;
    public Customer searchCustomerByID(int customerID)throws Exception;
    public ArrayList<CustomerDTO> getAllCustomer()throws Exception;
    public boolean addToQueue(CustomerDTO customerDTO) throws Exception;
}
