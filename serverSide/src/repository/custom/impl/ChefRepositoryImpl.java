/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.custom.impl;

import entity.Chef;
import entity.Chef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.EmployeeLogIn;
import entity.PlaceOrder;
import repository.custom.ChefRepository;
import resources.DBConnection;

public class ChefRepositoryImpl implements ChefRepository {
    private static Connection connection=null;
    public ChefRepositoryImpl(){
    }
    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }

    @Override
    public boolean save(Chef chef) throws Exception {
        String sql="INSERT INTO Chef VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,chef.getChefID_PK());
        preparedStatement.setObject(2,chef.getChefF_Name());
        preparedStatement.setObject(3,chef.getChefL_Name());
        preparedStatement.setObject(4,chef.getChefAddress());
        preparedStatement.setObject(5,chef.getChef_NicNO());
        preparedStatement.setObject(6,chef.getChefTel());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean update(Chef chef) throws Exception {
        String sql="UPDATE Chef SET chefF_Name=?,chefL_Name=?,chefAddress=?,chef_NicNO=?,chefTel=? WHERE chefF_Name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,chef.getChefF_Name());
        preparedStatement.setObject(2,chef.getChefL_Name());
        preparedStatement.setObject(3,chef.getChefAddress());
        preparedStatement.setObject(4,chef.getChef_NicNO());
        preparedStatement.setObject(5,chef.getChefTel());
        preparedStatement.setObject(6,chef.getChefF_Name());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean delete(Chef chef) throws Exception {
        return false;
    }

    @Override
    public Chef findByNICNO(Chef chef) throws Exception {
        return null;
    }

    @Override
    public List<Chef> getAll() throws Exception {
        return null;
    }

    @Override
    public int getLastChefID() throws Exception {
        return 0;
    }

    @Override
    public Chef searchByFirstName(String firstName) throws Exception {
        String sql="SELECT * FROM Chef WHERE chefF_Name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,firstName);
        ResultSet resultSet = preparedStatement.executeQuery();
        Chef chef=null;
        while(resultSet.next()){
            chef=new Chef(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
        }
        return chef;
    }

    @Override
    public boolean deleteChef(String firstName) throws Exception {
        String sql="DELETE FROM Chef WHERE chefF_Name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,firstName);
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean saveEmployeeLoginDetails(EmployeeLogIn employeeLogIn) throws Exception {
        String sql = "INSERT INTO CheflogIn values (?,?,?)";
        PreparedStatement prst = connection.prepareStatement(sql);
        prst.setObject(1, employeeLogIn.getEmployeeID());
        prst.setObject(2, employeeLogIn.getUserName());
        prst.setObject(3, employeeLogIn.getPassword());
        return prst.executeUpdate() > 0;
    }

    @Override
    public List<PlaceOrder> getAllChefOrderQueue() throws Exception {
        String sql="SELECT * FROM PlaceOrder WHERE status='WaitingList'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<PlaceOrder> placeOrders=new ArrayList<>();
        while (resultSet.next()){
            placeOrders.add(new PlaceOrder(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getDouble(10),resultSet.getString(11)));
        }
        return placeOrders;
    }
}
