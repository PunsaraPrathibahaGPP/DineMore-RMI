package dto;

import java.io.Serializable;

public class BikeRiderDTO implements Serializable {
    private int bikeRider_ID;
    private String bike_NO;
    private String bikeRiderF_Name;
    private String bikeRiderL_Name;
    private String bikeRider_Address;
    private String bikeRider_NicNO;
    private int bikeRider_Tel;

    public BikeRiderDTO(){}

    public BikeRiderDTO(int bikeRider_ID,String bikeRiderF_Name,String bikeRiderL_Name,String bikeRider_Address,String bikeRider_NicNO,int bikeRider_Tel){
        this.setBikeRider_ID(bikeRider_ID);
        this.setBikeRiderF_Name(bikeRiderF_Name);
        this.setBikeRiderL_Name(bikeRiderL_Name);
        this.setBikeRider_Address(bikeRider_Address);
        this.setBikeRider_NicNO(bikeRider_NicNO);
        this.setBikeRider_Tel(bikeRider_Tel);
    }

    public BikeRiderDTO(int bikeRider_ID,String bike_NO,String bikeRiderF_Name,String bikeRiderL_Name,String bikeRider_Address,String bikeRider_NicNO,int bikeRider_Tel){
        this.setBikeRider_ID(bikeRider_ID);
        this.setBike_NO(bike_NO);
        this.setBikeRiderF_Name(bikeRiderF_Name);
        this.setBikeRiderL_Name(bikeRiderL_Name);
        this.setBikeRider_Address(bikeRider_Address);
        this.setBikeRider_NicNO(bikeRider_NicNO);
        this.setBikeRider_Tel(bikeRider_Tel);
    }

    public int getBikeRider_ID() {
        return bikeRider_ID;
    }

    public void setBikeRider_ID(int bikeRider_ID) {
        this.bikeRider_ID = bikeRider_ID;
    }

    public String getBike_NO() {
        return bike_NO;
    }

    public void setBike_NO(String bike_NO) {
        this.bike_NO = bike_NO;
    }

    public String getBikeRiderF_Name() {
        return bikeRiderF_Name;
    }

    public void setBikeRiderF_Name(String bikeRiderF_Name) {
        this.bikeRiderF_Name = bikeRiderF_Name;
    }

    public String getBikeRiderL_Name() {
        return bikeRiderL_Name;
    }

    public void setBikeRiderL_Name(String bikeRiderL_Name) {
        this.bikeRiderL_Name = bikeRiderL_Name;
    }

    public String getBikeRider_Address() {
        return bikeRider_Address;
    }

    public void setBikeRider_Address(String bikeRider_Address) {
        this.bikeRider_Address = bikeRider_Address;
    }

    public String getBikeRider_NicNO() {
        return bikeRider_NicNO;
    }

    public void setBikeRider_NicNO(String bikeRider_NicNO) {
        this.bikeRider_NicNO = bikeRider_NicNO;
    }

    public int getBikeRider_Tel() {
        return bikeRider_Tel;
    }

    public void setBikeRider_Tel(int bikeRider_Tel) {
        this.bikeRider_Tel = bikeRider_Tel;
    }
}
