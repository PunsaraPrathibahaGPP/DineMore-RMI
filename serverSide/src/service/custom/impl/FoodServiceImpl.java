package service.custom.impl;

import business.custom.FoodBo;
import business.custom.impl.FoodBoImpl;
import dto.FoodDTO;
import entity.Food;
import service.custom.FoodService;

import java.util.ArrayList;

public class FoodServiceImpl implements FoodService {
    private static FoodBo foodBo=null;

    public FoodServiceImpl(){
        if(foodBo==null){
            foodBo=new FoodBoImpl();
        }
    }

    @Override
    public boolean addFoodService(FoodDTO foodDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateFood(FoodDTO foodDTO) throws Exception {
        return false;
    }

    @Override
    public FoodDTO searchFoodByID(int foodID) throws Exception {
        return null;
    }

    @Override
    public boolean deleteFood(int foodID) throws Exception {
        return false;
    }

    @Override
    public ArrayList<FoodDTO> getAllFood() throws Exception {
        return foodBo.getAllFoods();
    }

    @Override
    public FoodDTO searchFoodByDescription(String foodDescription) throws Exception {
        Food food = foodBo.searchFoodByDescription(foodDescription);
        FoodDTO foodDTO=new FoodDTO(food.getFoodID_PK(),food.getFoodDescription(),food.getFoodPrice());
        return  foodDTO;
    }
}
