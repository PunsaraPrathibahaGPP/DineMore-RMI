package business.custom.impl;

import business.custom.OrderQueueBo;
import business.custom.PlaceOrderBo;
import dto.CustomerDTO;
import dto.PlaceOrderDTO;
import entity.PlaceOrder;
import resources.DBConnection;
import resources.Queue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderQueueBoImpl implements OrderQueueBo {

    private List queueList=null;
    private static PlaceOrderBo placeOrderBo=null;

    public OrderQueueBoImpl() {

        queueList = Queue.getInstance().getQueueList();
        if(placeOrderBo==null){
            placeOrderBo=new PlaceOrderBoImpl();
        }
    }

    @Override
    public boolean addToQueue(PlaceOrderDTO tblViewDTO) throws Exception {
        return queueList.add(tblViewDTO);
    }

    @Override
    public boolean removeFromQueue(PlaceOrderDTO tblViewDTO) throws Exception {
        queueList.remove(0);
        return true;
    }

    //Gets the Very First Order From the Queue
    @Override
    public PlaceOrderDTO getQueue() throws Exception {
        System.out.println(" getQueue() In ORDERQUEUE BO IMPL");
        String sql="SELECT * FROM PlaceOrder WHERE status='WaitingList'";
        Connection connection= DBConnection.getInstance().getConnection();
        System.out.println("DBConnection.getInstance().getConnection() Called");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("connection.prepareStatement(sql)");
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("ResultSet resultSet = preparedStatement.executeQuery();");
        PlaceOrderDTO list=null;
        if (resultSet.next()){
            System.out.println("Looping...");
            list=new PlaceOrderDTO(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getDouble(10),resultSet.getString(11));
        }
        queueList.add(list);
        DBConnection.getInstance().releaseConnection(connection);
        return (PlaceOrderDTO) list;
    }

    @Override
    public List<PlaceOrderDTO> getAllQueue() throws Exception {
        return placeOrderBo.getAllOrders();
    }

}
