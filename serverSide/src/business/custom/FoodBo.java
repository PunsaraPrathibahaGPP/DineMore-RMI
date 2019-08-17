package business.custom;

import business.SuperBo;
import dto.CustomerDTO;
import dto.FoodDTO;
import entity.Customer;
import entity.Food;

import java.util.ArrayList;

public interface FoodBo extends SuperBo {
    public boolean addFood(FoodDTO foodDTO)throws Exception;
    public boolean updateFood(FoodDTO foodDTO)throws  Exception;
    public boolean deleteFood(int foodID)throws Exception;
    public Food searchFoodByID(int foodID)throws Exception;
    public ArrayList<FoodDTO> getAllFoods()throws Exception;
    public Food searchFoodByDescription(String foodDescription)throws Exception;
}
