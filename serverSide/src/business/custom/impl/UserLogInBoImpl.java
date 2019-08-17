package business.custom.impl;

import business.custom.UserLoginBo;
import entity.EmployeeLogIn;
import resources.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLogInBoImpl implements UserLoginBo {
    @Override
    public EmployeeLogIn searchUserNamePassword(String userName,String password,String tableName) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM receptionistLogin WHERE userName= ? && password= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,userName);
        preparedStatement.setObject(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        EmployeeLogIn employeeLogIn=null;
        while (resultSet.next()){
            employeeLogIn=new EmployeeLogIn(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return employeeLogIn;
    }

    @Override
    public EmployeeLogIn searchChefUserNamePassword(String userName, String password, String tableName) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM CheflogIn WHERE userName= ? && password= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,userName);
        preparedStatement.setObject(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        EmployeeLogIn employeeLogIn=null;
        while (resultSet.next()){
            employeeLogIn=new EmployeeLogIn(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return employeeLogIn;
    }

    @Override
    public EmployeeLogIn searchBikeRiderUserNamePassword(String userName, String password, String tableName) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        String sql="SELECT * FROM bikeRiderLogin WHERE userName= ? && password= ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,userName);
        preparedStatement.setObject(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        EmployeeLogIn employeeLogIn=null;
        while (resultSet.next()){
            employeeLogIn=new EmployeeLogIn(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return employeeLogIn;
    }
}
