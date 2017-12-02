package main;

import game.GameObject;
import game.objects.Hero;
import game.objects.Floor;
import game.objects.Point;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 18rmazeiks
 */
public class DinoGame extends AnimationTimer {

	private final Canvas canvas;
	private final Floor floor;
	List<GameObject> gameObjects;
	Hero hero;

	public DinoGame(Canvas canvas) {
		super();

		gameObjects = new ArrayList<>();
		floor = new Floor();
		hero = new Hero();
		gameObjects.add(hero);

		this.canvas = canvas;

		canvas.getGraphicsContext2D().translate(0, canvas.getHeight() / 2);
	}

	public Hero getHero() {
		return hero;
	}

	int count = 0;
	@Override
	public void handle(long now) {
	    count++;
	    if(count%360==0) {
            gameObjects.add(new Point(hero.getX() + Math.random() * 200 + 300, Math.random()*-150 -50));
        }

       GraphicsContext graphics =  canvas.getGraphicsContext2D();

        graphics.setFill(new Color(1,1,1,1));
        graphics.fillRect(0,-canvas.getHeight()/2, canvas.getWidth(), canvas.getHeight());

        graphics.save();
        graphics.translate(100 - hero.getX(), 0);



        for (int i = 0; i < gameObjects.size(); i++) {

			GameObject obj = gameObjects.get(i);


			if (!obj.interact(hero)) {
				gameObjects.remove(i);
				i--;
			} else {
				obj.render(canvas);
			}

		}



        graphics.restore();

        floor.render(canvas);
	}
}
