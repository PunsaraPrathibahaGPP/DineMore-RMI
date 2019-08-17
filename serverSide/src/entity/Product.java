package entity;

public class Product {
    private int productID_PK;
    private String productName;
    private double unitPrice;
    private int ammount;
    private double totalPrice;

    public Product(){}

    public Product(int productID_PK,String productName,double unitPrice,int ammount,double totalPrice){
        this.setProductID_PK(productID_PK);
        this.setProductName(productName);
        this.setUnitPrice(unitPrice);
        this.setAmmount(ammount);
        this.setTotalPrice(totalPrice);
    }

    public int getProductID_PK() {
        return productID_PK;
    }

    public void setProductID_PK(int productID_PK) {
        this.productID_PK = productID_PK;
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
