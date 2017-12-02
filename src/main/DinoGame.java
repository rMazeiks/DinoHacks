package main;

import javafx.concurrent.Task;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by 18rmazeiks
 */
public class DinoGame extends Task {
	final GraphicsContext graphics;

	public DinoGame(Canvas canvas) {
		graphics = canvas.getGraphicsContext2D();
		canvas.setOnKeyPressed(new DinoKeyHandler(this));
	}

	@Override
	protected Object call() throws Exception {
		return null;
	}

	public void jump()  {

	}
}
