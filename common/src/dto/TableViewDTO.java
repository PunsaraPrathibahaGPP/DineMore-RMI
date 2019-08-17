package dto;

import java.io.Serializable;

public class TableViewDTO implements Serializable {
    private int orderID;
    private int receptionistID;
    private String customerF_Name;
    private String customerL_Name;
    private String customerAddress;
    private  String customerNicNo;
    private int contactNumber;
    private int qty;

    TableViewDTO(){}

    TableViewDTO(int orderID,String customerF_Name,int contactNumber,int qty){
        this.setOrderID(orderID);
        this.setCustomerF_Name(customerF_Name);
        this.setContactNumber(contactNumber);
        this.setQty(qty);
    }

    TableViewDTO(int orderID,String customerF_Name,String customerL_Name,int contactNumber,int qty){
        this.setOrderID(orderID);
        this.setCustomerF_Name(customerF_Name);
        this.setCustomerL_Name(customerL_Name);
        this.setContactNumber(contactNumber);
        this.setQty(qty);
    }

    TableViewDTO(int orderID,int receptionistID, String customerF_Name,String customerL_Name,int contactNumber,int qty){
        this.setOrderID(orderID);
        this.setReceptionistID(receptionistID);
        this.setCustomerF_Name(customerF_Name);
        this.setCustomerL_Name(customerL_Name);
        this.setContactNumber(contactNumber);
        this.setQty(qty);
    }

    TableViewDTO(int orderID,int receptionistID, String customerF_Name,String customerL_Name,String customerAddress,int contactNumber,int qty){
        this.setOrderID(orderID);
        this.setReceptionistID(receptionistID);
        this.setCustomerF_Name(customerF_Name);
        this.setCustomerL_Name(customerL_Name);
        this.setCustomerAddress(customerAddress);
        this.setContactNumber(contactNumber);
        this.setQty(qty);
    }

    TableViewDTO(int orderID,int receptionistID, String customerF_Name,String customerL_Name,String customerAddress,String customerNicNo,int contactNumber,int qty){
        this.setOrderID(orderID);
        this.setReceptionistID(receptionistID);
        this.setCustomerF_Name(customerF_Name);
        this.setCustomerL_Name(customerL_Name);
        this.setCustomerAddress(customerAddress);
        this.setContactNumber(contactNumber);
        this.setCustomerNicNo(customerNicNo);
        this.setQty(qty);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(int receptionistID) {
        this.receptionistID = receptionistID;
    }

    public String getCustomerF_Name() {
        return customerF_Name;
    }

    public void setCustomerF_Name(String customerF_Name) {
        this.customerF_Name = customerF_Name;
    }

    public String getCustomerL_Name() {
        return customerL_Name;
    }

    public void setCustomerL_Name(String customerL_Name) {
        this.customerL_Name = customerL_Name;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerNicNo() {
        return customerNicNo;
    }

    public void setCustomerNicNo(String customerNicNo) {
        this.customerNicNo = customerNicNo;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
