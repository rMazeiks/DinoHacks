package game;

import javafx.scene.canvas.Canvas;

/**
 * Created by 18rmazeiks
 */
public class Hero implements Renderable {
	double x, y;
	double velY;

	@Override
	public void render(Canvas canvas) {

	}

	public void jump() {
		System.out.println("I'm jumping!!!");
		//todo;
	}
}
