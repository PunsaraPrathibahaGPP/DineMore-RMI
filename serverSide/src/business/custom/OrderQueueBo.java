package business.custom;

import business.SuperBo;
import dto.PlaceOrderDTO;

import java.util.List;

public interface OrderQueueBo extends SuperBo {

    public boolean addToQueue(PlaceOrderDTO tblViewDTO) throws Exception;

    public boolean removeFromQueue(PlaceOrderDTO tblViewDTO) throws Exception;

    public PlaceOrderDTO getQueue() throws Exception;

    public List<PlaceOrderDTO> getAllQueue() throws Exception;
}
