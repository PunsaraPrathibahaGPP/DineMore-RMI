package service.custom;

import dto.BikeRiderDTO;
import dto.ChefDTO;
import dto.EmployeeLogInDTO;
import service.SuperService;

public interface BikeRiderService extends SuperService {
    public boolean addBikeRider(BikeRiderDTO bikeRiderDTO, EmployeeLogInDTO employeeLogInDTO)throws Exception;

    public boolean updateBikeRider(BikeRiderDTO bikeRiderDTO)throws Exception;

    public BikeRiderDTO searchBikeRider(String bikeRiderFirstName)throws Exception;

    public boolean deleteBikeRider(String bikeRiderFirstName)throws Exception;
}
