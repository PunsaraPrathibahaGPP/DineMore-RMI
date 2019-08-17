/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.dineMore.client.controller;

import java.net.URL;
import java.util.*;

import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import dto.PlaceOrderDTO;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.edu.ijse.dineMore.client.other.UserLogInData;
import lk.edu.ijse.dineMore.client.proxy.ProxyHandler;
import observer.Observer;
import service.ServiceFactory;
import service.custom.CustomerService;
import service.custom.OrderQueueService;
import service.custom.PlaceOrderService;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class ChefApplicationController implements Initializable, Observer {

    public TableView<PlaceOrderDTO> tblCustomerQueue;
    public JFXTextField txtCustomerFirstName;
    public JFXTextField txtCustomerLastName;
    public JFXTextField txtCustomerID;
    public JFXTextField txtOrderID;
    public JFXTextField txtOrderDate;
    public JFXTextField txtOrderTime;
    public JFXTextField txtAppointedTime;
    public JFXTextField txtFoodType;
    public JFXTextField txtAmmount;
    public Label lblChefID;
    @FXML
    private ImageView imgGoBack;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ImageView imgClose;

    private static CustomerService customerService=null;
    private static OrderQueueService orderQueueService=null;
    private static PlaceOrderService placeOrderService=null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            inotializeCustomerService();
            loadChefID();
            Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    try {
                        loadWaitingCustomerList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }),new KeyFrame(Duration.seconds(220)));
            newTimeLine.setCycleCount(Animation.INDEFINITE);
            newTimeLine.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadChefID() throws Exception {
        int chefID=UserLogInData.getEmployeeID();
        String employeeUserName=UserLogInData.getEmployeeUserName();
        String employeePassword=UserLogInData.getEmployeePassword();
        lblChefID.setText(""+chefID);
        PlaceOrderDTO placeOrderDTO=new PlaceOrderDTO(chefID,"CookingOrder");
    }

    private void inotializeCustomerService() throws Exception {
        if(customerService==null) {
            customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        }
        if(orderQueueService==null) {
            orderQueueService = (OrderQueueService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERQUEUE);
        }
        if(placeOrderService==null){
            placeOrderService= (PlaceOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PLACEORDER);
        }
    }

    private void loadWaitingCustomerList() throws Exception {
        tblCustomerQueue.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerID"));
        tblCustomerQueue.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("appointedTime"));
        tblCustomerQueue.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("status"));

        List<PlaceOrderDTO> allQueue = orderQueueService.getAllQueue();
        tblCustomerQueue.setItems(FXCollections.observableArrayList(allQueue));
    }

    @FXML
    private void imgGoBackClicked(MouseEvent event) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/dineMore/client/view/UserLogIn.fxml"));
        Scene scene = new Scene(root);
        Stage stage= (Stage) this.rootPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
        
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(800),scene.getRoot());
        translateTransition.setFromX(-scene.getWidth());
        translateTransition.setToX(0);
        translateTransition.play();
    }

    @FXML
    private void imgCloseClicked(MouseEvent event) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure you wish to Exit?", ButtonType.YES,ButtonType.NO);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Help_48px.png")));
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            System.exit(0);
        }else{
            alert.close();
        }
    }

    public void txtCustomerFirstNameOnAction(ActionEvent actionEvent) {

    }

    public void txtCustomerLastNameOnAction(ActionEvent actionEvent) {

    }

    public void txtOrderIDOnAction(ActionEvent actionEvent) {

    }

    public void txtOrderDateOnAction(ActionEvent actionEvent) {

    }

    public void txtOrderTimeOnAction(ActionEvent actionEvent) {

    }

    public void txtAppointedTimeOnAction(ActionEvent actionEvent) {

    }

    public void txtFoodTypeOnAction(ActionEvent actionEvent) {

    }

    public void txtAmmountOnAction(ActionEvent actionEvent) {

    }

    @Override
    public void updateObservers() throws Exception {

    }

    public void btnStartNewOrderOnAction(ActionEvent actionEvent) {
        try {
            PlaceOrderDTO queue = orderQueueService.getQueue();
            CustomerDTO customerDTO = customerService.searchCustomerByID(queue.getCustomerID());
            txtCustomerID.setText(""+customerDTO.getCustomerID());
            txtCustomerFirstName.setText(customerDTO.getCustomerF_Name());
            txtCustomerLastName.setText(customerDTO.getCustomerL_Name());

            PlaceOrderDTO placeOrderDTO = placeOrderService.searchOrder(queue.getCustomerID());
            txtOrderID.setText(""+placeOrderDTO.getOrderID());
            txtOrderDate.setText(placeOrderDTO.getOrderDate());
            txtOrderTime.setText(placeOrderDTO.getOrderTime());
            txtAppointedTime.setText(placeOrderDTO.getAppointedTime());
            txtFoodType.setText(placeOrderDTO.getFoodType());
            txtAmmount.setText(""+placeOrderDTO.getTotalAmmount());
            int chefID = Integer.parseInt(lblChefID.getText());
            System.out.println(chefID);

            PlaceOrderDTO updatePlaceOrder=new PlaceOrderDTO(chefID,"Cooking");
            boolean isUpdated = placeOrderService.updateChefOrderQueue(updatePlaceOrder,Integer.parseInt(txtOrderID.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnFinishUpOrderOnAction(ActionEvent actionEvent) {
        int chefID=Integer.parseInt(lblChefID.getText());
        PlaceOrderDTO updatePlaceOrder=new PlaceOrderDTO(chefID,"AfterKitchen");
        try {
            boolean isUpdated = placeOrderService.updateChefOrderQueue(updatePlaceOrder,Integer.parseInt(txtOrderID.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
