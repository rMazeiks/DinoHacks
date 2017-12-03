package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.Function;

/**
 * The main class that creates a window
 */
public class Main extends Application {
	DinoGame runner;
	Function<Void, Void> onDie;

	public static void main(String[] args) {
		launch("");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Dino");


		VBox menu = new VBox();
		menu.setSpacing(20);
		menu.setAlignment(Pos.CENTER);
		Label title = new Label("DinoHacks!");
		menu.getChildren().add(title);
		Button play = new Button("Play");
		play.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				StackPane gamePane = new StackPane();

				final Canvas canvas = new Canvas(600, 400);
				GraphicsContext gc = canvas.getGraphicsContext2D();
				gamePane.getChildren().add(canvas);

				Scene gameView = new Scene(gamePane);

				runner = new DinoGame(canvas);
				gameView.setOnKeyPressed(new DinoKeyHandler(runner));
				primaryStage.setScene(gameView);
				runner.onDie = onDie;
				runner.start();
			}
		});
		menu.getChildren().add(play);
		Scene menuView = new Scene(menu, 600, 400);

		onDie = o -> {
			runner.stop();
			primaryStage.setScene(menuView);
			return null;
		};

		primaryStage.setResizable(false);
		primaryStage.setScene(menuView);
		primaryStage.show();

	}
}
