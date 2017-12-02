package main;

import game.GameObject;
import game.objects.Floor;
import game.objects.Hero;
import game.objects.Point;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18rmazeiks
 */
public class DinoGame extends AnimationTimer {

	private final Canvas canvas;
	private final Floor floor;
	private final List<GameObject> gameObjects;
	int count = 0;
	long next = 0;
	private Hero hero;

	public DinoGame(Canvas canvas) {
		super();

		gameObjects = new ArrayList<>();
		floor = new Floor();
		hero = new Hero(this);

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
		hero.clearContact();
		if (now > next) {
			gameObjects.add(new Point(hero.getX() + canvas.getWidth(), Math.random() * -50 - 25));
			next = now + 2000000000;
		}

		GraphicsContext graphics = canvas.getGraphicsContext2D();

		graphics.setFill(new Color(1, 1, 1, 1));
		graphics.fillRect(0, -canvas.getHeight() / 2, canvas.getWidth(), canvas.getHeight());

		graphics.save();
		graphics.translate(100 - hero.getX(), 0);

		hero.render(canvas);

		for (int i = 0; i < gameObjects.size(); i++) {

			GameObject obj = gameObjects.get(i);

			if (!obj.interact(hero, now)) {
				gameObjects.remove(i);
				i--;
			} else {
				obj.render(canvas);
			}

		}

		graphics.restore();

		floor.interact(hero, now);
		floor.render(canvas);

		hero.interact(null, now);
	}
}
