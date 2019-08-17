package service.custom;

import dto.CustomerDTO;
import dto.FoodDTO;
import service.SuperService;

import java.util.ArrayList;

public interface FoodService extends SuperService {

    public boolean addFoodService(FoodDTO foodDTO)throws Exception;

    public boolean updateFood(FoodDTO foodDTO)throws Exception;

    public FoodDTO searchFoodByID(int foodID)throws Exception;

    public boolean deleteFood(int foodID)throws Exception;

    public ArrayList<FoodDTO> getAllFood()throws Exception;

    public FoodDTO searchFoodByDescription(String foodDescription)throws Exception;

}
