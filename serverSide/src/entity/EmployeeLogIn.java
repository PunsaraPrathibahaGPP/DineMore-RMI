package entity;

public class EmployeeLogIn {
    private int employeeID;
    private String userName;
    private String password;

    public EmployeeLogIn(){}

    public EmployeeLogIn(String userName,String password){
        this.userName=userName;
        this.password=password;
    }

    public  EmployeeLogIn(int employeeID,String userName,String password){
        this.setEmployeeID(employeeID);
        this.setUserName(userName);
        this.setPassword(password);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
