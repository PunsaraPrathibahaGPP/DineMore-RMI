package business.custom.impl;

import business.custom.FoodBo;
import dto.FoodDTO;
import entity.Food;
import resources.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoodBoImpl implements FoodBo {

    public FoodBoImpl(){

    }


    @Override
    public boolean addFood(FoodDTO foodDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateFood(FoodDTO foodDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteFood(int foodID) throws Exception {
        return false;
    }

    @Override
    public Food searchFoodByID(int foodID) throws Exception {
        return null;
    }

    @Override
    public ArrayList<FoodDTO> getAllFoods() throws Exception {
        String sql="SELECT * FROM Food";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<FoodDTO> foodDTOS=new ArrayList<>();
        while (resultSet.next()){
            foodDTOS.add(new FoodDTO(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3)));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return foodDTOS;
    }

    @Override
    public Food searchFoodByDescription(String foodDescription) throws Exception {
        String sql="SELECT * FROM Food WHERE foodDescription=?";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,foodDescription);
        ResultSet resultSet = preparedStatement.executeQuery();
        Food foodDTOS=null;
        while (resultSet.next()){
            foodDTOS=new Food(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return foodDTOS;
    }
}
