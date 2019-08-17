package service.custom;

import dto.CustomerDTO;
import dto.PlaceOrderDTO;
import service.SuperService;

public interface PlaceOrderService extends SuperService {
    public boolean addTOQueue(PlaceOrderDTO placeOrderDTO) throws Exception;

    public boolean addOrderService(CustomerDTO customerDTO,PlaceOrderDTO placeOrderDTO)throws Exception;

    public boolean updateOrder(PlaceOrderDTO placeOrderDTO,String customerNIC)throws Exception;

    public PlaceOrderDTO searchOrder(int customerID)throws Exception;

    public boolean deleteOrder(String customerNIC)throws Exception;

    public boolean updateChefOrderQueue(PlaceOrderDTO updatePlaceOrder,int orderID)throws Exception;

    public boolean updateBikeRiderQueue(PlaceOrderDTO updatePlaceOrder,int orderID)throws Exception;
}
