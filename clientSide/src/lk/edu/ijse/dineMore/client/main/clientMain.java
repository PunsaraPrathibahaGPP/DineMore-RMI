package lk.edu.ijse.dineMore.client.main;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.rmi.Naming;
import java.rmi.Remote;

public class clientMain extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent loadRoot = FXMLLoader.load(this.getClass().getResource("/lk/edu/ijse/dineMore/client/view/UserLogIn.fxml"));
        Scene loadScene = new Scene(loadRoot);
        primaryStage.setScene(loadScene);
        primaryStage.setX(370);
        primaryStage.setY(210);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setResizable(false);
        primaryStage.show();

        FadeTransition loadFadeTransition = new FadeTransition(Duration.millis(2000), loadRoot);
        loadFadeTransition.setFromValue(0.0);
        loadFadeTransition.setToValue(0.6);
        loadFadeTransition.play();
    }
}
