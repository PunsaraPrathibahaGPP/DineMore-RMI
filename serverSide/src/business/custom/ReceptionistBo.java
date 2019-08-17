package business.custom;

import business.SuperBo;
import dto.EmployeeDTO;
import dto.EmployeeLogInDTO;
import dto.ReceptionistDTO;
import entity.Receptionist;

import java.util.ArrayList;

public interface ReceptionistBo extends SuperBo {

    public boolean addReceptionist(ReceptionistDTO receptionistDTO, EmployeeLogInDTO employeeLogInDTO)throws Exception;
    public boolean updateReceptionist(ReceptionistDTO receptionistDTO)throws  Exception;
    public boolean deleteReceptionist(String receptionistFirstName)throws Exception;
    public Receptionist searchReceptionist(String receptionistFirstName)throws Exception;
    public ArrayList<EmployeeDTO> getAllReceptionists()throws Exception;
    public boolean addToQueue(EmployeeDTO receptionistDTO) throws Exception;

}
