package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import control.GameController;

public class HallOfFame extends GamePanel {
	public HallOfFame(GameController gc) { 
		super(gc);
		this.setBackground(Color.WHITE);
		this.add(new JLabel("Hall OF Fame"));
	}

}
