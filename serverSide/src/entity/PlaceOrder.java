package entity;

public class PlaceOrder {
    private int orderID_PK;
    private int customerID_FK;
    private int receptionistID_FK;
    private int chefID_FK;
    private int bikeRiderID_FK;
    private String orderDate;
    private String orderTime;
    private String appointedTime;
    private String foodType;
    private double totalAmmount;
    private String status;

    public PlaceOrder(){}

    public PlaceOrder(int orderID_PK, int customerID_FK,int receptionistID_FK,int chefID_FK,int bikeRiderID_FK,String orderDate, String orderTime, String appointedTime,String foodType,double totalAmmount,String status){
        this.setOrderID_PK(orderID_PK);
        this.setCustomerID_FK(customerID_FK);
        this.setReceptionistID_FK(receptionistID_FK);
        this.setChefID_FK(chefID_FK);
        this.setBikeRiderID_FK(bikeRiderID_FK);
        this.setOrderDate(orderDate);
        this.setOrderTime(orderTime);
        this.setAppointedTime(appointedTime);
        this.setFoodType(foodType);
        this.setTotalAmmount(totalAmmount);
        this.setStatus(status);
    }

    public int getOrderID_PK() {
        return orderID_PK;
    }

    public void setOrderID_PK(int orderID_PK) {
        this.orderID_PK = orderID_PK;
    }

    public int getCustomerID_FK() {
        return customerID_FK;
    }

    public void setCustomerID_FK(int customerID_FK) {
        this.customerID_FK = customerID_FK;
    }

    public int getReceptionistID_FK() {
        return receptionistID_FK;
    }

    public void setReceptionistID_FK(int receptionistID_FK) {
        this.receptionistID_FK = receptionistID_FK;
    }

    public int getChefID_FK() {
        return chefID_FK;
    }

    public void setChefID_FK(int chefID_FK) {
        this.chefID_FK = chefID_FK;
    }

    public int getBikeRiderID_FK() {
        return bikeRiderID_FK;
    }

    public void setBikeRiderID_FK(int bikeRiderID_FK) {
        this.bikeRiderID_FK = bikeRiderID_FK;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getAppointedTime() {
        return appointedTime;
    }

    public void setAppointedTime(String appointedTime) {
        this.appointedTime = appointedTime;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public double getTotalAmmount() {
        return totalAmmount;
    }

    public void setTotalAmmount(double totalAmmount) {
        this.totalAmmount = totalAmmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
