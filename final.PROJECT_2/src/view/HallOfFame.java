package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import control.GameController;

public class HallOfFame extends GamePanel{
	
	
	public HallOfFame(GameController gc) {
		super(gc);
	}
	
	@Override
	public void paint(Graphics g) {
		int x = this.getWidth()-350;
		int y = this.getHeight()-680;
		g.drawString("HALL OF FAME", x, y);
	}
	
	/*public void topPlayers() { 
		gc.getModel().getPlayerCatalogue().findHallOfFame(10);
	}*/

}