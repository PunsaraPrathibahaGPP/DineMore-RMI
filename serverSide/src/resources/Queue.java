package resources;

import dto.PlaceOrderDTO;

import java.util.ArrayList;

public class Queue {
    private static Queue queue;
    private ArrayList<PlaceOrderDTO> queueList;


    public Queue() {
        queueList=new ArrayList<>();
    }

    public static Queue getInstance(){
        if(queue==null){
            queue=new Queue();
        }
        return queue;
    }

    public ArrayList getQueueList(){
        return queueList;
    }
}
