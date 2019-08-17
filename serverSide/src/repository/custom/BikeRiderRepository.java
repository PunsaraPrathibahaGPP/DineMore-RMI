package repository.custom;

import entity.BikeRider;
import entity.Chef;
import entity.EmployeeLogIn;
import repository.SuperRepository;

public interface BikeRiderRepository extends SuperRepository<BikeRider, Integer> {
    public int getLastChefID() throws Exception;

    public BikeRider searchByFirstName(String firstName)throws Exception;

    public boolean deleteBikeRider(String firstName)throws Exception;

    public boolean saveEmployeeLoginDetails(EmployeeLogIn employeeLogIn)throws Exception;
}