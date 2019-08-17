package dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private int productID;
    private String productName;
    private double unitPrice;
    private int ammount;
    private double totalPrice;

    public ProductDTO(){}

    public ProductDTO(int productID, String productName, double unitPrice, int ammount, double totalPrice){
        this.setProductID(productID);
        this.setProductName(productName);
        this.setUnitPrice(unitPrice);
        this.setAmmount(ammount);
        this.setTotalPrice(totalPrice);
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
