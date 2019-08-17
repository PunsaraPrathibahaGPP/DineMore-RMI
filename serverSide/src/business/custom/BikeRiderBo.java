package business.custom;

import business.SuperBo;
import dto.BikeRiderDTO;
import dto.ChefDTO;
import dto.EmployeeLogInDTO;
import entity.BikeRider;
import entity.Chef;

import java.util.ArrayList;

public interface BikeRiderBo extends SuperBo {
    public boolean addBikeRider(BikeRiderDTO bikeRiderDTO, EmployeeLogInDTO employeeLogInDTO)throws Exception;
    public boolean updateBikeRider(BikeRiderDTO bikeRiderDTO)throws  Exception;
    public boolean deleteBikeRider(String bikeRiderFName)throws Exception;
    public BikeRider searchBikeRider(String bikeRiderFName)throws Exception;
    public ArrayList<BikeRiderDTO> getAllBikeRider()throws Exception;
    public boolean addToQueue(BikeRiderDTO bikeRiderDTO) throws Exception;
}
