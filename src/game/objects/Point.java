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
        graphics.setFill(new Color(1,0.5,0,1));
        graphics.fillOval(x,y,15,25);
    }

	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean interact(Hero hero, long now) {
        if (Math.hypot(x-hero.getX(),y-hero.getY()) < 40) {
            hero.getPoint();
            return false;
        }
		return true;
	}
}
