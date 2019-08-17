package dto;

import java.io.Serializable;

public class PreparedProductDTO implements Serializable {
    private int preparedID;
    private int productID;
    private int chefID;

    public PreparedProductDTO(){}

    public PreparedProductDTO(int preparedID, int productID, int chefID){
        this.setPreparedID(preparedID);
        this.setProductID(productID);
        this.setChefID(chefID);
    }

    public int getPreparedID() {
        return preparedID;
    }

    public void setPreparedID(int preparedID) {
        this.preparedID = preparedID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getChefID() {
        return chefID;
    }

    public void setChefID(int chefID) {
        this.chefID = chefID;
    }
}
