package entity;

public class ConfirmedFood {
    private int confirmedID_PK;
    private int orederID_FK;
    private int foodID_FK;

    public ConfirmedFood(){}

    public ConfirmedFood(int confirmedID_PK,int orederID_FK,int foodID_FK){
        this.setConfirmedID_PK(confirmedID_PK);
        this.setOrederID_FK(orederID_FK);
        this.setFoodID_FK(foodID_FK);
    }

    public int getConfirmedID_PK() {
        return confirmedID_PK;
    }

    public void setConfirmedID_PK(int confirmedID_PK) {
        this.confirmedID_PK = confirmedID_PK;
    }

    public int getOrederID_FK() {
        return orederID_FK;
    }

    public void setOrederID_FK(int orederID_FK) {
        this.orederID_FK = orederID_FK;
    }

    public int getFoodID_FK() {
        return foodID_FK;
    }

    public void setFoodID_FK(int foodID_FK) {
        this.foodID_FK = foodID_FK;
    }
}
