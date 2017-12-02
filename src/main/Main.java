package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The main class that creates a window
 */
public class Main extends Application {
	GraphicsContext gc;

	@Override
	public void start(Stage primaryStage) throws Exception {

		StackPane root = new StackPane();

		final Canvas canvas = new Canvas(250, 250);
		gc = canvas.getGraphicsContext2D();

		root.getChildren().add(canvas);

		primaryStage.setTitle("Dino");

		primaryStage.setScene(new Scene(root, 300, 275));
		primaryStage.show();

		GameRunner runner = new GameRunner();
		runner.run();
	}


}
