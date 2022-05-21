package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.GameController;

public class MainAreaPanel extends GamePanel{
	public static final String GB = "GAME_BOARD";
	public static final String HOF = "HALL_OF_FAME";
	HallOfFame hallOfFame;
	GameBoard gameBoard;
	
	CardLayout cards;
	
	public MainAreaPanel(GameController gc) {
		super(gc);
		this.cards = new CardLayout();
		this.setLayout(cards);
		
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.GRAY,1,true));
		this.setPreferredSize(new Dimension(WIDTH-2 * MainWindow.PLAYER_WIDTH,MainWindow.HEIGHT - MainWindow.TOP_HEIGHT));	
		
		hallOfFame = new HallOfFame(this.gc);
		gameBoard = new GameBoard(this.gc);
		this.add("HOF",hallOfFame);
		this.add("GB",gameBoard);
	}

	public void showCard(String s) {		
		cards.show(this, s);		
	}
}