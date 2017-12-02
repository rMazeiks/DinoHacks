package game.objects;

import game.GameObject;
import game.Hero;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by 18rmazeiks
 */
public class Floor extends GameObject {
	boolean flipped;

	@Override
	public void render(Canvas canvas) {
		double half = canvas.getHeight() / 2;

		final GraphicsContext graphics = canvas.getGraphicsContext2D();

		graphics.fillRect(0, half, canvas.getWidth(), half * (flipped ? -1 : 1));
	}

	@Override
	public void interact(Hero hero) {

	}
}
