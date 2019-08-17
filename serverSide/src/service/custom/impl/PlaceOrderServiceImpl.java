package service.custom.impl;

import business.BoFactory;
import business.custom.PlaceOrderBo;
import dto.CustomerDTO;
import dto.PlaceOrderDTO;
import entity.PlaceOrder;
import service.custom.PlaceOrderService;

public class PlaceOrderServiceImpl implements PlaceOrderService {
    private static PlaceOrderBo placeOrderBo=null;

    public PlaceOrderServiceImpl(){
        initializePlaceOrderService();
    }

    private void initializePlaceOrderService(){
        if(placeOrderBo==null){
            placeOrderBo= (PlaceOrderBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.PLACEORDER);
        }
    }

    @Override
    public boolean addTOQueue(PlaceOrderDTO placeOrderDTO) throws Exception {
        return false;
    }

    @Override
    public boolean addOrderService(CustomerDTO customerDTO, PlaceOrderDTO placeOrderDTO) throws Exception {
        return placeOrderBo.addOrder(customerDTO,placeOrderDTO);
    }

    @Override
    public boolean updateOrder(PlaceOrderDTO placeOrderDTO, String customerNIC) throws Exception {
        return false;
    }

    @Override
    public PlaceOrderDTO searchOrder(int customerID) throws Exception {
        PlaceOrder placeOrder = placeOrderBo.searchOrder(customerID);
        PlaceOrderDTO placeOrderDTO=new PlaceOrderDTO(placeOrder.getOrderID_PK(),placeOrder.getCustomerID_FK(),placeOrder.getReceptionistID_FK(),placeOrder.getChefID_FK(),placeOrder.getBikeRiderID_FK(),placeOrder.getOrderDate(),placeOrder.getOrderTime(),placeOrder.getAppointedTime(),placeOrder.getFoodType(),placeOrder.getTotalAmmount(),placeOrder.getStatus());
        return placeOrderDTO;
    }

    @Override
    public boolean deleteOrder(String customerNIC) throws Exception {
        return placeOrderBo.deleteOrder(customerNIC);
    }

    @Override
    public boolean updateChefOrderQueue(PlaceOrderDTO updatePlaceOrderDTO, int orderID) throws Exception {
        return placeOrderBo.updateChefOrderQueue(updatePlaceOrderDTO, orderID);
    }

    @Override
    public boolean updateBikeRiderQueue(PlaceOrderDTO updatePlaceOrder, int orderID) throws Exception {
        return placeOrderBo.updateBikeRiderQueue(updatePlaceOrder,orderID);
    }
}
