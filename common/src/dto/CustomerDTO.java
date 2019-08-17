package dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
    private int customerID;
    private String customerF_Name;
    private String customerL_Name;
    private String customerAddress;
    private String customerNicNO;
    private int customerTel;

    public CustomerDTO(){}

    public CustomerDTO(int customerID, String customerF_Name, String customerL_Name, String customerAddress, String customerNicNO, int customerTel){
        this.setCustomerID(customerID);
        this.setCustomerF_Name(customerF_Name);
        this.setCustomerL_Name(customerL_Name);
        this.setCustomerAddress(customerAddress);
        this.setCustomerNicNO(customerNicNO);
        this.setCustomerTel(customerTel);
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

    public String getCustomerNicNO() {
        return customerNicNO;
    }

    public void setCustomerNicNO(String customerNicNO) {
        this.customerNicNO = customerNicNO;
    }

    public int getCustomerTel() {
        return customerTel;
    }

    public void setCustomerTel(int customerTel) {
        this.customerTel = customerTel;
    }
}
