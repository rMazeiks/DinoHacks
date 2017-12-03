package game.objects;

import game.GameObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.DinoGame;

/**
 * Created by 18rmazeiks
 */
public class Cactus extends GameObject {
	public int width;
	public int height;
	DinoGame dinoGame;

	public Cactus(DinoGame dinoGame, double x, int height, boolean top) {
		this.dinoGame = dinoGame;
		this.x = x;
		this.y = top ? -height : 0;
		this.width = 30;
		this.height = height;
	}

	public void render(Canvas canvas) {
		GraphicsContext graphic = canvas.getGraphicsContext2D();
		graphic.setFill(new Color(0.2, 0.6, 0, 1));
		graphic.fillRoundRect(x, y, width, height, 10, 10);
	}

	@Override
	public boolean interact(Hero hero, long now) {
		double hx = hero.getX();
		double hy = hero.getY();
		double r = Hero.radius;
		if (hx + r > x + 1 && hx - r < x + width - 1 &&
				hy + r > y + 1 && hy - r < y + height - 1) {
			dinoGame.onDie.apply(null);
		}
		return true;
	}

}
