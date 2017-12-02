package game;

/**
 * Created by 18rmazeiks
 */
public abstract class GameObject implements Renderable {
	double x, y;

	public abstract void interact(Hero hero);
}
