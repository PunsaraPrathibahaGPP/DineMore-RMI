package repository.custom.impl;

import dto.PlaceOrderDTO;
import entity.Customer;
import entity.PlaceOrder;
import repository.custom.PlaceOrderRepositery;
import resources.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderRepositeryImpl implements PlaceOrderRepositery {
    private Connection connection=null;

    @Override
    public int getLastOrderID() throws Exception {
        return 0;
    }

    @Override
    public PlaceOrder searchOrderByCustomerNIC(int customerID) throws Exception {
        String sql="SELECT * FROM PlaceOrder WHERE customerID=?";
        connection=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,customerID);
        ResultSet resultSet = preparedStatement.executeQuery();
        PlaceOrder placeOrder=null;
        while (resultSet.next()){
            placeOrder=new PlaceOrder(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getDouble(10),resultSet.getString(11));
        }
        return placeOrder;
    }

    @Override
    public boolean updateChefCustomerQueue(PlaceOrderDTO updatePlaceOrderDTO, int orderID) throws Exception {
        String sql="UPDATE PlaceOrder SET chefID=?,status=? WHERE orederID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,updatePlaceOrderDTO.getChefID());
        preparedStatement.setObject(2,updatePlaceOrderDTO.getStatus());
        preparedStatement.setObject(3,orderID);
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public ArrayList<PlaceOrder> getReceptionistQueue() throws Exception {
        String sql="SELECT * FROM PlaceOrder";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<PlaceOrder> list=new ArrayList<>();
        while(resultSet.next()){
            list.add(new PlaceOrder(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getDouble(10),resultSet.getString(11)));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return list;
    }

    @Override
    public ArrayList<PlaceOrder> getBikeRiderQueue() throws Exception {
        String sql="SELECT * FROM PlaceOrder WHERE status='AfterKitchen'";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<PlaceOrder> list=new ArrayList<>();
        while(resultSet.next()){
            list.add(new PlaceOrder(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getDouble(10),resultSet.getString(11)));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return list;
    }

    @Override
    public boolean updateBikeRiderCustomerQueue(PlaceOrderDTO updatePlaceOrderDTO, int orderID) throws Exception {
        String sql="UPDATE PlaceOrder SET bikeRider_ID=?,status=? WHERE orederID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,updatePlaceOrderDTO.getBikeRiderID());
        preparedStatement.setObject(2,updatePlaceOrderDTO.getStatus());
        preparedStatement.setObject(3,orderID);
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }

    @Override
    public boolean save(PlaceOrder placeOrder) throws Exception {
        String sql="Insert INTO placeOrder VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,placeOrder.getOrderID_PK());
        preparedStatement.setObject(2,placeOrder.getCustomerID_FK());
        preparedStatement.setObject(3,placeOrder.getReceptionistID_FK());
        preparedStatement.setObject(4,placeOrder.getChefID_FK());
        preparedStatement.setObject(5,placeOrder.getBikeRiderID_FK());
        preparedStatement.setObject(6,placeOrder.getOrderDate());
        preparedStatement.setObject(7,placeOrder.getOrderTime());
        preparedStatement.setObject(8,placeOrder.getAppointedTime());
        preparedStatement.setObject(9,placeOrder.getFoodType());
        preparedStatement.setObject(10,placeOrder.getTotalAmmount());
        preparedStatement.setObject(11,placeOrder.getStatus());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean update(PlaceOrder placeOrder) throws Exception {
        return false;
    }

    @Override
    public boolean delete(PlaceOrder placeOrder) throws Exception {
        return false;
    }

    @Override
    public PlaceOrder findByNICNO(PlaceOrder placeOrder) throws Exception {
        return null;
    }

    @Override
    public List<PlaceOrder> getAll() throws Exception {
        String sql="SELECT * FROM PlaceOrder";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<PlaceOrder> placeOrders=new ArrayList<>();
        while (resultSet.next()){
            placeOrders.add(new PlaceOrder(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getDouble(10),resultSet.getString(11)));
        }
        return placeOrders;
    }
}
