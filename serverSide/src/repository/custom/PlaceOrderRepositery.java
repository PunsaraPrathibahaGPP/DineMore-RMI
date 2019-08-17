package repository.custom;

import dto.PlaceOrderDTO;
import entity.PlaceOrder;
import repository.SuperRepository;

import java.util.ArrayList;

public interface PlaceOrderRepositery extends SuperRepository<PlaceOrder,Integer> {
    public int getLastOrderID() throws Exception;

    public PlaceOrder searchOrderByCustomerNIC(int customerID)throws Exception;

    public boolean updateChefCustomerQueue(PlaceOrderDTO updatePlaceOrderDTO,int orderID)throws Exception;

    public ArrayList<PlaceOrder> getReceptionistQueue()throws Exception;

    public ArrayList<PlaceOrder> getBikeRiderQueue()throws Exception;

    public boolean updateBikeRiderCustomerQueue(PlaceOrderDTO updatePlaceOrderDTO,int orderID)throws Exception;
}
