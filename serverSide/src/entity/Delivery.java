package entity;

public class Delivery {
    private int delivery_ID_PK;
    private String delivery_Date;
    private String delivery_Time;
    private String delivery_State;
    private double paid_Price;
    private double total_Price;
    private double balance;

    public Delivery(){}

    public Delivery(int delivery_ID_PK,String delivery_Date,String delivery_Time,String delivery_State,double paid_Price,double total_Price,double balance){
        this.setDelivery_ID_PK(delivery_ID_PK);
        this.setDelivery_Date(delivery_Date);
        this.setDelivery_Time(delivery_Time);
        this.setDelivery_State(delivery_State);
        this.setPaid_Price(paid_Price);
        this.setTotal_Price(total_Price);
        this.setBalance(balance);
    }

    public int getDelivery_ID_PK() {
        return delivery_ID_PK;
    }

    public void setDelivery_ID_PK(int delivery_ID_PK) {
        this.delivery_ID_PK = delivery_ID_PK;
    }

    public String getDelivery_Date() {
        return delivery_Date;
    }

    public void setDelivery_Date(String delivery_Date) {
        this.delivery_Date = delivery_Date;
    }

    public String getDelivery_Time() {
        return delivery_Time;
    }

    public void setDelivery_Time(String delivery_Time) {
        this.delivery_Time = delivery_Time;
    }

    public String getDelivery_State() {
        return delivery_State;
    }

    public void setDelivery_State(String delivery_State) {
        this.delivery_State = delivery_State;
    }

    public double getPaid_Price() {
        return paid_Price;
    }

    public void setPaid_Price(double paid_Price) {
        this.paid_Price = paid_Price;
    }

    public double getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(double total_Price) {
        this.total_Price = total_Price;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
