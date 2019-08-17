package business.custom;

import business.SuperBo;
import entity.EmployeeLogIn;
import entity.Receptionist;

public interface UserLoginBo extends SuperBo {
    public EmployeeLogIn searchUserNamePassword(String userName,String password,String tableName)throws Exception;

    public EmployeeLogIn searchChefUserNamePassword(String userName,String password,String tableName)throws Exception;

    public EmployeeLogIn searchBikeRiderUserNamePassword(String userName,String password,String tableName)throws Exception;
}
