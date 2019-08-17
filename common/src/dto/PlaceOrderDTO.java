package dto;

import java.io.Serializable;

public class PlaceOrderDTO implements Serializable {
    private int orderID;
    private int customerID;
    private int receptionistID;
    private int chefID;
    private int bikeRiderID;
    private String orderDate;
    private String orderTime;
    private String appointedTime;
    private String foodType;
    private double totalAmmount;
    private String status;

    public PlaceOrderDTO(){}

    public PlaceOrderDTO(int chefID,String status){
        this.chefID=chefID;
        this.status=status;
    }

    public PlaceOrderDTO(int orderID, int customerID,String orderTime,String appointedTime,String status){
        this.setOrderID(orderID);
        this.setCustomerID(customerID);
        this.setOrderTime(orderTime);
        this.setAppointedTime(appointedTime);
        this.status=status;
    }

    public PlaceOrderDTO(int orderID, int customerID,int receptionistID,int chefID,int bikeRiderID, String orderDate, String orderTime, String appointedTime,String foodType,double totalAmmount,String status){
        this.setOrderID(orderID);
        this.setCustomerID(customerID);
        this.setReceptionistID(receptionistID);
        this.setChefID(chefID);
        this.setBikeRiderID(bikeRiderID);
        this.setOrderDate(orderDate);
        this.setOrderTime(orderTime);
        this.setAppointedTime(appointedTime);
        this.setFoodType(foodType);
        this.setTotalAmmount(totalAmmount);
        this.setStatus(status);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(int receptionistID) {
        this.receptionistID = receptionistID;
    }

    public int getChefID() {
        return chefID;
    }

    public void setChefID(int chefID) {
        this.chefID = chefID;
    }

    public int getBikeRiderID() {
        return bikeRiderID;
    }

    public void setBikeRiderID(int bikeRiderID) {
        this.bikeRiderID = bikeRiderID;
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
