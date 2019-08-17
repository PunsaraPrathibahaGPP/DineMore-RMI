package dto;

import java.io.Serializable;

public class ReceptionistDTO implements Serializable {
    private int receptionistID;
    private String receptionistF_Name;
    private String receptionistL_Name;
    private String receptionistAddress;
    private String receptionistNicNO;
    private int receptionistTel;

    public ReceptionistDTO(){}

    public ReceptionistDTO(int receptionistID, String receptionistF_Name, String receptionistL_Name, String receptionistAddress, String receptionistNicNO, int receptionistTel){
        this.setReceptionistID(receptionistID);
        this.setReceptionistF_Name(receptionistF_Name);
        this.setReceptionistL_Name(receptionistL_Name);
        this.setReceptionistAddress(receptionistAddress);
        this.setReceptionistNicNO(receptionistNicNO);
        this.setReceptionistTel(receptionistTel);
    }


    public int getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(int receptionistID) {
        this.receptionistID = receptionistID;
    }

    public String getReceptionistF_Name() {
        return receptionistF_Name;
    }

    public void setReceptionistF_Name(String receptionistF_Name) {
        this.receptionistF_Name = receptionistF_Name;
    }

    public String getReceptionistL_Name() {
        return receptionistL_Name;
    }

    public void setReceptionistL_Name(String receptionistL_Name) {
        this.receptionistL_Name = receptionistL_Name;
    }

    public String getReceptionistAddress() {
        return receptionistAddress;
    }

    public void setReceptionistAddress(String receptionistAddress) {
        this.receptionistAddress = receptionistAddress;
    }

    public String getReceptionistNicNO() {
        return receptionistNicNO;
    }

    public void setReceptionistNicNO(String receptionistNicNO) {
        this.receptionistNicNO = receptionistNicNO;
    }

    public int getReceptionistTel() {
        return receptionistTel;
    }

    public void setReceptionistTel(int receptionistTel) {
        this.receptionistTel = receptionistTel;
    }
}
