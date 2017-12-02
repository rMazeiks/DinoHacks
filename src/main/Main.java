package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The main class that creates a window
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		StackPane root = new StackPane();

		final Canvas canvas = new Canvas(600, 400);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);

		primaryStage.setTitle("Dino");

		Scene gameView = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setScene(gameView);
		primaryStage.show();

		DinoGame runner = new DinoGame(canvas);
		gameView.setOnKeyPressed(new DinoKeyHandler(runner));


		runner.start();
	}

	public static void main(String[] args) {
		launch("");
	}
}
