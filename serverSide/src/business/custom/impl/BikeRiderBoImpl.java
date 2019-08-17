package business.custom.impl;

import business.custom.BikeRiderBo;
import dto.BikeRiderDTO;
import dto.EmployeeLogInDTO;
import entity.BikeRider;
import entity.Chef;
import entity.EmployeeLogIn;
import repository.RepositoryFactory;
import repository.custom.BikeRiderRepository;
import resources.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public class BikeRiderBoImpl implements BikeRiderBo {
    private static BikeRiderRepository bikeRiderRepository=null;

    public BikeRiderBoImpl(){
        initializeBikeRiderRepository();
    }

    private  void initializeBikeRiderRepository(){
        if(bikeRiderRepository==null){
            bikeRiderRepository= (BikeRiderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RespitoryTypes.BIKERIDER);
        }
    }

    @Override
    public boolean addBikeRider(BikeRiderDTO bikeRiderDTO, EmployeeLogInDTO employeeLogInDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        bikeRiderRepository.setConnection(connection);
        connection.setAutoCommit(false);
        BikeRider bikeRider=new BikeRider(bikeRiderDTO.getBikeRider_ID(),"SD8567",bikeRiderDTO.getBikeRiderF_Name(),bikeRiderDTO.getBikeRiderL_Name(),bikeRiderDTO.getBikeRider_Address(),bikeRiderDTO.getBikeRider_NicNO(),bikeRiderDTO.getBikeRider_Tel());
        boolean isChefistAdded = bikeRiderRepository.save(bikeRider);
        if(isChefistAdded){
            EmployeeLogIn employeeLogIn=new EmployeeLogIn(employeeLogInDTO.getEmployeeID(),employeeLogInDTO.getUserName(),employeeLogInDTO.getPassword());
            boolean isLoginDetailsAdded = bikeRiderRepository.saveEmployeeLoginDetails(employeeLogIn);
            if(isLoginDetailsAdded) {
                connection.commit();
                return true;
            }
        }
        DBConnection.getInstance().releaseConnection(connection);
        return false;
    }

    @Override
    public boolean updateBikeRider(BikeRiderDTO bikeRiderDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteBikeRider(String bikeRiderFName) throws Exception {
        return false;
    }

    @Override
    public BikeRider searchBikeRider(String bikeRiderFName) throws Exception {
        return null;
    }

    @Override
    public ArrayList<BikeRiderDTO> getAllBikeRider() throws Exception {
        return null;
    }

    @Override
    public boolean addToQueue(BikeRiderDTO bikeRiderDTO) throws Exception {
        return false;
    }
}
