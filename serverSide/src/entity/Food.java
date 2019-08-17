package entity;

public class Food {
    private int foodID_PK;
    private String foodDescription;
    private double foodPrice;

    public Food(){}

    public Food(int foodID_PK,String foodDescription,double foodPrice){
        this.setFoodID_PK(foodID_PK);
        this.setFoodDescription(foodDescription);
        this.setFoodPrice(foodPrice);
    }

    public int getFoodID_PK() {
        return foodID_PK;
    }

    public void setFoodID_PK(int foodID_PK) {
        this.foodID_PK = foodID_PK;
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
