package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import control.GameController;

public class MainAreaPanel extends GamePanel{
	public static final String GB = "GAME_BOARD";
	public static final String HOF = "HALL_OF_FAME";
	HallOfFame hallOfFame;
	JPanel gameBoard;
	CardLayout cards;
	JTextArea plBests;
	
	public MainAreaPanel(GameController gc) {
		super(gc);
		this.cards= new CardLayout();
		this.setLayout(this.cards);
		this.setPreferredSize(new Dimension(WIDTH - 2 * MainWindow.PLAYER_WIDTH, MainWindow.HEIGHT - MainWindow.TOP_HEIGHT));
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.GRAY,1,true));
		
		plBests = new JTextArea(10,100);		
		plBests.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH,400));
		plBests.setAlignmentX(CENTER_ALIGNMENT);
		Font statsf = new Font("SansSerif", Font.BOLD,20);
		plBests.setFont(statsf);
		plBests.setEnabled(false);		
		plBests.setMargin(new Insets(10, 10, 10, 10));
		
		this.add(plBests);
		//hallOfFame.gc.getModel().getPlayerCatalogue().findHallOfFame(5, plBests);
		
		hallOfFame = new HallOfFame(this.gc);
		gameBoard = new GameBoard(this.gc);
		this.add(HOF,hallOfFame);
		this.add(GB,gameBoard);
	}
	public void showCard(String s) {		
		cards.show(this, s);		
	}
}