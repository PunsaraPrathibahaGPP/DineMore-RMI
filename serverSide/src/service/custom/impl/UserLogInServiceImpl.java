package service.custom.impl;

import business.custom.UserLoginBo;
import business.custom.impl.UserLogInBoImpl;
import dto.EmployeeLogInDTO;
import entity.EmployeeLogIn;
import service.custom.UserLogInService;

public class UserLogInServiceImpl implements UserLogInService {
    private static UserLoginBo userLoginBo=null;

    public UserLogInServiceImpl(){
        initializeUserLogInBo();
    }

    private void initializeUserLogInBo(){
        if(userLoginBo==null){
            userLoginBo=new UserLogInBoImpl();
        }
    }

    @Override
    public EmployeeLogInDTO searchEmployeeUserNamePassword(String userName,String password,String tableName) throws Exception {
        EmployeeLogIn employeeLogIn = userLoginBo.searchUserNamePassword(userName, password,tableName);
        EmployeeLogInDTO employeeLogInDTO=new EmployeeLogInDTO(employeeLogIn.getEmployeeID(),employeeLogIn.getUserName(),employeeLogIn.getPassword());
        return employeeLogInDTO;
    }

    @Override
    public EmployeeLogInDTO searchChefUserNamePassword(String userName, String password, String tableName) throws Exception {
        EmployeeLogIn employeeLogIn = userLoginBo.searchChefUserNamePassword(userName, password,tableName);
        EmployeeLogInDTO employeeLogInDTO=new EmployeeLogInDTO(employeeLogIn.getEmployeeID(),employeeLogIn.getUserName(),employeeLogIn.getPassword());
        return employeeLogInDTO;
    }

    @Override
    public EmployeeLogInDTO searchBikeRiderUserNamePassword(String userName, String password, String tableName) throws Exception {
        EmployeeLogIn employeeLogIn = userLoginBo.searchBikeRiderUserNamePassword(userName, password,tableName);
        EmployeeLogInDTO employeeLogInDTO=new EmployeeLogInDTO(employeeLogIn.getEmployeeID(),employeeLogIn.getUserName(),employeeLogIn.getPassword());
        return employeeLogInDTO;
    }
}
