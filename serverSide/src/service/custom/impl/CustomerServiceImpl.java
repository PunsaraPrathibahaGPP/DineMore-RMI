package service.custom.impl;

import business.custom.CustomerBo;
import business.custom.impl.CustomerBoImpl;
import dto.CustomerDTO;
import entity.Customer;
import service.custom.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private static CustomerBo customerBo=null;
//    private static CustomerService customerService=null;

    public CustomerServiceImpl(){
        if(customerBo==null){
            customerBo=new CustomerBoImpl();
        }
    }

    @Override
    public boolean addTOQueue(CustomerDTO customerDTO) throws Exception {
        return customerBo.addToQueue(customerDTO);
    }

    @Override
    public boolean addCustomerService(CustomerDTO customerDTO) throws Exception {
        return customerBo.addCustomer(customerDTO);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        return customerBo.updateCustomer(customerDTO);
    }

    @Override
    public CustomerDTO searchCustomer(String customerNIC) throws Exception {
        Customer customer = customerBo.searchCustomer(customerNIC);
        CustomerDTO customerDTO=new CustomerDTO(customer.getCustomerID_PK(),customer.getCustomerF_Name(),customer.getCustomerL_Name(),customer.getCustomerAddress(),customer.getCustomerNicNO(),customer.getCustomerTel());
        return customerDTO;

    }

    @Override
    public CustomerDTO searchCustomerByID(int customerID) throws Exception {
        Customer customer = customerBo.searchCustomerByID(customerID);
        CustomerDTO customerDTO=new CustomerDTO(customer.getCustomerID_PK(),customer.getCustomerF_Name(),customer.getCustomerL_Name(),customer.getCustomerAddress(),customer.getCustomerNicNO(),customer.getCustomerTel());
        return customerDTO;
    }

    @Override
    public boolean deleteCustomer(String customerNIC) throws Exception {
        return customerBo.deleteCustomer(customerNIC);
    }
}
