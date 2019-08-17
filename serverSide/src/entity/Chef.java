package entity;

public class Chef {
    private int chefID_PK;
    private String chefF_Name;
    private String chefL_Name;
    private String chefAddress;
    private String chef_NicNO;
    private int chefTel;

    public Chef(){}

    public Chef(int chefID_PK,String chefF_Name,String chefL_Name,String chefAddress,String chef_NicNO,int chefTel){
        this.setChefID_PK((chefID_PK));
        this.setChefF_Name(chefF_Name);
        this.setChefL_Name(chefL_Name);
        this.setChefAddress(chefAddress);
        this.setChef_NicNO(chef_NicNO);
        this.setChefTel(chefTel);
    }

    public int getChefID_PK() {
        return chefID_PK;
    }

    public void setChefID_PK(int chefID_PK) {
        this.chefID_PK = chefID_PK;
    }

    public String getChefF_Name() {
        return chefF_Name;
    }

    public void setChefF_Name(String chefF_Name) {
        this.chefF_Name = chefF_Name;
    }

    public String getChefL_Name() {
        return chefL_Name;
    }

    public void setChefL_Name(String chefL_Name) {
        this.chefL_Name = chefL_Name;
    }

    public String getChefAddress() {
        return chefAddress;
    }

    public void setChefAddress(String chefAddress) {
        this.chefAddress = chefAddress;
    }

    public String getChef_NicNO() {
        return chef_NicNO;
    }

    public void setChef_NicNO(String chef_NicNO) {
        this.chef_NicNO = chef_NicNO;
    }

    public int getChefTel() {
        return chefTel;
    }

    public void setChefTel(int chefTel) {
        this.chefTel = chefTel;
    }
}
