package main;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
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
	    if (event.getCode().equals(KeyCode.SPACE) || event.getCode().equals(KeyCode.UP)) {
            dinoGame.getHero().jump();
        }
	}
}
