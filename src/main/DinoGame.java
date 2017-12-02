package main;

import game.GameObject;
import game.Hero;
import game.objects.Floor;
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
	Hero hero;

	public DinoGame(Canvas canvas) {
		super();

		gameObjects = new ArrayList<>();

		graphics = canvas.getGraphicsContext2D();
	}

	@Override
	protected Object call() throws Exception {
		gameObjects.add(new Floor());
		hero = new Hero();


		return null;
	}

	public void jump() {

	}
}
