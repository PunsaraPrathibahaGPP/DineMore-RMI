package repository.custom;

import entity.Customer;
import entity.EmployeeLogIn;
import entity.Receptionist;
import repository.SuperRepository;

public interface ReceptionistRepository  extends SuperRepository<Receptionist, Integer> {

    public int getLastReceptionistID() throws Exception;

    public Receptionist searchByFirstName(String firstName)throws Exception;

    public boolean deleteReceptionist(String firstName)throws Exception;

    public boolean saveEmployeeLoginDetails(EmployeeLogIn employeeLogIn)throws Exception;

}
