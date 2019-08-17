package service.custom;

import dto.PlaceOrderDTO;
import dto.TableViewDTO;
import service.SuperService;
import java.util.List;

public interface OrderQueueService extends SuperService {

    public boolean addToQueue(PlaceOrderDTO tableViewDTO) throws Exception;

    public boolean removeFromQueue(PlaceOrderDTO tableViewDTO) throws Exception;

    public PlaceOrderDTO getQueue() throws Exception;

    public List<PlaceOrderDTO> getAllQueue() throws Exception;

    public List<PlaceOrderDTO> getAllReceptionistViewQueue()throws Exception;

    public List<PlaceOrderDTO> getAllBikeRiderViewQueue()throws Exception;

}
