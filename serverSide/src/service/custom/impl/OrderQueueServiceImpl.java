package service.custom.impl;

import business.BoFactory;
import business.custom.OrderQueueBo;
import business.custom.PlaceOrderBo;
import dto.PlaceOrderDTO;
import service.custom.OrderQueueService;

import java.util.List;

public class OrderQueueServiceImpl implements OrderQueueService {
    private OrderQueueBo orderQueueBo=null;
    private PlaceOrderBo placeOrderBo=null;

    public OrderQueueServiceImpl(){
        if(orderQueueBo==null){
            orderQueueBo= (OrderQueueBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.ORDERQUEUE);
        }
        if(placeOrderBo==null){
            placeOrderBo= (PlaceOrderBo) BoFactory.getInstance().getBO(BoFactory.BOTypes.PLACEORDER);
        }
    }

    @Override
    public boolean addToQueue(PlaceOrderDTO tableViewDTO) throws Exception {
        return orderQueueBo.addToQueue(tableViewDTO);
    }

    @Override
    public boolean removeFromQueue(PlaceOrderDTO tableViewDTO) throws Exception {
        boolean result = orderQueueBo.removeFromQueue(tableViewDTO);
        return result;
    }

    @Override
    public PlaceOrderDTO getQueue() throws Exception {
        return orderQueueBo.getQueue();
    }

    @Override
    public List<PlaceOrderDTO> getAllQueue() throws Exception {
        return orderQueueBo.getAllQueue();
    }

    @Override
    public List<PlaceOrderDTO> getAllReceptionistViewQueue() throws Exception {
        return placeOrderBo.getAllReceptionistViewQueue();
    }

    @Override
    public List<PlaceOrderDTO> getAllBikeRiderViewQueue() throws Exception {
        return placeOrderBo.getAllBikeRiderViewQueue();
    }
}
