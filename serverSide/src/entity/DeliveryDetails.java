package entity;

public class DeliveryDetails {
    private int deliveryDetail_ID_PK;
    private int bikeRider_ID_FK;
    private int delivery_ID_FK;

    public DeliveryDetails(){}

    public DeliveryDetails(int deliveryDetail_ID_PK,int bikeRider_ID_FK,int delivery_ID_FK){
        this.setDeliveryDetail_ID_PK(deliveryDetail_ID_PK);
        this.setBikeRider_ID_FK(bikeRider_ID_FK);
        this.setDelivery_ID_FK(delivery_ID_FK);
    }

    public int getDeliveryDetail_ID_PK() {
        return deliveryDetail_ID_PK;
    }

    public void setDeliveryDetail_ID_PK(int deliveryDetail_ID_PK) {
        this.deliveryDetail_ID_PK = deliveryDetail_ID_PK;
    }

    public int getBikeRider_ID_FK() {
        return bikeRider_ID_FK;
    }

    public void setBikeRider_ID_FK(int bikeRider_ID_FK) {
        this.bikeRider_ID_FK = bikeRider_ID_FK;
    }

    public int getDelivery_ID_FK() {
        return delivery_ID_FK;
    }

    public void setDelivery_ID_FK(int delivery_ID_FK) {
        this.delivery_ID_FK = delivery_ID_FK;
    }
}
