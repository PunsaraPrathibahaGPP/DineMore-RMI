package lk.edu.ijse.dineMore.client.other;

public class UserLogInData {
    private static int employeeID;
    private static String employeeUserName;
    private static String employeePassword;

    public UserLogInData(){}

    public UserLogInData(int employeeID,String employeeUserName,String employeePassword){
        this.setEmployeeID(employeeID);
        this.setEmployeeUserName(employeeUserName);
        this.setEmployeePassword(employeePassword);
    }

    public static int getEmployeeID() {
        return employeeID;
    }

    public static void setEmployeeID(int employeeID) {
        UserLogInData.employeeID = employeeID;
    }

    public static String getEmployeeUserName() {
        return employeeUserName;
    }

    public static void setEmployeeUserName(String employeeUserName) {
        UserLogInData.employeeUserName = employeeUserName;
    }

    public static String getEmployeePassword() {
        return employeePassword;
    }

    public static void setEmployeePassword(String employeePassword) {
        UserLogInData.employeePassword = employeePassword;
    }
}
