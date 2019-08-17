package entity;

public class PreparedProduct {
    private int preparedID_PK;
    private int productID_FK;
    private int chefID_FK;

    public PreparedProduct(){}

    public PreparedProduct(int preparedID_PK,int productID_FK,int chefID_FK){
        this.setPreparedID_PK(preparedID_PK);
        this.setProductID_FK(productID_FK);
        this.setChefID_FK(chefID_FK);
    }

    public int getPreparedID_PK() {
        return preparedID_PK;
    }

    public void setPreparedID_PK(int preparedID_PK) {
        this.preparedID_PK = preparedID_PK;
    }

    public int getProductID_FK() {
        return productID_FK;
    }

    public void setProductID_FK(int productID_FK) {
        this.productID_FK = productID_FK;
    }

    public int getChefID_FK() {
        return chefID_FK;
    }

    public void setChefID_FK(int chefID_FK) {
        this.chefID_FK = chefID_FK;
    }
}
