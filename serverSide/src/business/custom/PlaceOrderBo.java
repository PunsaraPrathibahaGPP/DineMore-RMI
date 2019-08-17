package business.custom;

import business.SuperBo;
import dto.CustomerDTO;
import dto.PlaceOrderDTO;
import entity.Customer;
import entity.PlaceOrder;

import java.util.ArrayList;

public interface PlaceOrderBo extends SuperBo {
    public boolean addOrder(CustomerDTO customerDTO,PlaceOrderDTO placeOrderDTO)throws Exception;
    public boolean updateOrder(PlaceOrderDTO placeOrderDTO)throws  Exception;
    public boolean deleteOrder(String customerNic)throws Exception;
    public PlaceOrder searchOrder(int customerID)throws Exception;
    public ArrayList<PlaceOrderDTO> getAllOrders()throws Exception;
    public ArrayList<PlaceOrderDTO> getAllReceptionistViewQueue()throws  Exception;
    public ArrayList<PlaceOrderDTO> getAllBikeRiderViewQueue()throws Exception;
    public boolean addToQueue(PlaceOrderDTO placeOrderDTO) throws Exception;
    public boolean updateChefOrderQueue(PlaceOrderDTO updatePlaceOrderDTO,int orderID)throws Exception;
    public boolean updateBikeRiderQueue(PlaceOrderDTO updatePlaceOrderDTO,int orderID)throws Exception;
}
