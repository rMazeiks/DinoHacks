package game.objects;

import game.GameObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.DinoGame;

/**
 * Created by 18rmazeiks
 */
public class Floor extends GameObject {
	private static final Color floorColor = new Color(0, 0, 0, 0.5);
	long next = 0;
	DinoGame dinoGame;
	boolean needsFilp = false;
	private boolean flipped = false;

	public Floor(DinoGame dinoGame) {
		this.dinoGame = dinoGame;
	}

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
			needsFilp = true;
		}

		int m = multiplier();

		if (needsFilp && dinoGame.getHero().getVelY() * m > 1) {
			flipped = !flipped;
			needsFilp = false;
			next = now + 10000000000L;
		}

		if (hero.getY() * m > (-Hero.radius - 1)) {
			hero.announceContact();
		}
		return true;
	}

	public int multiplier() {
		return flipped ? -1 : 1;
	}
}
