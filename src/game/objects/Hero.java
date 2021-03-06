package game.objects;

import game.GameObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.DinoGame;

/**
 * Created by 18rmazeiks
 */
public class Hero extends GameObject {
	public static final double radius = 20;
	private static Color fill = new Color(0, 0, 0, 1);
	double yTrack;
	double velY;

	public int getPoints() {
		return points;
	}

	int points = 0;
	long last = 0;
	boolean firstIteration = true;
	private DinoGame dinoGame;
	private boolean touchingGround; // or platform 1 = touching, 2 = submerge
	private boolean needsJump = false;

	public Hero(DinoGame dinoGame) {
		this(dinoGame, 0, 0);
	}

	public Hero(DinoGame dinoGame, double x, double y) {
		this.dinoGame = dinoGame;
		this.x = x;
		this.y = y;
		velY = 0;
		yTrack = y;
	}

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
		graphics.fillOval(x - radius, yTrack - radius, 2 * radius, 2 * radius);
	}

	public void jump() {
		needsJump = true;
	}

	public double getX() {
		return x;
	}

	@Override
	public boolean interact(Hero hero, long now) {
		long diff = firstIteration ? 0 : now - last;
		firstIteration = false;
		last = now;

		int m = dinoGame.getFloor().multiplier();

		if (touchingGround && velY * m > 0) {
			velY = 0;
			y = m * -radius;
		} else {
			velY += (y < 0 ? 1 : -1) * diff / 10000000;
		}

		if (needsJump) {
			if (touchingGround) {
				velY = m * -16;
			}
			needsJump = false;
		}

		x = ((double) now) / 2000000;
		y += velY;

		yTrack += ((y - yTrack) / 2 * Math.min(Math.max(diff / 10000000, -1), 1));

		return true;
	}

	public void announceContact() {
		touchingGround = true;
	}

	public void clearContact() {
		touchingGround = false;

	}

	public void receivePoint() {
		points++;
		System.out.println("points: " + points);
	}
}
