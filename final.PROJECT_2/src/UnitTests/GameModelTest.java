package UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import control.GameController;
import model.GameModel;

class GameModelTest {
	private GameModel gameModel;
	private GameController gc;
	
	@BeforeEach
	public void setUp() { 
		gc = new GameController();
		gameModel = new GameModel(gc);
	}
	
	@Test
	public void makeMoveTest() { 
		assertEquals(0,gameModel.makeMove(1, 2));
	}
}