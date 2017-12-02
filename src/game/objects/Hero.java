package game.objects;

import game.GameObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by 18rmazeiks
 */
public class Hero extends GameObject {
	private static Color fill = new Color(0, 0, 0, 1);
	private static double radius = 20;
	double x;
	double y;
	double velY;

	public double getY() {
		return y;
	}

	public double getVelY() {
		return velY;
	}

	@Override
	public void render(Canvas canvas) {
		final GraphicsContext graphics = canvas.getGraphicsContext2D();
		graphics.setFill(fill);
		graphics.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}

	public void jump() {
		System.out.println("I'm jumping!!!");
		//todo;
	}

	public double getX() {
		return x;
	}

	@Override
	public boolean interact(Hero hero) {
		return true;
	}
}
