package control;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import model.GameModel;
import model.Player;
import view.MainAreaPanel;
import view.MainWindow;

public class GameController extends WindowAdapter {
	MainWindow view;
	GameModel model;

	public GameController() {		
		
	}
	
	
	@Override
	public void windowClosing(WindowEvent event) {
		quit();
	}
	
	
	public void start() {
		this.view= new MainWindow(this);
		this.model = new GameModel(this);
		this.view.addWindowListener(this);
		this.view.setVisible(true);
	}
	public void done() {
		this.model.setGameBoard(new String[3][3]);
		this.view= new MainWindow(this);
		this.model = new GameModel(this);
		this.view.addWindowListener(this);
		this.view.setVisible(true);
	}
	public void quit() {		
		System.out.println("bye bye...");		
		System.exit(0);
	}
	
	public void askToAddPlayer() {	
		
		//Object[] possibilities = {null};
		Component frame = null;
		String s = (String)JOptionPane.showInputDialog(frame,"Add player's name:\n" );
 	
	}
	

	public void selectPlayer(Player p, int pos) {
		this.model.selectPlayer(p, pos);
		String plName = p.getPlName();
		System.out.println("Player " + pos + " set to " + plName);
		this.view.getTopPanel().getStartGameBtn().setEnabled(model.ready());
	}
	
	public void startGame() {
		
		this.model.setGameBoard(new String[3][3]);
		System.out.println("Game Starts");
		this.view.getTopPanel().getStartGameBtn().setEnabled(false);
		this.view.getMainPnl().showCard(MainAreaPanel.GB);
		this.view.getLeftPnl().getSelectPlayerBtn().setEnabled(model.NoPlay());
		this.view.getRightPnl().getSelectPlayerBtn().setEnabled(model.NoPlay());
	}
	
	public GameModel getModel() {
		return model;
	}
	
	public MainWindow getView() {
		return view;
	}
	
}
