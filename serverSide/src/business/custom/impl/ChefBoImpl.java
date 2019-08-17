package business.custom.impl;

import business.custom.ChefBo;
import dto.ChefDTO;
import dto.EmployeeLogInDTO;
import entity.Chef;
import entity.EmployeeLogIn;
import entity.Receptionist;
import repository.RepositoryFactory;
import repository.custom.ChefRepository;
import resources.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public class ChefBoImpl implements ChefBo {
    private static ChefRepository chefRepositery;

    public ChefBoImpl(){
        initializeChefRepositery();
    }

    private void initializeChefRepositery(){
        chefRepositery= (ChefRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RespitoryTypes.CHEF);
    }

    @Override
    public boolean addChef(ChefDTO chefDTO, EmployeeLogInDTO employeeLogInDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        chefRepositery.setConnection(connection);
        connection.setAutoCommit(false);
        Chef chef=new Chef(chefDTO.getChefID(),chefDTO.getChefF_Name(),chefDTO.getChefL_Name(),chefDTO.getChefAddress(),chefDTO.getChef_NicNO(),chefDTO.getChefTel());
        boolean isChefistAdded = chefRepositery.save(chef);
        if(isChefistAdded){
            EmployeeLogIn employeeLogIn=new EmployeeLogIn(employeeLogInDTO.getEmployeeID(),employeeLogInDTO.getUserName(),employeeLogInDTO.getPassword());
            boolean isLoginDetailsAdded = chefRepositery.saveEmployeeLoginDetails(employeeLogIn);
            if(isLoginDetailsAdded) {
                connection.commit();
                return true;
            }
        }
        DBConnection.getInstance().releaseConnection(connection);
        return false;
    }

    @Override
    public boolean updateChef(ChefDTO chefDTO) throws Exception {
        System.out.println("Calling ChefBO.UpdateChef()");
        Connection connection=DBConnection.getInstance().getConnection();
        chefRepositery.setConnection(connection);
        Chef chef=new Chef(chefDTO.getChefID(),chefDTO.getChefF_Name(),chefDTO.getChefL_Name(),chefDTO.getChefAddress(),chefDTO.getChef_NicNO(),chefDTO.getChefTel());
        boolean isUpdated = chefRepositery.update(chef);
        DBConnection.getInstance().releaseConnection(connection);
        return isUpdated;
    }

    @Override
    public boolean deleteChef(String customerNic) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        chefRepositery.setConnection(connection);
        boolean isDeleted = chefRepositery.deleteChef(customerNic);
        DBConnection.getInstance().releaseConnection(connection);
        return isDeleted;
    }

    @Override
    public Chef searchChef(String customerFName) throws Exception {
        System.out.println("Calling ChefBoImpl.SearchChef()");
        Connection connection=DBConnection.getInstance().getConnection();
        chefRepositery.setConnection(connection);
        Chef chef = chefRepositery.searchByFirstName(customerFName);
        DBConnection.getInstance().releaseConnection(connection);
        System.out.println("returning ChefBoImpl.SearchChef()");
        return chef;
    }

    @Override
    public ArrayList<ChefDTO> getAllChef() throws Exception {
        return null;
    }

    @Override
    public boolean addToQueue(ChefDTO chefDTO) throws Exception {
        return false;
    }
}
