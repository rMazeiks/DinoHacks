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
	double x;
	double y;
	double velY;
	int points = 0;
	private DinoGame dinoGame;
	private boolean touchingGround; // or platform
	private boolean needsJump = false;

	public Hero(DinoGame dinoGame) {
		this(dinoGame, 0, 0);
	}

	public Hero(DinoGame dinoGame, double x, double y) {
		this.dinoGame = dinoGame;
		this.x = x;
		this.y = y;
		velY = 0;
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
		graphics.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}

	public void jump() {
		needsJump = true;
	}

	public double getX() {
		return x;
	}

	@Override
	public boolean interact(Hero hero, long now) {
		if (touchingGround) {
			velY = 0;
			y = -radius;
		} else {
			velY++;
		}

		if (needsJump) {
			if (touchingGround) {
				velY = -10;
			}
			needsJump = false;
		}

		x = ((double) now) / 2000000;
		y += velY;

		return true;
	}

	private int multiplier() {
		return dinoGame.getFloor().isFlipped() ? 1 : -1;
	}

	public void announceContact() {
		touchingGround = true;
	}

	public void clearContact() {
		touchingGround = false;

	}

	public void getPoint() {
		points++;
		System.out.println("points: " + points);
	}
}
