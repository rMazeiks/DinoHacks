package main;

import game.GameObject;
import game.objects.Floor;
import game.objects.Hero;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18rmazeiks
 */
public class DinoGame extends AnimationTimer {

	private final Canvas canvas;
	private final Floor floor;
	private final List<GameObject> gameObjects;
	private Hero hero;

	public DinoGame(Canvas canvas) {
		super();

		gameObjects = new ArrayList<>();
		floor = new Floor();
		hero = new Hero(this);
		gameObjects.add(hero);

		this.canvas = canvas;

		canvas.getGraphicsContext2D().translate(0, canvas.getHeight() / 2);
	}

	public Floor getFloor() {
		return floor;
	}

	public Hero getHero() {
		return hero;
	}

	@Override
	public void handle(long now) {

		for (int i = 0; i < gameObjects.size(); i++) {
			canvas.getGraphicsContext2D().save();

			GameObject obj = gameObjects.get(i);
			if (obj instanceof Floor) {
			} else {
				canvas.getGraphicsContext2D().translate(100 - hero.getX(), 0);
			}

			if (!obj.interact(hero)) {
				gameObjects.remove(i);
				i--;
			} else {
				obj.render(canvas);
			}

			canvas.getGraphicsContext2D().restore();
		}

		floor.render(canvas);
	}
}
