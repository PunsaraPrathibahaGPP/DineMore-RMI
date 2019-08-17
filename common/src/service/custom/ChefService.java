package service.custom;

import dto.ChefDTO;
import dto.EmployeeLogInDTO;
import dto.ReceptionistDTO;
import service.SuperService;

public interface ChefService extends SuperService {

    public boolean addChef(ChefDTO chefDTO, EmployeeLogInDTO employeeLogInDTO)throws Exception;

    public boolean updateChef(ChefDTO chefDTO)throws Exception;

    public ChefDTO searchChef(String chefFirstName)throws Exception;

    public boolean deleteChef(String chefFirstName)throws Exception;
}


