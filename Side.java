// This is a side project
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import java.io.*;
import java.util.*;
import javafx.event.*;

public class Side extends Application{
	private int numOfBtns = 0;
	public static void main(String [] args) {
		launch(args);
	}
	@Override public void start(Stage stage) {
		Pane root = new Pane();
		Canvas canvas = new Canvas(500, 500);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		draw(gc);
		Button btn = createBtn(gc);
		btn.setLayoutX(300);
		btn.setLayoutY(350);
		Button btn2 = createBtn(gc);
		btn2.setLayoutX(200);
		btn2.setLayoutY(350);
		root.getChildren().add(canvas);
		root.getChildren().add(btn);
		root.getChildren().add(btn2);
		stage.setScene(new Scene(root,500,500));
		stage.setTitle("A Side Proj");
		stage.show();
	}
	public Button createBtn(GraphicsContext gc) {
		numOfBtns += 1;
		Button btn = new Button();
		if (numOfBtns == 1) {
			btn.setText("This prints something");
			gc.setFill(Color.BLACK);
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					gc.fillText("Something", 400, 400);
				}
			});
			btn.setLayoutX(400);
			btn.setLayoutY(350);
		}
		else {
			btn.setText("Other button");
			gc.setFill(Color.BLACK);
			btn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					gc.fillText("Something else", 300, 400);
				}
			});
			btn.setLayoutX(300);
			btn.setLayoutY(350);
		}
		return btn;
	}
	public void draw(GraphicsContext gc) {
		gc.setFill(Color.YELLOW);
		gc.fillRect(0, 0, 500, 500);
		gc.setFill(Color.BLUE);
		gc.fillOval(20, 20, 100, 250);
	}
}