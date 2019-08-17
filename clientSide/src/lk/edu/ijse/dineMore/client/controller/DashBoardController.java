/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.dineMore.client.controller;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXProgressBar;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import observer.Observer;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class DashBoardController implements Initializable, Observer {

    public JFXProgressBar progressBar;
    public ProgressIndicator progressIndicator;
    @FXML
    private HBox hbxReceptionist;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private HBox hbxChef;
    @FXML
    private HBox hbxBikeRider;
    @FXML
    private ImageView imgClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/dineMore/client/view/UserLogIn.fxml"));
//            Scene scene = new Scene(root);
//            Stage stage= (Stage) this.rootPane.getScene().getWindow();
//            stage.setScene(scene);
//            stage.setResizable(false);
//            stage.show();
//
//            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(800),scene.getRoot());
//            translateTransition.setFromY(-scene.getWidth());
//            translateTransition.setToY(0);
//            translateTransition.play();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void updateObservers() throws Exception {

    }
}
