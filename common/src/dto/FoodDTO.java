package dto;

import java.io.Serializable;

public class FoodDTO implements Serializable {
    private int foodID;
    private String foodDescription;
    private double foodPrice;

    public FoodDTO(){}

    public FoodDTO(int foodID, String foodDescription, double foodPrice){
        this.setFoodID(foodID);
        this.setFoodDescription(foodDescription);
        this.setFoodPrice(foodPrice);
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }
}
