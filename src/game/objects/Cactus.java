package game.objects;

import game.GameObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by 18rmazeiks
 */
public class Cactus extends GameObject {
	public int width;
	public int height;

	public Cactus(double x, int height, boolean top) {
		this.x = x;
		this.y = top ? -height : 0;
		this.width = 30;
		this.height = height;
	}

	public void render(Canvas canvas) {
		GraphicsContext graphic = canvas.getGraphicsContext2D();
		graphic.setFill(new Color(0, 1, 0, 1));
		graphic.fillRect(x, y, width, height);
	}

	@Override
	public boolean interact(Hero hero, long now) {
		if (Math.hypot(x - hero.getX(), y - hero.getY()) < 30) {
			hero.gameOver();
		}
		return true;
	}

}
