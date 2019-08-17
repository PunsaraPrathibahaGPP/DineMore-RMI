package lk.edu.ijse.dineMore.client.controller;

import javafx.animation.*;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import observer.Observer;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminViewApplicationController implements Initializable, Observer {
    public HBox hBoxManageEmployee;
    public AnchorPane homePane;
    public AnchorPane rootPane;
    public Label lbldate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadDefaulltViewPane();
            loadDate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateObservers() throws Exception {

    }

    private void loadDate(){
        lbldate.setDisable(true);
        Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                lbldate.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
                lbldate.setFocusTraversable(false);
                lbldate.setDisable(true);
                lbldate.setAlignment(Pos.CENTER);
            }

        }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }

    private void loadDefaulltViewPane() throws IOException {
        this.homePane.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/dineMore/client/view/ManageEmployee.fxml"));
        this.homePane.getChildren().add(pane);
    }

    public void imgCloseOnClick(MouseEvent mouseEvent) {
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

    public void hBoxMouseEntered(MouseEvent mouseEvent) {
        HBox source= (HBox) mouseEvent.getSource();
        ScaleTransition scaleTrandsition=new ScaleTransition(Duration.millis(1200),source);
        scaleTrandsition.setToX(1.1);
        scaleTrandsition.setToY(1.1);
        scaleTrandsition.play();
        source.setEffect(null);
    }

    public void hBoxMouseExited(MouseEvent mouseEvent) {
        HBox source= (HBox) mouseEvent.getSource();
        ScaleTransition scaleTrandsition=new ScaleTransition(Duration.millis(1200),source);
        scaleTrandsition.setToX(1.0);
        scaleTrandsition.setToY(1.0);
        scaleTrandsition.play();
        source.setEffect(null);
    }

    public void timeMouseEntered(MouseEvent mouseEvent) {
    }

    public void timeMouseExited(MouseEvent mouseEvent) {
    }

    public void hBoxManageEmployeeClicked(MouseEvent mouseEvent) {
        try {
            this.homePane.getChildren().clear();
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/dineMore/client/view/ManageEmployee.fxml"));
            this.homePane.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lblViewReportsClicked(MouseEvent mouseEvent) {
        try {
            this.homePane.getChildren().clear();
            AnchorPane pane = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/dineMore/client/view/ViewReports.fxml"));
            this.homePane.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lblLogOutClicked(MouseEvent mouseEvent){
        Parent loadRoot = null;
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
