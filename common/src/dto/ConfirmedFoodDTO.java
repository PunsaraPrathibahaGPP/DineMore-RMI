package dto;

import java.io.Serializable;

public class ConfirmedFoodDTO implements Serializable {
    private int confirmedID;
    private int orederID;
    private int foodID;

    public ConfirmedFoodDTO(){}

    public ConfirmedFoodDTO(int confirmedID, int orederID, int foodID){
        this.setConfirmedID(confirmedID);
        this.setOrederID(orederID);
        this.setFoodID(foodID);
    }

    public int getConfirmedID() {
        return confirmedID;
    }

    public void setConfirmedID(int confirmedID) {
        this.confirmedID = confirmedID;
    }

    public int getOrederID() {
        return orederID;
    }

    public void setOrederID(int orederID) {
        this.orederID = orederID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }
}
