package game.objects;

import game.GameObject;
import javafx.scene.canvas.Canvas;

/**
 * Created by 18rmazeiks
 */
public class Platform extends GameObject {
	@Override
	public void render(Canvas canvas) {

	}

	@Override
	public boolean interact(Hero hero, long now) {
		return true;
	}
}
