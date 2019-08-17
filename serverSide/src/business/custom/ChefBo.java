package business.custom;

import business.SuperBo;
import dto.ChefDTO;
import dto.CustomerDTO;
import dto.EmployeeLogInDTO;
import entity.Chef;
import entity.Customer;
import entity.EmployeeLogIn;

import java.util.ArrayList;

public interface ChefBo extends SuperBo {
    public boolean addChef(ChefDTO chefDTO, EmployeeLogInDTO employeeLogInDTO)throws Exception;
    public boolean updateChef(ChefDTO chefDTO)throws  Exception;
    public boolean deleteChef(String customerFName)throws Exception;
    public Chef searchChef(String customerFName)throws Exception;
    public ArrayList<ChefDTO> getAllChef()throws Exception;
    public boolean addToQueue(ChefDTO chefDTO) throws Exception;
}
