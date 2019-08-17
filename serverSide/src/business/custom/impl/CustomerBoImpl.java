package business.custom.impl;

import business.custom.CustomerBo;
import dto.CustomerDTO;
import entity.Customer;
import repository.RepositoryFactory;
import repository.custom.CustomerRespitory;
import resources.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {

    private CustomerRespitory customerRespitory=null;

    public  CustomerBoImpl(){
        initializeCustomerRepositry();
    }

    private void initializeCustomerRepositry(){
        if(customerRespitory==null) {
            customerRespitory = (CustomerRespitory) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RespitoryTypes.CUSTOMER);
        }
    }

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        customerRespitory.setConnection(connection);
        Customer customerEntity = new Customer(customerDTO.getCustomerID(), customerDTO.getCustomerF_Name(),customerDTO.getCustomerL_Name(),customerDTO.getCustomerAddress(),customerDTO.getCustomerNicNO(), customerDTO.getCustomerTel());
        boolean isAdded = customerRespitory.save(customerEntity);
        DBConnection.getInstance().releaseConnection(connection);
        return isAdded;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        customerRespitory.setConnection(connection);
        Customer customer=new Customer(customerDTO.getCustomerID(),customerDTO.getCustomerF_Name(),customerDTO.getCustomerL_Name(),customerDTO.getCustomerAddress(),customerDTO.getCustomerNicNO(),customerDTO.getCustomerTel());
        boolean isUpdated = customerRespitory.update(customer);
        DBConnection.getInstance().releaseConnection(connection);
        return isUpdated;
    }

    @Override
    public boolean deleteCustomer(String customerNic) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        customerRespitory.setConnection(connection);
        Customer customer=new Customer(1,"","","",customerNic,1);
        boolean isDeleted = customerRespitory.delete(customer);
        DBConnection.getInstance().releaseConnection(connection);
        return isDeleted;
    }

    @Override
    public Customer searchCustomer(String customerNic) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        customerRespitory.setConnection(connection);
        Customer customer=new Customer(1,"","","",customerNic,1);
        Customer byNICNO = customerRespitory.findByNICNO(customer);
        DBConnection.getInstance().releaseConnection(connection);
        return byNICNO;
    }

    @Override
    public Customer searchCustomerByID(int customerID) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        customerRespitory.setConnection(connection);
        Customer customer=new Customer(customerID,"","","","",1);
        Customer byNICNO = customerRespitory.findByCustomerID(customer);
        DBConnection.getInstance().releaseConnection(connection);
        return byNICNO;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        this.customerRespitory.setConnection(connection);
        List<Customer> getAllCustomer = this.customerRespitory.getAll();
        ArrayList<CustomerDTO> customerAll=new ArrayList<>();
        for (Customer customerEntity:getAllCustomer) {
            customerAll.add(new CustomerDTO(customerEntity.getCustomerID_PK(),customerEntity.getCustomerF_Name(),customerEntity.getCustomerL_Name(),customerEntity.getCustomerAddress(),customerEntity.getCustomerNicNO(),customerEntity.getCustomerTel()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return customerAll;
    }

    @Override
    public boolean addToQueue(CustomerDTO customerDTO) throws Exception {
        return false;
    }
}
