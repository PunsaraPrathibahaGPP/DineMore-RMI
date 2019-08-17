package lk.edu.ijse.dineMore.client.controller;

import javafx.animation.ScaleTransition;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ViewReportsController {
    public void paneOnMouseEntered(MouseEvent mouseEvent) {
        Pane source=(Pane)mouseEvent.getSource();
        ScaleTransition scaleTransition=new ScaleTransition(Duration.millis(1200),source);
        scaleTransition.setToX(1.1);
        scaleTransition.setToY(1.1);
        scaleTransition.play();
        source.setEffect(null);
    }

    public void paneOnMouseExited(MouseEvent mouseEvent) {
        Pane source=(Pane)mouseEvent.getSource();
        ScaleTransition scaleTransition=new ScaleTransition(Duration.millis(1200),source);
        scaleTransition.setToX(1.0);
        scaleTransition.setToY(1.0);
        scaleTransition.play();
        source.setEffect(null);
    }

    public void customerDetailPaneClicked(MouseEvent mouseEvent) {
    }

    public void orderDetailPaneClicked(MouseEvent mouseEvent) {
    }

    public void foodDetailPaneClicked(MouseEvent mouseEvent) {
    }

    public void cherfDetailPaneClicked(MouseEvent mouseEvent) {
    }

    public void receptionistDetailPaneClicked(MouseEvent mouseEvent) {
    }

    public void bikeRiderDetailPaneClicked(MouseEvent mouseEvent) {
    }

    public void orderprogressPaneClicked(MouseEvent mouseEvent) {
    }
}
