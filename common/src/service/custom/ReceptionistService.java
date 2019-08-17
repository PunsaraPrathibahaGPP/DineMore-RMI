package service.custom;

import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.EmployeeLogInDTO;
import dto.ReceptionistDTO;
import entity.Customer;
import entity.Receptionist;
import service.SuperService;

import java.util.List;

public interface ReceptionistService extends SuperService {

    public boolean addReceptionist(ReceptionistDTO receptionistDTO, EmployeeLogInDTO employeeLogInDTO)throws Exception;

    public boolean updateReceptionist(ReceptionistDTO receptionistDTO)throws Exception;

    public ReceptionistDTO searchReceptionist(String receptionistFirstName)throws Exception;

    public boolean deleteReceptionist(String receptionistFirstName)throws Exception;
}
