package game.objects;

import game.GameObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by 18rmazeiks
 */
public class Point extends GameObject {
	@Override
	public void render(Canvas canvas) {
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(new Color(0,0,0,1));
        graphics.fillOval(x,y,50,50);
    }

	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean interact(Hero hero) {
        if (Math.hypot(Math.abs(x-hero.getX()),Math.abs(y-hero.getY())) < 0.1) {
            System.out.println("touching coin");
        }
		return true;
	}
}
