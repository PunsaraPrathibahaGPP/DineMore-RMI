package service.custom;

import dto.EmployeeLogInDTO;
import entity.EmployeeLogIn;
import service.SuperService;

public interface UserLogInService extends SuperService {
    public EmployeeLogInDTO searchEmployeeUserNamePassword(String userName,String password,String tableName)throws Exception;

    public EmployeeLogInDTO searchChefUserNamePassword(String userName,String password,String tableName)throws Exception;

    public EmployeeLogInDTO searchBikeRiderUserNamePassword(String userName,String password,String tableName)throws Exception;
}
