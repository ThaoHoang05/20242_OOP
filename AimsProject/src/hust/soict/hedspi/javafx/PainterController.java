package hust.soict.hedspi.javafx;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private ToggleGroup tooltoggle;
    
    private boolean isPenSelected = true;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Color circleColor = isPenSelected ? Color.BLACK : Color.WHITE;
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, circleColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
    @FXML
    void clearUsingEraser(MouseEvent event) {
    	Color circleColor = isPenSelected ? Color.BLACK : Color.WHITE;
    	Circle clearCircle = new Circle(event.getX(), event.getY(), 4, circleColor);
    	drawingAreaPane.getChildren().add(clearCircle);
    }
    @FXML
    void choosePen(ActionEvent event) {
    	isPenSelected = true;
    }
    @FXML
    void chooseEraser(ActionEvent event) {
    	isPenSelected = false;
    }
}
    

