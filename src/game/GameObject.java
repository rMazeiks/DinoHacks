package game;

import game.objects.Hero;

/**
 * Created by 18rmazeiks
 */
public abstract class GameObject implements Renderable {
	double x, y;

	/**
	 * Computes
	 * @param hero
	 * @return
	 */
	public abstract boolean interact(Hero hero);
}
