package main;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * Created by 18rmazeiks
 */
public class DinoKeyHandler implements EventHandler<KeyEvent> {
	DinoGame dinoGame;
	public DinoKeyHandler(DinoGame dinoGame) {
		this.dinoGame = dinoGame;
	}

	@Override
	public void handle(KeyEvent event) {
		System.out.println("testing...");
	}
}
