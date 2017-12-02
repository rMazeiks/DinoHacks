package game.objects;

import game.GameObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by 18rmazeiks
 */
public class Floor extends GameObject {
	private static final Color floorColor = new Color(0, 0, 0, 1);
	private boolean flipped = false;

	public boolean isFlipped() {
		return flipped;
	}

	@Override
	public void render(Canvas canvas) {
		double half = canvas.getHeight() / 2;

		final GraphicsContext graphics = canvas.getGraphicsContext2D();
		graphics.setFill(floorColor);
		graphics.fillRect(0, 0, canvas.getWidth(), half * (flipped ? -1 : 1));
	}

	@Override
	public boolean interact(Hero hero, long now) {
		int m = flipped ? 1 : -1;
		if (hero.getVelY() * m > 0 && y * m > -Hero.radius) {
			hero.anounceContact();
		}
		return true;
	}
}
