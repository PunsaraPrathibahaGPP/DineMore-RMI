package dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private int employeeID;
    private String employeeF_Name;
    private String employeeL_Name;
    private String employeeAddress;
    private String employeeNicNO;
    private int employeeTel;

    public EmployeeDTO(){}

    public EmployeeDTO(int employeeID,String employeeF_Name,String employeeL_Name,String employeeAddress,String employeeNicNO,int employeeTel){
        this.setEmployeeID(employeeID);
        this.setEmployeeF_Name(employeeF_Name);
        this.setEmployeeL_Name(employeeL_Name);
        this.setEmployeeAddress(employeeAddress);
        this.setEmployeeNicNO(employeeNicNO);
        this.setEmployeeTel(employeeTel);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeF_Name() {
        return employeeF_Name;
    }

    public void setEmployeeF_Name(String employeeF_Name) {
        this.employeeF_Name = employeeF_Name;
    }

    public String getEmployeeL_Name() {
        return employeeL_Name;
    }

    public void setEmployeeL_Name(String employeeL_Name) {
        this.employeeL_Name = employeeL_Name;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeNicNO() {
        return employeeNicNO;
    }

    public void setEmployeeNicNO(String employeeNicNO) {
        this.employeeNicNO = employeeNicNO;
    }

    public int getEmployeeTel() {
        return employeeTel;
    }

    public void setEmployeeTel(int employeeTel) {
        this.employeeTel = employeeTel;
    }
}
