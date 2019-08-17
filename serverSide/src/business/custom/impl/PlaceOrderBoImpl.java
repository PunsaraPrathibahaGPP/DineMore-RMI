package business.custom.impl;

import business.BoFactory;
import business.custom.PlaceOrderBo;
import dto.CustomerDTO;
import dto.PlaceOrderDTO;
import entity.Customer;
import entity.PlaceOrder;
import repository.RepositoryFactory;
import repository.custom.ChefRepository;
import repository.custom.CustomerRespitory;
import repository.custom.PlaceOrderRepositery;
import repository.custom.ReceptionistRepository;
import resources.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBoImpl implements PlaceOrderBo {

    private static PlaceOrderRepositery placeOrderRepositery=null;
    private static CustomerRespitory customerRespitory=null;
    private static ChefRepository chefRepository=null;
    private static ReceptionistRepository receptionistRepository=null;

    public PlaceOrderBoImpl(){
        if(placeOrderRepositery==null) {
            placeOrderRepositery = (PlaceOrderRepositery) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RespitoryTypes.PLACEORDER);
        }
        if(customerRespitory==null) {
            customerRespitory = (CustomerRespitory) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RespitoryTypes.CUSTOMER);
        }
        if(chefRepository==null){
            chefRepository= (ChefRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RespitoryTypes.CHEF);
        }
        if(receptionistRepository==null){
            receptionistRepository= (ReceptionistRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RespitoryTypes.RECEPTIONIST);
        }
    }

    @Override
    public boolean addOrder(CustomerDTO customerDTO,PlaceOrderDTO placeOrderDTO) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        customerRespitory.setConnection(connection);
        Customer customerEntity = new Customer(customerDTO.getCustomerID(), customerDTO.getCustomerF_Name(),customerDTO.getCustomerL_Name(),customerDTO.getCustomerAddress(),customerDTO.getCustomerNicNO(), customerDTO.getCustomerTel());
        boolean isCustomerSaved = customerRespitory.save(customerEntity);

        if(isCustomerSaved) {
            placeOrderRepositery.setConnection(connection);
            PlaceOrder placeOrder = new PlaceOrder(placeOrderDTO.getOrderID(), placeOrderDTO.getCustomerID(), placeOrderDTO.getReceptionistID(),placeOrderDTO.getChefID(),placeOrderDTO.getBikeRiderID(), placeOrderDTO.getOrderDate(), placeOrderDTO.getOrderTime(), placeOrderDTO.getAppointedTime(), placeOrderDTO.getFoodType(), placeOrderDTO.getTotalAmmount(),placeOrderDTO.getStatus());
            boolean isOrderSaved = placeOrderRepositery.save(placeOrder);
            if(isOrderSaved){
                connection.commit();
                return true;
            }
        }
        DBConnection.getInstance().releaseConnection(connection);
        return false;
    }

    @Override
    public boolean updateOrder(PlaceOrderDTO placeOrderDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteOrder(String customerNic) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        customerRespitory.setConnection(connection);
        Customer customer=new Customer(1,"","","",customerNic,1);
        boolean isDeleted = customerRespitory.delete(customer);
        if(isDeleted){
           //placeOrderRepositery.delete(byNICNO.getCustomerID_PK())
        }

        connection.commit();
        DBConnection.getInstance().releaseConnection(connection);
        return isDeleted;
    }

    @Override
    public PlaceOrder searchOrder(int customerID) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        PlaceOrder placeOrder = placeOrderRepositery.searchOrderByCustomerNIC(customerID);
        DBConnection.getInstance().releaseConnection(connection);
        return placeOrder;
    }

    @Override
    public ArrayList<PlaceOrderDTO> getAllOrders() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        chefRepository.setConnection(connection);
        List<PlaceOrder> getAllPlaceOrder = chefRepository.getAllChefOrderQueue();
        ArrayList<PlaceOrderDTO> placeOrderDTOS=new ArrayList<>();
        for (PlaceOrder placeOrder:getAllPlaceOrder) {
            placeOrderDTOS.add(new PlaceOrderDTO(placeOrder.getOrderID_PK(),placeOrder.getCustomerID_FK(),placeOrder.getReceptionistID_FK(),placeOrder.getChefID_FK(),placeOrder.getBikeRiderID_FK(),placeOrder.getOrderDate(),placeOrder.getOrderTime(),placeOrder.getAppointedTime(),placeOrder.getFoodType(),placeOrder.getTotalAmmount(),placeOrder.getStatus()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return placeOrderDTOS;
    }

    @Override
    public ArrayList<PlaceOrderDTO> getAllReceptionistViewQueue() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        placeOrderRepositery.setConnection(connection);
        List<PlaceOrder> getAllPlaceOrder = placeOrderRepositery.getReceptionistQueue();
        ArrayList<PlaceOrderDTO> placeOrderDTOS=new ArrayList<>();
        for (PlaceOrder placeOrder:getAllPlaceOrder) {
            placeOrderDTOS.add(new PlaceOrderDTO(placeOrder.getOrderID_PK(),placeOrder.getCustomerID_FK(),placeOrder.getReceptionistID_FK(),placeOrder.getChefID_FK(),placeOrder.getBikeRiderID_FK(),placeOrder.getOrderDate(),placeOrder.getOrderTime(),placeOrder.getAppointedTime(),placeOrder.getFoodType(),placeOrder.getTotalAmmount(),placeOrder.getStatus()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return placeOrderDTOS;
    }

    @Override
    public ArrayList<PlaceOrderDTO> getAllBikeRiderViewQueue() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        placeOrderRepositery.setConnection(connection);
        List<PlaceOrder> getAllPlaceOrder = placeOrderRepositery.getBikeRiderQueue();
        ArrayList<PlaceOrderDTO> placeOrderDTOS=new ArrayList<>();
        for (PlaceOrder placeOrder:getAllPlaceOrder) {
            placeOrderDTOS.add(new PlaceOrderDTO(placeOrder.getOrderID_PK(),placeOrder.getCustomerID_FK(),placeOrder.getReceptionistID_FK(),placeOrder.getChefID_FK(),placeOrder.getBikeRiderID_FK(),placeOrder.getOrderDate(),placeOrder.getOrderTime(),placeOrder.getAppointedTime(),placeOrder.getFoodType(),placeOrder.getTotalAmmount(),placeOrder.getStatus()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return placeOrderDTOS;
    }

    @Override
    public boolean addToQueue(PlaceOrderDTO placeOrderDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateChefOrderQueue(PlaceOrderDTO updatePlaceOrderDTO, int orderID) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        this.placeOrderRepositery.setConnection(connection);
        return placeOrderRepositery.updateChefCustomerQueue(updatePlaceOrderDTO, orderID);
    }

    @Override
    public boolean updateBikeRiderQueue(PlaceOrderDTO updatePlaceOrderDTO, int orderID) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        this.placeOrderRepositery.setConnection(connection);
        return placeOrderRepositery.updateBikeRiderCustomerQueue(updatePlaceOrderDTO, orderID);
    }
}
