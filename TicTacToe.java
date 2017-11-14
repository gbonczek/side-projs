// this is a class that does something 

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import javafx.scene.input.*;
import javafx.scene.shape.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.geometry.*;


public class TicTacToe extends Application{
	GraphicsContext gc;
	public static void main(String[] args) {
        launch(args);
    }
	@Override 
	public void start(Stage stage) {
		BorderPane root = new BorderPane();
		AnchorPane rightRoot = new AnchorPane();
		Canvas canvas = new Canvas(1000, 1000);
		gc = canvas.getGraphicsContext2D();
		Button btn = new Button("Reset");
		btn.setLayoutX(0);
		btn.setLayoutY(500);
		gc.setFill(Color.BLACK);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gc.clearRect(0, 0, 1000, 1000);
				//canvas.removeEventHandler(MouseEvent.MOUSE_CLICKED, new MyMouseEvent());
				//canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyMouseEvent());
			}
		});
		Line line = new Line(433,0,433,1000);
		Line line2 = new Line(766,0,766,1000);
		Line line3 = new Line(100,333,1100,333);
		Line line4 = new Line(100,666,1100,666);
		canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyMouseEvent());
		rightRoot.getChildren().add(canvas);
		root.getChildren().add(line);
		root.getChildren().add(line2);
		root.getChildren().add(line3);
		root.getChildren().add(line4);
		root.setRight(rightRoot);
		root.setCenter(btn);
		//root.getChildren().add(btn2);
		stage.setScene(new Scene(root,1100,1000));
		stage.setTitle("Tic-Tac-Toe");
		stage.show();
	}
	private class MyMouseEvent implements EventHandler<MouseEvent> {
		int move = 0;
		//GraphicsContext gc;
        @Override
        public void handle(MouseEvent event) {
        	move += 1;
        	if (move%2 == 0) {	
	        	if (event.getSceneX() <= 433.3) {
	        		if (event.getSceneY() <= 333.3) {
	            		gc.strokeOval(16.0, 16.0, 300, 300);
	        		}
	        		else if (event.getSceneY() <= 666.6) {
	        			gc.strokeOval(16.0, 333.3+16.0, 300, 300);
	        		}
	        		else {
	        			gc.strokeOval(16.0, 16.0+666.6, 300, 300);
	        		}
	        	}
	        	else if (event.getSceneX() <= 766.6) {
	        		if (event.getSceneY() <= 333.3) {
	            		gc.strokeOval(16.0+333.3, 16.0, 300, 300);
	        		}
	        		else if (event.getSceneY() <= 666.6) {
	        			gc.strokeOval(16.0+333.3, 333.3+16.0, 300, 300);
	        		}
	        		else {
	        			gc.strokeOval(16.0+333.3, 16.0+666.6, 300, 300);
	        		}
	        	}
	        	else {
	        		if (event.getSceneY() <= 333.3) {
	            		gc.strokeOval(16.0+666.6, 16.0, 300, 300);
	        		}
	        		else if (event.getSceneY() <= 666.6) {
	        			gc.strokeOval(16.0+666.6, 333.3+16.0, 300, 300);
	        		}
	        		else {
	        			gc.strokeOval(16.0+666.6, 16.0+666.6, 300, 300);
	        		}
        		}
        	}
        	else {
        		if (event.getSceneX() <= 433.3) {
	        		if (event.getSceneY() <= 333.3) {
	        			//drawX(1,1);
	        			gc.strokeLine(16.0, 16.0, 316, 300+16.0);
	        			gc.strokeLine(316.0, 16.0, 16.0, 300+16.0);
	        		}
	        		else if (event.getSceneY() <= 666.6) {
	        			//drawX(2,1);
	        			gc.strokeLine(16.0, 333.3+16.0, 316, 633.3+16.0);
	        			gc.strokeLine(316.0, 333.3+16.0, 16.0, 633.3+16.0);
	        		}
	        		else {
	        			//drawX(3,1);
	        			gc.strokeLine(16.0, 666.6+16.0, 316, 966.6+16.0);
	        			gc.strokeLine(316.0, 666.6+16.0, 16.0, 966.6+16.0);
	        		}
	        	} 
	        	else if (event.getSceneX() <= 766.6) {
	        		if (event.getSceneY() <= 333.3) {
	        			gc.strokeLine(16.0+333.3, 16.0, 316+333.3, 316);
	        			gc.strokeLine(316.0+333.3, 16.0, 16.0+333.3, 316.0);
	        		}
	        		else if (event.getSceneY() <= 666.6) {
	        			gc.strokeLine(16.0+333.3, 333.3+16.0, 316+333.3, 633.3+16.0);
	        			gc.strokeLine(316.0+333.3, 333.3+16.0, 16.0+333.3, 633.3+16.0);
	        		}
	        		else {
	        			gc.strokeLine(16.0+333.3, 666.6+16.0, 316+333.3, 966.6+16.0);
	        			gc.strokeLine(316.0+333.3, 666.6+16.0, 16.0+333.3, 966.6+16.0);
	        		}
	        	}
	        	else {
	        		if (event.getSceneY() <= 333.3) {
	        			gc.strokeLine(16.0+666.6, 16.0, 316+666.6, 316);
	        			gc.strokeLine(316.0+666.6, 16.0, 16.0+666.6, 316.0);
	        		}
	        		else if (event.getSceneY() <= 666.6) {
	        			gc.strokeLine(16.0+666.6, 333.3+16.0, 316+666.6, 633.3+16.0);
	        			gc.strokeLine(316.0+666.6, 333.3+16.0, 16.0+666.6, 633.3+16.0);
	        		}
	        		else {
	        			gc.strokeLine(16.0+666.6, 666.6+16.0, 316+666.6, 966.6+16.0);
	        			gc.strokeLine(316.0+666.6, 666.6+16.0, 16.0+666.6, 966.6+16.0);
	        		}
        		}
        	}
        }
        public void drawO() {
        	
        }
        public void drawX(GraphicsContext gc, int row, int col) {
        	//gc.setFill(color.BLACK);
        	double yTop = ((row-1)*333.3)+16.0;
        	double xTop = 16.0+((col-1)*333.3);
        	double xBot = xTop+300.0;
        	double yBot = yTop+300.0;
        	gc.strokeLine(xTop,yTop, xBot, yBot);
        	gc.strokeLine(xBot, yTop, xTop, yBot);
        }
	}
}