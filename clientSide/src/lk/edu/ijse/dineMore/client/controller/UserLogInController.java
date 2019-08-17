/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.dineMore.client.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.rmi.server.UnicastRemoteObject;
import java.util.Optional;
import java.util.ResourceBundle;

import dto.EmployeeLogInDTO;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.edu.ijse.dineMore.client.other.UserLogInData;
import observer.Observer;
import service.custom.UserLogInService;
import service.custom.impl.UserLogInServiceImpl;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class UserLogInController implements Initializable, Observer {

    public RadioButton radioButtonAdmin;
    public RadioButton radioButtonChef;
    public RadioButton radioButtonReceptionist;
    public RadioButton radioButtonBikeRider;
    @FXML
    private JFXTextField txtUserName;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private JFXButton btnSignUp;
    @FXML
    private JFXButton btnLogIn;
    @FXML
    private ImageView lblClose;
    @FXML
    private AnchorPane rootPane;

    final ToggleGroup group = new ToggleGroup();
    private static UserLogInService userLogInService=null;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            manageRadioButtons();
            manageUsserlogInService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void manageUsserlogInService() throws Exception {
        UnicastRemoteObject.exportObject(this, 0);
        if(userLogInService==null){
            userLogInService= new UserLogInServiceImpl();
            // (UserLogInService) new ProxyHandler().getService(ServiceFactory.ServiceTypes.USERLOGINSERVICE);
        }
    }
    private void manageRadioButtons(){
        radioButtonAdmin.setToggleGroup(group);
        radioButtonAdmin.setSelected(true);

        radioButtonChef.setToggleGroup(group);
        radioButtonReceptionist.setToggleGroup(group);
        radioButtonBikeRider.setToggleGroup(group);
    }

    @Override
    public void updateObservers() throws Exception {

    }

    @FXML
    private void txtUserNameOnAction(ActionEvent event){
        txtPassword.requestFocus();
    }

    @FXML
    private void txtPasswordOnAction(ActionEvent event){
        try {
            loadNextView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnSignUpOnAction(ActionEvent event){

    }

    @FXML
    private void btnLogInOnAction(ActionEvent event) throws IOException{
        try {
            loadNextView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkChef(){
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        EmployeeLogInDTO employeeLogInDTO = null;
        try {
            employeeLogInDTO = userLogInService.searchChefUserNamePassword(username, password,"chefLogin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int employeeID = employeeLogInDTO.getEmployeeID();
        String expectedUserName=employeeLogInDTO.getUserName();
        String expectedPassword=employeeLogInDTO.getPassword();
        if(username.equals(expectedUserName.toString()) && password.equals(expectedPassword.toString())){
            new UserLogInData(employeeID,expectedUserName,expectedPassword);
            return true;
        }else {
            return false;
        }
    }
    private boolean checkBikeRider(){
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        EmployeeLogInDTO employeeLogInDTO = null;
        try {
            employeeLogInDTO = userLogInService.searchBikeRiderUserNamePassword(username, password,"bikrRiderlogin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int employeeID = employeeLogInDTO.getEmployeeID();
        String expectedUserName=employeeLogInDTO.getUserName();
        String expectedPassword=employeeLogInDTO.getPassword();
        if(username.equals(expectedUserName.toString()) &&  password.equals(expectedPassword.toString())){
            new UserLogInData(employeeID,expectedUserName,expectedPassword);
            return true;
        }else {
            return false;
        }
    }

    private boolean checkReceptionist(){
        String username = txtUserName.getText();
        String password = txtPassword.getText();

        EmployeeLogInDTO employeeLogInDTO = null;
        try {
            employeeLogInDTO = userLogInService.searchEmployeeUserNamePassword(username, password,"receptionistlogin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int employeeID = employeeLogInDTO.getEmployeeID();
        String expectedUserName=employeeLogInDTO.getUserName();
        String expectedPassword=employeeLogInDTO.getPassword();
        if(username.equals(expectedUserName.toString()) &&  password.equals(expectedPassword.toString())){
            new UserLogInData(employeeID,expectedUserName,expectedPassword);
            return true;
        }else {
            return false;
        }
    }

    private void loadNextView() throws Exception {
        Parent root = null;
        if(radioButtonReceptionist.isSelected()) {
                boolean isCorrect = checkReceptionist();
                System.out.println(isCorrect);
                if(isCorrect) {
                    root = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/dineMore/client/view/ReceptionistApplication.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) this.rootPane.getScene().getWindow();
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.setResizable(false);
                    stage.show();

                    TranslateTransition translateTransition = new TranslateTransition(Duration.millis(800), scene.getRoot());
                    translateTransition.setFromX(-scene.getWidth());
                    translateTransition.setToX(0);
                    translateTransition.play();
                }else {
                    Alert alert=new Alert(Alert.AlertType.ERROR,"Incorrect UserName OR Password.\nPlease Check And Try Again", ButtonType.OK,ButtonType.CANCEL);
                    alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                    alert.initStyle(StageStyle.UNDECORATED);
                    alert.showAndWait();
                }
        }else if(radioButtonChef.isSelected()){
            boolean isCorrect = checkChef();
            if(isCorrect) {
                root = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/dineMore/client/view/ChefApplication.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) this.rootPane.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.setResizable(false);
                stage.show();

                TranslateTransition translateTransition = new TranslateTransition(Duration.millis(800), scene.getRoot());
                translateTransition.setFromX(-scene.getWidth());
                translateTransition.setToX(0);
                translateTransition.play();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Incorrect UserName OR Password.\nPlease Check And Try Again", ButtonType.OK,ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
        }else if(radioButtonBikeRider.isSelected()){
            boolean isCorrect = checkBikeRider();
            if(isCorrect) {
                root = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/dineMore/client/view/BikeRiderApplication.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) this.rootPane.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.setResizable(false);
                stage.show();

                TranslateTransition translateTransition = new TranslateTransition(Duration.millis(800), scene.getRoot());
                translateTransition.setFromX(-scene.getWidth());
                translateTransition.setToX(0);
                translateTransition.play();
            }
            else{
                Alert alert=new Alert(Alert.AlertType.ERROR,"Incorrect UserName OR Password.\nPlease Check And Try Again", ButtonType.OK,ButtonType.CANCEL);
                alert.setGraphic(new ImageView(("/lk/edu/ijse/dineMore/client/assests/Cancel 2_48px_1.png")));
                alert.initStyle(StageStyle.UNDECORATED);
                alert.showAndWait();
            }
        }else if(radioButtonAdmin.isSelected()){
            try {
                root = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/dineMore/client/view/AdminViewApplication.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) this.rootPane.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.setResizable(false);
                stage.show();

                TranslateTransition translateTransition = new TranslateTransition(Duration.millis(800), scene.getRoot());
                translateTransition.setFromX(-scene.getWidth());
                translateTransition.setToX(0);
                translateTransition.play();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            //
        }
    }

    @FXML
    private void lblCloseClicked(MouseEvent event){
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
        }else{
            alert.close();
        }
    }
}