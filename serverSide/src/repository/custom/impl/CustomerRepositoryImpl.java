/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.custom.impl;


import dto.CustomerDTO;
import entity.Customer;
import repository.custom.CustomerRespitory;
import resources.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRespitory {

    private static Connection connection;

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

    @Override
    public boolean save(Customer customer) throws Exception {
        String sql = "INSERT INTO customer values (?,?,?,?,?,?)";
        PreparedStatement prst = connection.prepareStatement(sql);
        prst.setObject(1, customer.getCustomerID_PK());
        prst.setObject(2, customer.getCustomerF_Name());
        prst.setObject(3, customer.getCustomerL_Name());
        prst.setObject(4, customer.getCustomerAddress());
        prst.setObject(5, customer.getCustomerNicNO());
        prst.setObject(6, customer.getCustomerTel());
        return prst.executeUpdate() > 0;
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        String sql="UPDATE customer SET customerF_Name =?, customerL_Name =?, customerAddress =?, customerTel =?  WHERE customerNicNO = ? ;";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setObject(1,customer.getCustomerF_Name());
        preparedStatement.setObject(2,customer.getCustomerL_Name());
        preparedStatement.setObject(3,customer.getCustomerAddress());
        preparedStatement.setObject(4,customer.getCustomerTel());
        preparedStatement.setObject(5,customer.getCustomerNicNO());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean delete(Customer customer) throws Exception {
        String sql="DELETE FROM customer WHERE customerNicNO = ?";
        this.connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setObject(1,customer.getCustomerNicNO());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public Customer findByNICNO(Customer customer) throws Exception {
        String sql="SELECT * FROM customer WHERE customerNicNO = ?";
        this.connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setObject(1,customer.getCustomerNicNO());
        Customer customerEntity = null;
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            customerEntity=new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
        }
        return customerEntity;
    }

    @Override
    public List<Customer> getAll() throws Exception {
        String sql="SELECT * FROM Customer";
        this.connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        List<Customer> customerList=new ArrayList<>();
        ResultSet resultSet=preparedStatement.executeQuery(sql);
        while(resultSet.next()){
            customerList.add(new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6)));
        }
        return customerList;
    }

    @Override
    public int getLastCustID() throws Exception {
        String sql = "SELECT custID FROM customer ORDER BY 1 DESC LIMIT 1";
        Statement stm = this.connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getInt(1);
        } else {
            return 0;
        }

    }

    @Override
    public Customer findByCustomerID(Customer customer) throws Exception {
        String sql="SELECT * FROM customer WHERE customerID = ?";
        this.connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setObject(1,customer.getCustomerID_PK());
        Customer customerEntity = null;
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            customerEntity=new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
        }
        return customerEntity;
    }

}
