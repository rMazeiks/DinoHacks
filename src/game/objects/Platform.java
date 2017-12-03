package game.objects;

import game.GameObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.DinoGame;

/**
 * Created by 18rmazeiks
 */
public class Platform extends GameObject {
	double width;
	DinoGame dinoGame;

	public Platform(double x, double y, double width, DinoGame dinoGame)  {
		this.x = x;
		this.y = y;
		this.width = width;
		this.dinoGame = dinoGame;
	}

	@Override
	public void render(Canvas canvas) {
		final GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(new Color(.1, 0, .7, .5));
		graphics.fillRect(x, y, width, 10);
	}

	@Override
	public boolean interact(Hero hero, long now) {
	    Hero h = dinoGame.getHero();
	    if ((Hero.radius + h.getX() < this.x) && (Hero.radius + h.getY() > 1.5 * this.y))  {
	        hero.announceContact();
        }
        return true;
	}
}
