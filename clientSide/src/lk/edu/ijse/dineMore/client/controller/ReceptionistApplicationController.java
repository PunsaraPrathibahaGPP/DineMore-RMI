/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.dineMore.client.controller;

import java.awt.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import business.custom.CustomerBo;
import business.custom.impl.CustomerBoImpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import dto.FoodDTO;
import dto.PlaceOrderDTO;
import entity.Customer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.edu.ijse.dineMore.client.other.IDGenerator;
import lk.edu.ijse.dineMore.client.other.UserLogInData;
import lk.edu.ijse.dineMore.client.proxy.ProxyHandler;
import observer.Observer;
import service.ServiceFactory;
import service.custom.CustomerService;
import service.custom.FoodService;
import service.custom.OrderQueueService;
import service.custom.PlaceOrderService;
import service.custom.impl.FoodServiceImpl;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class ReceptionistApplicationController implements Initializable, Observer {
    public JFXTextField txtCustomerFirstName;
    public JFXTextField txtCustomerLastName;
    public JFXTextField txtCustomerNicNO;
    public JFXTextField txtCustomerAddress;
    public JFXTextField txtCustomerMobileNO;
    public JFXTextField txtOrderID;
    public JFXTextField txtCustomerSalary;
    public JFXTextField txtOrderDate;
    public JFXTextField txtOrderTime;
    public JFXTextField txtAppointedTime;
    public JFXTextField txtFoodType;
    public JFXTextField txtAmmount;
    public JFXButton btnPlaceOrder;
    public JFXButton btnDelete;
    public JFXButton btnClear;
    public JFXButton btnSearch;
    public JFXButton btnUpdate;
    public TableView<PlaceOrderDTO> tblOrderStatus;
    public TableView<CustomerDTO> tblViewCustomerDetails;
    public Pane orderPanel;
    public Pane customerPanel;
    public Image imgMiniMize;
    public JFXTextField txtNoOfFoodOrders;
    public JFXTextField txtFirstFoodType;
    public JFXTextField txtFirstFoodTypeAmmount;
    public JFXTextField txtSecondFoodType;
    public JFXTextField txtSecondFoodTypeAmmount;
    public JFXTextField txtThirdFoodType;
    public JFXTextField txtThirdFoodTypeAmmount;
    public JFXTextField txtAmmount121;
    public JFXTextField txtCustomerID;
    public Label lblReceptionistID;
    public JFXTextField txtTotalAmmount;
    public JFXComboBox cmbFirstFoodType;
    public JFXComboBox cmbSecondFoodType;
    public JFXComboBox cmbThirdFoodType;
    public JFXTextField txtTotalPrice;
    @FXML
    private ImageView imgGoBack;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ImageView imgClose;

    private  double totalPrice=0;

    private static CustomerService customerService=null;
    private static OrderQueueService orderQueueService=null;
    private static PlaceOrderService placeOrderService=null;
    private static FoodService foodService=null;
    private ObservableList<PlaceOrderDTO> tblData;
//    private ObservableArray<Customer> customerData;
    private Customer customer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadCustomerService();
            manageComponents();
            loadReceptionistID();

            Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    try {
                        loadWaitingCustomerList();
                        loadCustomerDetailTable();
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

    @Override
    public void updateObservers() throws Exception {

    }

    private void loadReceptionistID(){
        lblReceptionistID.setText(""+UserLogInData.getEmployeeID());
        String employeeUserName=UserLogInData.getEmployeeUserName();
        String employeePassword=UserLogInData.getEmployeePassword();
    }

    private void loadWaitingCustomerList() throws Exception {
        tblOrderStatus.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerID"));
        tblOrderStatus.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("appointedTime"));
        tblOrderStatus.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("status"));

        List<PlaceOrderDTO> allQueue = orderQueueService.getAllReceptionistViewQueue();
        tblOrderStatus.setItems(FXCollections.observableArrayList(allQueue));
    }

    private void manageComponents() throws Exception {
        loadIDs();
        loadDateTime();
        loadComboBoxes();
        txtCustomerNicNO.requestFocus();
    }

    private void loadComboBoxes() throws Exception {
        ArrayList<FoodDTO> allFood = foodService.getAllFood();
        cmbFirstFoodType.getItems().clear();
        for (FoodDTO foodDTO : foodService.getAllFood()) {
            cmbFirstFoodType.getItems().add(foodDTO.getFoodDescription());
            cmbSecondFoodType.getItems().add(foodDTO.getFoodDescription());
            cmbThirdFoodType.getItems().add(foodDTO.getFoodDescription());
        }
        txtCustomerNicNO.requestFocus();
    }

    private void loadIDs() throws Exception {
        String customerNextID;
        customerNextID = IDGenerator.getNewID("customer", "customerID","C-000");
        txtCustomerID.setText(customerNextID);
        txtCustomerID.setDisable(true);

        String orderNextID;
        orderNextID = IDGenerator.getNewID("placeOrder", "orederID","O-000");
        txtOrderID.setText(orderNextID);
        txtOrderID.setDisable(true);
    }

    private void loadDateTime(){
        txtOrderDate.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
        txtOrderDate.setFocusTraversable(false);
        txtOrderDate.setDisable(true);

        txtOrderTime.setDisable(true);
        Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                txtOrderTime.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
                txtOrderTime.setFocusTraversable(false);
                txtOrderTime.setDisable(true);
            }

        }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }

    private void loadCustomerDetailTable() throws Exception {
        tblViewCustomerDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerID"));
        tblViewCustomerDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("customerF_Name"));
        tblViewCustomerDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("customerL_Name"));
        tblViewCustomerDetails.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("customerAddress"));
        tblViewCustomerDetails.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("customerNicNO"));
        tblViewCustomerDetails.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("customerTel"));
        CustomerBo customerBo = new CustomerBoImpl();
        ArrayList<CustomerDTO> customerDTO = customerBo.getAllCustomer();
        tblViewCustomerDetails.setItems(FXCollections.observableArrayList(customerDTO));
    }

    private void loadCustomerService() throws Exception {
        System.out.println("Customer Service Instance Initializing...");
        if(customerService==null) {
            customerService = (CustomerService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
        }
        if(orderQueueService==null) {
            orderQueueService = (OrderQueueService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERQUEUE);
        }
        if(placeOrderService==null){
            placeOrderService= (PlaceOrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PLACEORDER);
        }
        if(foodService==null){
            foodService=new FoodServiceImpl();
        }

        System.out.println("Customer Service Instance Initialized Successfully...");
    }

    @FXML
    private void imgGoBackClicked(MouseEvent event) throws Exception{
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
    private void imgCloseClicked(MouseEvent event){
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

    public void btnPlaceOrderOnAction(ActionEvent actionEvent){
        try {
            placeOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        removePlaceOrder();
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        clearAllFields();
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        searchPlaceOrder();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        updatePlaceOrder();
    }

    private void placeOrder(){
        try {
            makeOrder();
            loadWaitingCustomerList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updatePlaceOrder(){
        updateCustomer();
    }

    private  void searchPlaceOrder(){
        searchCustomer();
    }

    private void removePlaceOrder(){
        try {
            deleteOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addToQueue() throws Exception {
        int customerID=Integer.parseInt(txtCustomerID.getText().split("C-000")[1]);
        int orderID=Integer.parseInt(txtOrderID.getText().split("O-000")[1]);
        PlaceOrderDTO tblViewDTO = new PlaceOrderDTO(
                orderID,
                customerID,
                txtOrderTime.getText(),
                txtAppointedTime.getText(),
                "WaitingList"
        );
        orderQueueService.addToQueue(tblViewDTO);
    }

    private  CustomerDTO saveCustomer(){
        int customerID=Integer.parseInt(txtCustomerID.getText().split("C-000")[1]);
        String customerFirstName=txtCustomerFirstName.getText();
        String customerLastName=txtCustomerLastName.getText();
        String customerAddress=txtCustomerAddress.getText();
        String customerNicNo=txtCustomerNicNO.getText();
        int customerMobileNo=Integer.parseInt(txtCustomerMobileNO.getText());
        CustomerDTO customerDTO=new CustomerDTO(customerID,customerFirstName,customerLastName,customerAddress,customerNicNo,customerMobileNo);
        return customerDTO;
    }

    private void makeOrder(){
        int customerID=Integer.parseInt(txtCustomerID.getText().split("C-000")[1]);
        int orderID=Integer.parseInt(txtOrderID.getText().split("O-000")[1]);
        String orderDate=txtOrderDate.getText();
        String orderTime=txtOrderTime.getText();
        String appointedTime=txtAppointedTime.getText();
        String foodType=txtFoodType.getText();
        double totalAmmount=Double.parseDouble(""+txtTotalPrice.getText());


        int receptionistID=Integer.parseInt(lblReceptionistID.getText());
        PlaceOrderDTO placeOrderDTO=new PlaceOrderDTO(orderID,customerID,receptionistID,0,0,orderDate,orderTime,appointedTime,foodType,totalAmmount,"WaitingList");
        boolean isAdded = false;
        try {
            isAdded = placeOrderService.addOrderService(saveCustomer(),placeOrderDTO);
            if(isAdded){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Customer And Order Details Added Successfully", ButtonType.OK);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Ok_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                addToQueue();
                clearAllFields();
                manageComponents();
                loadCustomerDetailTable();
                loadWaitingCustomerList();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Customer And Order Details Added Unsuccessfully", ButtonType.OK);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(){
        int customerID=Integer.parseInt(txtCustomerID.getText());
        String customerFirstName=txtCustomerFirstName.getText();
        String customerLastName=txtCustomerLastName.getText();
        String customerAddress=txtCustomerAddress.getText();
        String customerNicNo=txtCustomerNicNO.getText();
        int customerMobileNo=Integer.parseInt(txtCustomerMobileNO.getText());
        CustomerDTO customerDTO=new CustomerDTO(customerID,customerFirstName,customerLastName,customerAddress,customerNicNo,customerMobileNo);
        try {
            boolean isUpdated = customerService.updateCustomer(customerDTO);
            if(isUpdated){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Updated Successfully",ButtonType.OK);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Ok_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
                clearAllFields();
                //loadCustomerDetailTable();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Updated Unsuccessfully", ButtonType.OK);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteOrder() throws Exception {
        String customerNicNo = txtCustomerNicNO.getText();
        boolean isDeleted = placeOrderService.deleteOrder(customerNicNo);
        if(isDeleted){
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Deleted Succressfully",ButtonType.OK);
            alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Ok_48px_1.png")));
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
            clearAllFields();
            //loadCustomerDetailTable();
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR,"Deleted Unsuccessfully",ButtonType.OK);
            alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        }
    }

    private void searchCustomer(){
        String customerNicNo = txtCustomerNicNO.getText();
        try {
            CustomerDTO customerDTO = customerService.searchCustomer(customerNicNo);
            if(customerDTO!=null){
                int customerID=customerDTO.getCustomerID();
                String customerF_Name=customerDTO.getCustomerF_Name();
                String customerL_Name=customerDTO.getCustomerL_Name();
                String customerAddress=customerDTO.getCustomerAddress();
                String customerNic=customerDTO.getCustomerNicNO();
                int customeTel=customerDTO.getCustomerTel();

                txtCustomerID.setText("C-000"+customerID);
                txtCustomerFirstName.setText("" + customerF_Name);
                txtCustomerLastName.setText("" + customerL_Name);
                txtCustomerAddress.setText("" + customerAddress);
                txtCustomerNicNO.setText("" + customerNic);
                txtCustomerMobileNO.setText("" + customeTel);
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.WARNING,"New Customer To the System.\nNo Search Results Related To this Customer.",ButtonType.OK,ButtonType.CANCEL);
            alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Error_48px.png")));
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        }
    }

    private void clearAllFields(){
        txtOrderID.clear();
        txtCustomerFirstName.clear();
        txtCustomerLastName.clear();
        txtCustomerAddress.clear();
        txtCustomerNicNO.clear();
        txtCustomerMobileNO.clear();
        txtOrderTime.clear();
        txtOrderDate.clear();
        txtAppointedTime.clear();
        txtFoodType.clear();
    }

    public void txtCustomerFirstNameOnAction(ActionEvent actionEvent) {
        txtCustomerLastName.requestFocus();
    }

    public void txtCustomerLastNameOnAction(ActionEvent actionEvent) {
        txtCustomerAddress.requestFocus();
    }

    public void txtCustomerNicNOOnAction(ActionEvent actionEvent) { txtCustomerFirstName.requestFocus();
        searchCustomer();
    }

    public void txtCustomerAddressOnAction(ActionEvent actionEvent) {
        txtCustomerMobileNO.requestFocus();
    }

    public void txtCustomerMobileNOOnAction(ActionEvent actionEvent) {
        txtNoOfFoodOrders.requestFocus();
    }

    public void txtOrderIDOnAction(ActionEvent actionEvent) {
        txtOrderDate.requestFocus();
    }

    public void txtOrderDateOnAction(ActionEvent actionEvent) {
        txtOrderTime.requestFocus();
    }

    public void txtOrderTimeOnAction(ActionEvent actionEvent) {
        txtAppointedTime.requestFocus();
    }

    public void txtAppointedTimeOnAction(ActionEvent actionEvent) {
        placeOrder();
    }

    public void txtFoodTypeOnAction(ActionEvent actionEvent) {
        txtAmmount.requestFocus();
    }

    public void txtAmmountOnAction(ActionEvent actionEvent) {
        placeOrder();
    }

    public void imgMiniMizeClicked(MouseEvent mouseEvent) {

    }

    private void enableAll(){
        cmbFirstFoodType.setDisable(false);
        cmbSecondFoodType.setDisable(false);
        cmbThirdFoodType.setDisable(false);

        txtFirstFoodTypeAmmount.setDisable(false);
        txtSecondFoodTypeAmmount.setDisable(false);
        txtThirdFoodTypeAmmount.setDisable(false);
    }

    public void txtNoOfFoodOrdersOnAction(ActionEvent actionEvent) {
        if(txtNoOfFoodOrders.getText().equals("1")){
            enableAll();
            cmbSecondFoodType.setDisable(true);
            cmbThirdFoodType.setDisable(true);
            txtSecondFoodTypeAmmount.setDisable(true);
            txtThirdFoodTypeAmmount.setDisable(true);
            cmbFirstFoodType.requestFocus();
        }else if(txtNoOfFoodOrders.getText().equals("2")){
            enableAll();
            cmbFirstFoodType.requestFocus();
            cmbThirdFoodType.setDisable(true);
            txtThirdFoodTypeAmmount.setDisable(true);
            cmbFirstFoodType.requestFocus();
        }else if(txtNoOfFoodOrders.getText().equals("3")){
            enableAll();
            cmbFirstFoodType.requestFocus();
        }
    }

    public void txtFirstFoodTypeAmmountOnAction(ActionEvent actionEvent) {
            if (Integer.parseInt(txtNoOfFoodOrders.getText()) == 1) {
                try {
                    FoodDTO foodDTO = foodService.searchFoodByDescription("" + cmbFirstFoodType.getSelectionModel().getSelectedItem());
                    double unitPrice = Double.parseDouble(""+txtFirstFoodTypeAmmount.getText());
                    double price = unitPrice * foodDTO.getFoodPrice();
                    this.totalPrice = totalPrice + price;
                    txtTotalPrice.setText("" + totalPrice);
                    txtTotalPrice.setDisable(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cmbSecondFoodType.requestFocus();
            } else {
                txtAppointedTime.requestFocus();
            }

    }

    public void txtSecondFoodTypeAmmountOnAction(ActionEvent actionEvent) {
            if (Integer.parseInt(txtNoOfFoodOrders.getText()) == 2 || Integer.parseInt(txtNoOfFoodOrders.getText()) == 3) {
                cmbThirdFoodType.requestFocus();
                try {
                    FoodDTO foodDTO = foodService.searchFoodByDescription("" + cmbSecondFoodType.getSelectionModel().getSelectedItem());
                    double unitPrice = Double.parseDouble(txtSecondFoodTypeAmmount.getText());
                    double price = unitPrice * foodDTO.getFoodPrice();
                    this.totalPrice = totalPrice + price;
                    txtTotalPrice.setText("" + totalPrice);
                    txtTotalPrice.setDisable(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                txtAppointedTime.requestFocus();
            }
    }

    public void txtThirdFoodTypeAmmountOnAction(ActionEvent actionEvent) {
            try {
                FoodDTO foodDTO = foodService.searchFoodByDescription("" + cmbThirdFoodType.getSelectionModel().getSelectedItem());
                double unitPrice = Double.parseDouble(txtThirdFoodTypeAmmount.getText());
                double price = unitPrice * foodDTO.getFoodPrice();
                this.totalPrice = totalPrice + price;
                txtTotalPrice.setText("" + totalPrice);
                txtTotalPrice.setDisable(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            txtAppointedTime.requestFocus();
    }

    public void cmbFirstFoodTypeOnAction(ActionEvent actionEvent){
        txtFirstFoodTypeAmmount.requestFocus();
        txtFoodType.setText(""+cmbFirstFoodType.getSelectionModel().getSelectedItem());
        txtFoodType.setDisable(true);
    }

    public void cmbSecondFoodTypeOnAction(ActionEvent actionEvent) {
        txtSecondFoodTypeAmmount.requestFocus();
        txtFoodType.setText(cmbFirstFoodType.getSelectionModel().getSelectedItem().toString()+" ,"+cmbSecondFoodType.getSelectionModel().getSelectedItem().toString());
        txtFoodType.setDisable(true);
    }

    public void cmbThirdFoodTypeOnAction(ActionEvent actionEvent) {
        txtThirdFoodTypeAmmount.requestFocus();
        txtFoodType.setText(cmbFirstFoodType.getSelectionModel().getSelectedItem().toString()+" ,"+cmbSecondFoodType.getSelectionModel().getSelectedItem().toString()+" ,"+cmbThirdFoodType.getSelectionModel().getSelectedItem().toString());
        txtFoodType.setDisable(true);
    }

    public void txtTotalPriceOnAction(ActionEvent actionEvent) {

    }
}
