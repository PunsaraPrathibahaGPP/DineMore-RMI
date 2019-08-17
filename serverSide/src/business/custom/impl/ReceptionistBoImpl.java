package business.custom.impl;

import business.custom.ReceptionistBo;
import dto.CustomerDTO;
import dto.EmployeeDTO;
import dto.EmployeeLogInDTO;
import dto.ReceptionistDTO;
import entity.Customer;
import entity.EmployeeLogIn;
import entity.Receptionist;
import repository.RepositoryFactory;
import repository.custom.CustomerRespitory;
import repository.custom.ReceptionistRepository;
import resources.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ReceptionistBoImpl implements ReceptionistBo {
    private ReceptionistRepository receptionistRepository=null;

    public ReceptionistBoImpl(){
        initializeReceptionistBo();
    }

    private void initializeReceptionistBo(){
        if(receptionistRepository==null) {
            receptionistRepository = (ReceptionistRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RespitoryTypes.RECEPTIONIST);
        }
    }

    @Override
    public boolean addReceptionist(ReceptionistDTO receptionistDTO, EmployeeLogInDTO employeeLogInDTO) throws Exception {
        System.out.println("ReceptionistBOImpl addReceptionist Called");
        Connection connection = DBConnection.getInstance().getConnection();
        receptionistRepository.setConnection(connection);
        connection.setAutoCommit(false);
        Receptionist receptionist=new Receptionist(receptionistDTO.getReceptionistID(),receptionistDTO.getReceptionistF_Name(),receptionistDTO.getReceptionistL_Name(),receptionistDTO.getReceptionistAddress(),receptionistDTO.getReceptionistNicNO(),receptionistDTO.getReceptionistTel());
        boolean isReceptionistAdded = receptionistRepository.save(receptionist);
        if(isReceptionistAdded){
            EmployeeLogIn employeeLogIn=new EmployeeLogIn(employeeLogInDTO.getEmployeeID(),employeeLogInDTO.getUserName(),employeeLogInDTO.getPassword());
            boolean isLoginDetailsAdded = receptionistRepository.saveEmployeeLoginDetails(employeeLogIn);
            if(isLoginDetailsAdded) {
                connection.commit();
                return true;
            }
        }
        DBConnection.getInstance().releaseConnection(connection);
        return false;
    }

    @Override
    public boolean updateReceptionist(ReceptionistDTO receptionistDTO) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        receptionistRepository.setConnection(connection);
        Receptionist receptionist=new Receptionist(receptionistDTO.getReceptionistID(),receptionistDTO.getReceptionistF_Name(),receptionistDTO.getReceptionistL_Name(),receptionistDTO.getReceptionistAddress(),receptionistDTO.getReceptionistNicNO(),receptionistDTO.getReceptionistTel());
        boolean isUpdated = receptionistRepository.update(receptionist);
        DBConnection.getInstance().releaseConnection(connection);
        return isUpdated;
    }

    @Override
    public boolean deleteReceptionist(String receptionistFirstName) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        receptionistRepository.setConnection(connection);
        boolean isDeleted = receptionistRepository.deleteReceptionist(receptionistFirstName);
        DBConnection.getInstance().releaseConnection(connection);
        return isDeleted;
    }

    @Override
    public Receptionist searchReceptionist(String receptionistFirstName) throws Exception {
        Connection connection=new DBConnection().getInstance().getConnection();
        receptionistRepository.setConnection(connection);
        Receptionist receptionist = receptionistRepository.searchByFirstName(receptionistFirstName);
        DBConnection.getInstance().releaseConnection(connection);
        return receptionist;
    }


    @Override
    public ArrayList<EmployeeDTO> getAllReceptionists() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        this.receptionistRepository.setConnection(connection);
        List<Receptionist> getAllReceptionists = this.receptionistRepository.getAll();
        ArrayList<EmployeeDTO> receptionistAll=new ArrayList<>();
        for (Receptionist receptionist:getAllReceptionists) {
            receptionistAll.add(new EmployeeDTO(receptionist.getReceptionistID_PK(),receptionist.getReceptionistF_Name(),receptionist.getReceptionistL_Name(),receptionist.getReceptionistAddress(),receptionist.getReceptionistNicNO(),receptionist.getReceptionistTel()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return receptionistAll;
    }

    @Override
    public boolean addToQueue(EmployeeDTO receptionistDTO) throws Exception {
        return false;
    }
}
