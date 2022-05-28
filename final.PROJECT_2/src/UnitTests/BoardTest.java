package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Board;

class BoardTest {
	private Board board;
	 
	
	@BeforeEach
	public void setUp () { 
		board = new Board();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void movesLeftTest() {
		char[][] exb = {{'O','O',' '},
						{'X','X',' '},
						{' ',' ',' '}};
	assertTrue(board.movesLeft(exb));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void checkWinnerTest() { 
		char[][] exb = {{'O','O','O'},
						{'X','X',' '},
						{' ',' ',' '}};
		assertEquals(-10,board.checkWinner(exb));
		char[][] exb2 = {{'O','O',' '},
						 {'X','X','X'},
						 {' ',' ',' '}};
		assertEquals(10,board.checkWinner(exb2));
		char[][] exb3 = {{'O','O','X'},
				 		 {'O','X',' '},
				 		 {'O','X',' '}};
		assertEquals(-10,board.checkWinner(exb3));
		char[][] exb4 = {{'X','X','O'},
						 {'X','O',' '},
						 {'X','O',' '}};
		assertEquals(10,board.checkWinner(exb4));
		char[][] exb5 = {{'O','X',' '},
						 {'X','O',' '},
						 {' ',' ','O'}};
		assertEquals(-10,board.checkWinner(exb5));
		char[][] exb6 = {{'X','O',' '},
						 {'O','X',' '},
						 {' ',' ','X'}};
		assertEquals(10,board.checkWinner(exb6));
	}	
}


