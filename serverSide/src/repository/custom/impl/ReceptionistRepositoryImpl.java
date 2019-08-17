package repository.custom.impl;

import dto.EmployeeDTO;
import entity.EmployeeLogIn;
import entity.Receptionist;
import repository.custom.ReceptionistRepository;
import resources.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReceptionistRepositoryImpl implements ReceptionistRepository {
    private static Connection connection;

    @Override
    public int getLastReceptionistID() throws Exception {
        return 0;
    }
    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }

    @Override
    public Receptionist searchByFirstName(String firstName) throws Exception {
        String sql="SELECT * FROM Receptionist WHERE receptionistF_Name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,firstName);
        ResultSet resultSet = preparedStatement.executeQuery();
        Receptionist receptionist=null;
        while (resultSet.next()){
            receptionist=new Receptionist(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
        }
        return  receptionist;
    }

    @Override
    public boolean deleteReceptionist(String firstName) throws Exception {
        String sql="DELETE FROM Receptionist WHERE receptionistF_Name=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1,firstName);
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean saveEmployeeLoginDetails(EmployeeLogIn employeeLogIn) throws Exception {
        String sql = "INSERT INTO ReceptionistLogIn values (?,?,?)";
        PreparedStatement prst = connection.prepareStatement(sql);
        prst.setObject(1, employeeLogIn.getEmployeeID());
        prst.setObject(2, employeeLogIn.getUserName());
        prst.setObject(3, employeeLogIn.getPassword());
        return prst.executeUpdate() > 0;
    }

    @Override
    public boolean save(Receptionist receptionist) throws Exception {
        String sql = "INSERT INTO receptionist values (?,?,?,?,?,?)";
        PreparedStatement prst = connection.prepareStatement(sql);
        prst.setObject(1, receptionist.getReceptionistID_PK());
        prst.setObject(2, receptionist.getReceptionistF_Name());
        prst.setObject(3, receptionist.getReceptionistL_Name());
        prst.setObject(4, receptionist.getReceptionistAddress());
        prst.setObject(5, receptionist.getReceptionistNicNO());
        prst.setObject(6, receptionist.getReceptionistTel());
        return prst.executeUpdate() > 0;
    }

    @Override
    public boolean update(Receptionist receptionist) throws Exception {
        String sql="UPDATE Receptionist SET receptionistL_Name =?, receptionistAddress =?,  receptionistNicNO =?, receptionistTel =?  WHERE receptionistF_Name = ? ;";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setObject(1,receptionist.getReceptionistL_Name());
        preparedStatement.setObject(2,receptionist.getReceptionistAddress());
        preparedStatement.setObject(3,receptionist.getReceptionistNicNO());
        preparedStatement.setObject(4,receptionist.getReceptionistTel());
        preparedStatement.setObject(5,receptionist.getReceptionistF_Name());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean delete(Receptionist receptionist) throws Exception {
        return false;
    }

    @Override
    public Receptionist findByNICNO(Receptionist receptionist) throws Exception {
        return null;
    }

    @Override
    public List<Receptionist> getAll() throws Exception {
        String sql="SELECT * FROM Receptionist";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Receptionist> receptionist=new ArrayList<>();
        while (resultSet.next()){
            receptionist.add(new Receptionist(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6)));
        }
        return receptionist;
    }
}
