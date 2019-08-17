package repository.custom.impl;

import entity.BikeRider;
import entity.EmployeeLogIn;
import repository.custom.BikeRiderRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class BikeRiderRepositoryImpl implements BikeRiderRepository {
    private static Connection connection;

    @Override
    public int getLastChefID() throws Exception {
        return 0;
    }

    @Override
    public BikeRider searchByFirstName(String firstName) throws Exception {
        return null;
    }

    @Override
    public boolean deleteBikeRider(String firstName) throws Exception {
        return false;
    }

    @Override
    public boolean saveEmployeeLoginDetails(EmployeeLogIn employeeLogIn) throws Exception {
        String sql = "INSERT INTO bikeRiderLogIn values (?,?,?)";
        PreparedStatement prst = connection.prepareStatement(sql);
        prst.setObject(1, employeeLogIn.getEmployeeID());
        prst.setObject(2, employeeLogIn.getUserName());
        prst.setObject(3, employeeLogIn.getPassword());
        return prst.executeUpdate() > 0;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }

    @Override
    public boolean save(BikeRider bikeRider) throws Exception {
        String sql="INSERT INTO BikeRider VALUES(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,bikeRider.getBikeRider_ID_PK());
        preparedStatement.setObject(2,bikeRider.getBike_NO());
        preparedStatement.setObject(3,bikeRider.getBikeRiderF_Name());
        preparedStatement.setObject(4,bikeRider.getBikeRiderL_Name());
        preparedStatement.setObject(5,bikeRider.getBikeRider_Address());
        preparedStatement.setObject(6,bikeRider.getBikeRider_NicNO());
        preparedStatement.setObject(7,bikeRider.getBikeRider_Tel());
        return preparedStatement.executeUpdate()>0;


    }

    @Override
    public boolean update(BikeRider bikeRider) throws Exception {
        return false;
    }

    @Override
    public boolean delete(BikeRider bikeRider) throws Exception {
        return false;
    }

    @Override
    public BikeRider findByNICNO(BikeRider bikeRider) throws Exception {
        return null;
    }

    @Override
    public List<BikeRider> getAll() throws Exception {
        return null;
    }
}
