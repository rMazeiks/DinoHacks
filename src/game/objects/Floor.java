package game.objects;

import game.GameObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by 18rmazeiks
 */
public class Floor extends GameObject {
	private static final Color floorColor = new Color(0, 0, 0, 0.5);
	long next = 0;
	private boolean flipped = true;

	public boolean isFlipped() {
		return flipped;
	}

	@Override
	public void render(Canvas canvas) {
		double half = canvas.getHeight() / 2;

		final GraphicsContext graphics = canvas.getGraphicsContext2D();
		graphics.setFill(floorColor);
		graphics.fillRect(0, (flipped ? -half : 0), canvas.getWidth(), half);
	}

	@Override
	public boolean interact(Hero hero, long now) {
		if (now > next) {
			flipped = !flipped;
			next = now + 2000000000;
		}

		//int m = flipped ? 1 : -1;
		int m = multiplier();
		if (hero.getY() * m > (-Hero.radius - 1)) {
			hero.announceContact();
		}
		return true;
	}

	public int multiplier() {
		return flipped ? -1 : 1;
	}
}
