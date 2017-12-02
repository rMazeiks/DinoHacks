package main;

import game.GameObject;
import javafx.concurrent.Task;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18rmazeiks
 */
public class DinoGame extends Task {
	final GraphicsContext graphics;

	List<GameObject> gameObjects;

	public DinoGame(Canvas canvas) {
		super();

		gameObjects = new ArrayList<>();
		graphics = canvas.getGraphicsContext2D();
		canvas.setOnKeyPressed(new DinoKeyHandler(this));
	}

	@Override
	protected Object call() throws Exception {
		return null;
	}

	public void jump() {

	}
}
