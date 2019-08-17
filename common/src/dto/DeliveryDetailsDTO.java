package dto;

import java.io.Serializable;

public class DeliveryDetailsDTO implements Serializable {
    private int deliveryDetail_ID;
    private int bikeRider_ID;
    private int delivery_ID;

    public DeliveryDetailsDTO(){}

    public DeliveryDetailsDTO(int deliveryDetail_ID, int bikeRider_ID, int delivery_ID){
        this.setDeliveryDetail_ID(deliveryDetail_ID);
        this.setBikeRider_ID(bikeRider_ID);
        this.setDelivery_ID(delivery_ID);
    }

    public int getDeliveryDetail_ID() {
        return deliveryDetail_ID;
    }

    public void setDeliveryDetail_ID(int deliveryDetail_ID) {
        this.deliveryDetail_ID = deliveryDetail_ID;
    }

    public int getBikeRider_ID() {
        return bikeRider_ID;
    }

    public void setBikeRider_ID(int bikeRider_ID) {
        this.bikeRider_ID = bikeRider_ID;
    }

    public int getDelivery_ID() {
        return delivery_ID;
    }

    public void setDelivery_ID(int delivery_ID) {
        this.delivery_ID = delivery_ID;
    }
}
