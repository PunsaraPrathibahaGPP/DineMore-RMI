package lk.edu.ijse.dineMore.client.controller;

import business.custom.ReceptionistBo;
import business.custom.impl.ReceptionistBoImpl;
import com.jfoenix.controls.JFXTextField;
import dto.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import lk.edu.ijse.dineMore.client.other.IDGenerator;
import lk.edu.ijse.dineMore.client.proxy.ProxyHandler;
import observer.Observer;
import service.ServiceFactory;
import service.custom.BikeRiderService;
import service.custom.ChefService;
import service.custom.impl.ChefServiceImpl;
import service.custom.ReceptionistService;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManageEmployeeController implements Initializable, Observer {
    public TableView<EmployeeDTO> tblEmployeeDetailView;
    public JFXTextField txtReceptionistUserName;
    public JFXTextField txtReceptionistPassword;
    public JFXTextField txtChefUserName;
    public JFXTextField txtChefPassword;
    public JFXTextField txtBikeRiderUserName;
    public JFXTextField txtBikeRiderPassword;
    public JFXTextField txtReceptionistID;
    public JFXTextField txtChefID;
    public JFXTextField txtBikeRiderID;
    private ReceptionistService receptionistService;
    private ChefService chefService;
    private BikeRiderService bikeRiderService;
    public JFXTextField txtReceptionistFirstName;
    public JFXTextField txtReceptionistLastName;
    public JFXTextField txtReceptionistNicNO;
    public JFXTextField txtReceptionistAddress;
    public JFXTextField txtReceptionistSalary;
    public JFXTextField txtReceptionistMobileNO;
    public JFXTextField txtChefFirstName;
    public JFXTextField txtChefLastName;
    public JFXTextField txtChefNicNO;
    public JFXTextField txtChefAddress;
    public JFXTextField txtChefSalary;
    public JFXTextField txtChefMobileNO1;
    public JFXTextField txtBikeRiderFirstName;
    public JFXTextField txtBikeRiderLastName;
    public JFXTextField txtBikeRiderNicNO;
    public JFXTextField txtBikeRiderAddress;
    public JFXTextField txtBikeRiderSalary;
    public JFXTextField txtBikeRiderMobileNO;

    public RadioButton radioButtonReceptionist;
    public RadioButton radioButtonChef;
    public RadioButton radioButtonBikeRider;
    private int i=1;
    final ToggleGroup group = new ToggleGroup();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadManageEmployeeService();
            manageComponents();
            setRadioButtonGroup();
            setDefaultSelection();
            loadReceptionistTableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void manageComponents() throws Exception {
        String receptionistNextID;
        receptionistNextID = IDGenerator.getNewID("receptionist", "receptionistID","R-000");
        txtReceptionistID.setText(receptionistNextID);
        txtReceptionistID.setDisable(true);

        String chefnextID;
        chefnextID = IDGenerator.getNewID("chef", "chefID","C-000");
        txtChefID.setText(chefnextID);
        txtChefID.setDisable(true);

        String bikeRiderNextID;
        bikeRiderNextID = IDGenerator.getNewID("BikeRider", "bikeRider_ID","B-000");
        txtBikeRiderID.setText(bikeRiderNextID);
        txtBikeRiderID.setDisable(true);
    }

    private void setDefaultSelection(){
        if(radioButtonReceptionist.isSelected()) {
            enableReceptionistFields();
            disableChefFields();
            disableBikeRiderFields();
        }
    }

    private void setRadioButtonGroup(){
        radioButtonReceptionist.setToggleGroup(group);
        radioButtonReceptionist.setSelected(true);

         radioButtonReceptionist.setToggleGroup(group);
         radioButtonChef.setToggleGroup(group);
         radioButtonBikeRider.setToggleGroup(group);
    }
    private void loadManageEmployeeService() throws Exception {
        System.out.println("Customer Service Instance Initializing...");
        if(receptionistService==null) {
            receptionistService = (ReceptionistService)ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.RECEPTIONIST);
        }
        if(chefService==null){
            chefService= (ChefService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.CHEF);
        }
        if(bikeRiderService==null){
            bikeRiderService= (BikeRiderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.BIKERIDER);
        }
//        Subject orderSubject = (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.ORDERQUEUE);
//        orderSubject.registerObserver(this);
        System.out.println("Customer Service Instance Initialized Successfully...");
    }

    @Override
    public void updateObservers() throws Exception {

    }

    public void imgCloseOnClick(MouseEvent mouseEvent) {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure you wish to Exit?", ButtonType.YES,ButtonType.NO);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Help_48px.png")));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width/2;
        int centerY = screenSize.height/2;

        alert.setX(centerX-155);
        alert.setY(centerY-50);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.YES){
            System.exit(0);
        }else {
            alert.close();
        }
    }

    //=====================================================================
    //Receptionist
    //=====================================================================
    public void txtReceptionistIDOnAction(ActionEvent actionEvent) {
        txtReceptionistFirstName.requestFocus();
    }
    public void txtReceptionistFirstNameOnAction(ActionEvent actionEvent) {
        txtReceptionistLastName.requestFocus();
    }

    public void txtReceptionistLastNameOnAction(ActionEvent actionEvent) {
        txtBikeRiderNicNO.requestFocus();
    }

    public void txtReceptionistNicNOOnAction(ActionEvent actionEvent) {
        txtReceptionistAddress.requestFocus();
    }

    public void txtReceptionistAddressOnAction(ActionEvent actionEvent) {
        txtReceptionistMobileNO.requestFocus();
    }

    public void txtReceptionistMobileNOOnAction(ActionEvent actionEvent) {
        txtReceptionistUserName.requestFocus();
    }

    public void txtReceptionistUserNameOnAction(ActionEvent actionEvent) {
        txtReceptionistPassword.requestFocus();
    }

    public void txtReceptionistPasswordOnAction(ActionEvent actionEvent) {
        try {
            saveEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //=====================================================================
    //CHEF
    //=====================================================================
    public void txtChefIDOnAction(ActionEvent actionEvent) {
        txtChefFirstName.requestFocus();
    }

    public void txtChefFirstNameOnAction(ActionEvent actionEvent) {
        txtChefLastName.requestFocus();
    }

    public void txtChefLastNameOnAction(ActionEvent actionEvent) {
        txtChefNicNO.requestFocus();
    }

    public void txtChefNicNOOnAction(ActionEvent actionEvent) {
        txtChefAddress.requestFocus();
    }

    public void txtCustomerAddressOnAction(ActionEvent actionEvent) {
        txtChefMobileNO1.requestFocus();
    }

    public void txtChefMobileNOOnAction(ActionEvent actionEvent) {
        txtChefUserName.requestFocus();
    }

    public void txtChefUserNameOnAction(ActionEvent actionEvent) {
        txtChefPassword.requestFocus();
    }

    public void txtChefPasswordOnAction(ActionEvent actionEvent) {
        try {
            saveEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //=====================================================================
    //BikeRider
    //=====================================================================
    public void txtBikeRiderOnAction(ActionEvent actionEvent) {
        txtBikeRiderFirstName.requestFocus();
    }

    public void txtBikeRiderFirstNameOnAction(ActionEvent actionEvent) {
        txtBikeRiderLastName.requestFocus();
    }

    public void txtBikeRiderLastNameOnAction(ActionEvent actionEvent) {
        txtBikeRiderNicNO.requestFocus();
    }

    public void txtBikeRiderNicNOOnAction(ActionEvent actionEvent) {
        txtBikeRiderAddress.requestFocus();
    }

    public void txtBikeRiderAddressOnAction(ActionEvent actionEvent) {
        txtReceptionistMobileNO.requestFocus();
    }

    public void txtBikeRiderMobileNOOnAction(ActionEvent actionEvent) {
        txtBikeRiderUserName.requestFocus();
    }

    public void txtBikeRiderUserNameOnAction(ActionEvent actionEvent) {
        txtBikeRiderPassword.requestFocus();
    }

    public void txtBikeRiderPasswordOnAction(ActionEvent actionEvent) {
        try {
            saveEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSaveEmployeeOnAction(ActionEvent actionEvent) {
        try {
            saveEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSearchEmployeeOnAction(ActionEvent actionEvent) {
        try {
            searchEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnClearAllFieldsOnAction(ActionEvent actionEvent) {
        clearAllFields();
    }

    public void btnUpdateEmployeeOnAction(ActionEvent actionEvent) {
        try {
            updateEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteEmployeeOnAction(ActionEvent actionEvent) {
        try {
            deleteEmployee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearAllFields(){
        if(radioButtonReceptionist.isSelected()) {
            txtReceptionistFirstName.clear();
            txtReceptionistLastName.clear();
            txtReceptionistAddress.clear();
            txtReceptionistNicNO.clear();
            txtReceptionistMobileNO.clear();
            txtReceptionistSalary.clear();
        }
    }

    private void deleteEmployee() throws Exception {
        if(radioButtonReceptionist.isSelected()){
            String receptionistFirstName = txtReceptionistFirstName.getText();
            boolean isDeleted = receptionistService.deleteReceptionist(receptionistFirstName);
            if(isDeleted){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Receptionist Details Updated Succesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Ok_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Receptionist Details Updated Unsuccesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
        }else if(radioButtonChef.isSelected()){
            String chefFirstName = txtChefFirstName.getText();
            boolean isDeleted = chefService.deleteChef(chefFirstName);
            if(isDeleted){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Chef Details Deleted Succesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Ok_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Chef Details Deleted Unsuccesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
        }
    }

    private void searchEmployee() throws Exception {
        if(radioButtonReceptionist.isSelected()) {
            String receptionistFirstName = txtReceptionistFirstName.getText();
            ReceptionistDTO receptionistDTO = receptionistService.searchReceptionist(receptionistFirstName);
            txtReceptionistFirstName.setText(receptionistDTO.getReceptionistF_Name());
            txtReceptionistLastName.setText(receptionistDTO.getReceptionistL_Name());
            txtReceptionistAddress.setText(receptionistDTO.getReceptionistAddress());
            txtReceptionistNicNO.setText(receptionistDTO.getReceptionistNicNO());
            txtReceptionistMobileNO.setText("" + receptionistDTO.getReceptionistTel());
        }else if(radioButtonChef.isSelected()) {
            String chefFirstName = txtChefFirstName.getText();
            chefService=new ChefServiceImpl();
            ChefDTO chefDTO = chefService.searchChef(chefFirstName);
            txtChefFirstName.setText(chefDTO.getChefF_Name());
            txtChefLastName.setText(chefDTO.getChefL_Name());
            txtChefAddress.setText(chefDTO.getChefAddress());
            txtChefNicNO.setText(chefDTO.getChef_NicNO());
            txtChefMobileNO1.setText("" + chefDTO.getChefTel());
        }
    }

    private void updateEmployee() throws Exception {
        if(radioButtonReceptionist.isSelected()) {
            String receptionistFirstName = txtReceptionistFirstName.getText();
            String receptionistLastName = txtReceptionistLastName.getText();
            String receptionistAddress = txtReceptionistAddress.getText();
            String receptionistNicNo = txtReceptionistNicNO.getText();
            int receptionistMobileNo = Integer.parseInt(txtReceptionistMobileNO.getText());
            ReceptionistDTO receptionistDTO = new ReceptionistDTO(++i, receptionistFirstName, receptionistLastName, receptionistAddress, receptionistNicNo, receptionistMobileNo);
            boolean isUpdated = receptionistService.updateReceptionist(receptionistDTO);
            if(isUpdated){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Receptionist Details Updated Succesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Ok_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Receptionist Details Updated Unsuccesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
        }else if(radioButtonChef.isSelected()){
            String chefFirstName = txtChefFirstName.getText();
            String chefLastName = txtChefLastName.getText();
            String chefAddress = txtChefAddress.getText();
            String chefNicNo = txtChefNicNO.getText();
            int chefMobileNo = Integer.parseInt(txtChefNicNO.getText());
            ChefDTO chefDTO = new ChefDTO(++i, chefFirstName, chefLastName, chefAddress, chefNicNo, chefMobileNo);
            boolean isUpdated = chefService.updateChef(chefDTO);
            if(isUpdated){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Chef Details Updated Succesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Ok_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Chef Details Updated Unsuccesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
        }
    }

    private void loadReceptionistTableView() throws Exception {
        if(radioButtonReceptionist.isSelected()) {
            System.out.println("calling loadReceptionistTableView()");
            tblEmployeeDetailView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("employeeID"));
            tblEmployeeDetailView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("employeeF_Name"));
            tblEmployeeDetailView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("employeeL_Name"));
            tblEmployeeDetailView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("receptionistAddress"));
            tblEmployeeDetailView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("employeeNicNO"));
            tblEmployeeDetailView.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("employeeTel"));
            ReceptionistBo receptionistBo = new ReceptionistBoImpl();
            ArrayList<EmployeeDTO> allReceptionists = receptionistBo.getAllReceptionists();
            tblEmployeeDetailView.setItems(FXCollections.observableArrayList(allReceptionists));
        }
    }

    private void saveEmployee()throws Exception{
        if(radioButtonReceptionist.isSelected()) {
            System.out.println("ManageEmployeeController.Save Employee Called");
            int receptionistID=Integer.parseInt(txtReceptionistID.getText().split("R-000")[1]);
            String receptionistFirstName = txtReceptionistFirstName.getText();
            String receptionistLastName = txtReceptionistLastName.getText();
            String receptionistAddress = txtReceptionistAddress.getText();
            String receptionistNicNo = txtReceptionistNicNO.getText();
            int receptionistMobileNo = Integer.parseInt(txtReceptionistMobileNO.getText());
            ReceptionistDTO receptionistDTO = new ReceptionistDTO(receptionistID, receptionistFirstName, receptionistLastName, receptionistAddress, receptionistNicNo, receptionistMobileNo);

            EmployeeLogInDTO employeeLogInDTO=new EmployeeLogInDTO(receptionistID,txtReceptionistUserName.getText(),txtReceptionistPassword.getText());

            boolean isAdded = receptionistService.addReceptionist(receptionistDTO,employeeLogInDTO);
            System.out.println("ManageEmployeeController.calling ReceptionistService Returned");
            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Receptionist Added Succesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Ok_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Receptionist Added Unsuccesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
        }else if(radioButtonChef.isSelected()){
            int chefID=Integer.parseInt(txtChefID.getText().split("C-000")[1]);
            String chefFirstName = txtChefFirstName.getText();
            String chefLastName = txtChefLastName.getText();
            String chefAddress = txtChefAddress.getText();
            String chefNicNo = txtChefNicNO.getText();
            int chefMobileNo = Integer.parseInt(txtChefMobileNO1.getText());
            ChefDTO chefDTO = new ChefDTO(chefID, chefFirstName, chefLastName, chefAddress, chefNicNo, chefMobileNo);

            EmployeeLogInDTO employeeLogInDTO=new EmployeeLogInDTO(chefID,txtChefUserName.getText(),txtChefPassword.getText());
            boolean isAdded = chefService.addChef(chefDTO,employeeLogInDTO);
            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Chef Added Succesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Ok_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "Chef Added Unsuccesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
        }else if(radioButtonBikeRider.isSelected()){
            int bikeRiderID=Integer.parseInt(txtBikeRiderID.getText().split("B-000")[1]);
            String bikeRiderFirstName = txtBikeRiderFirstName.getText();
            String bikeRiderLastName = txtBikeRiderLastName.getText();
            String bikeRiderAddress = txtBikeRiderAddress.getText();
            String bikeRiderNicNo = txtBikeRiderNicNO.getText();
            int bikeRiderMobileNo = Integer.parseInt(txtBikeRiderMobileNO.getText());
            BikeRiderDTO bikeRiderDTO = new BikeRiderDTO(bikeRiderID, bikeRiderFirstName, bikeRiderLastName, bikeRiderAddress, bikeRiderNicNo, bikeRiderMobileNo);

            EmployeeLogInDTO employeeLogInDTO=new EmployeeLogInDTO(bikeRiderID,txtBikeRiderUserName.getText(),txtBikeRiderPassword.getText());
            boolean isAdded = bikeRiderService.addBikeRider(bikeRiderDTO,employeeLogInDTO);
            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "BikeRider Added Succesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Ok_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "BikeRider Added Unsuccesfully", ButtonType.OK, ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
        }
    }

    private void disableChefFields(){
        //loadCheffTableView();
        txtChefFirstName.setDisable(true);
        txtChefLastName.setDisable(true);
        txtChefAddress.setDisable(true);
        txtChefNicNO.setDisable(true);
        txtChefMobileNO1.setDisable(true);
        txtChefUserName.setDisable(true);
        txtChefPassword.setDisable(true);
    }

    private void disableBikeRiderFields(){
        //loadBikeRiderTableView();
        txtBikeRiderFirstName.setDisable(true);
        txtBikeRiderLastName.setDisable(true);
        txtBikeRiderAddress.setDisable(true);
        txtBikeRiderNicNO.setDisable(true);
        txtBikeRiderMobileNO.setDisable(true);
        txtBikeRiderUserName.setDisable(true);
        txtBikeRiderPassword.setDisable(true);
    }

    private void disableReceptionistFields(){
        try {
            //loadReceptionistTableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtReceptionistFirstName.setDisable(true);
        txtReceptionistLastName.setDisable(true);
        txtReceptionistAddress.setDisable(true);
        txtReceptionistNicNO.setDisable(true);
        txtReceptionistMobileNO.setDisable(true);
        txtReceptionistUserName.setDisable(true);
        txtReceptionistPassword.setDisable(true);
    }

    private void enableReceptionistFields(){
        txtReceptionistFirstName.setDisable(false);
        txtReceptionistLastName.setDisable(false);
        txtReceptionistAddress.setDisable(false);
        txtReceptionistNicNO.setDisable(false);
        txtReceptionistMobileNO.setDisable(false);
        txtReceptionistUserName.setDisable(false);
        txtReceptionistPassword.setDisable(false);
    }

    private void enableChefFields(){
        txtChefFirstName.setDisable(false);
        txtChefLastName.setDisable(false);
        txtChefAddress.setDisable(false);
        txtChefNicNO.setDisable(false);
        txtChefMobileNO1.setDisable(false);
        txtChefUserName.setDisable(false);
        txtChefPassword.setDisable(false);
    }

    private void enableBikeRiderFields(){
        txtBikeRiderFirstName.setDisable(false);
        txtBikeRiderLastName.setDisable(false);
        txtBikeRiderAddress.setDisable(false);
        txtBikeRiderNicNO.setDisable(false);
        txtBikeRiderMobileNO.setDisable(false);
        txtBikeRiderUserName.setDisable(false);
        txtBikeRiderPassword.setDisable(false);
    }

    public void radioButtonReceptionistClicked(MouseEvent mouseEvent) {
        try {
            loadReceptionistTableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
        enableReceptionistFields();
        disableChefFields();
        disableBikeRiderFields();
    }

    public void radioButtonChefClicked(MouseEvent mouseEvent) {
        enableChefFields();
        disableReceptionistFields();
        disableBikeRiderFields();
    }

    public void radioButtonBikeRiderClicked(MouseEvent mouseEvent) {
        enableBikeRiderFields();
        disableChefFields();
        disableReceptionistFields();
    }

}
