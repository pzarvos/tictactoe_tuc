package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import control.GameController;
import model.Player;

public class PlayerPanel extends GamePanel {
	GameController gc;
	JButton selectPlayerBtn;
	int pos;
	String currentPlayerName;
	Player currentPlayer;
	JTextField plName;
	JLabel plMark;
	JTextArea plStats;
	
	public PlayerPanel(GameController gc,int pos) { 
		super(gc);
		this.gc = gc;
		this.pos=pos;
		BoxLayout bl = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH,MainWindow.HEIGHT-MainWindow.TOP_HEIGHT));
		this.setBorder(new LineBorder(Color.GRAY,1,true));
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		this.currentPlayer = new Player(null,null);
		
		selectPlayerBtn = new JButton("Choose Player");
		selectPlayerBtn.setPreferredSize(new Dimension(150,40));
		selectPlayerBtn.setAlignmentX(CENTER_ALIGNMENT);
		selectPlayerBtn.addActionListener((e)->{changePlayer();});
		
		
		this.add(selectPlayerBtn);
		
		plName = new JTextField();
		plName.setPreferredSize(new Dimension(150,40));
		plName.setAlignmentX(CENTER_ALIGNMENT);
		plName.setHorizontalAlignment(JTextField.CENTER);
		plName.setEnabled(false);
		this.add(plName);
		
		plMark = new JLabel(pos==0? "X" : "O");
		plMark.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH,80));
		plMark.setAlignmentX(CENTER_ALIGNMENT);
		plMark.setHorizontalAlignment(JTextField.CENTER);
		plMark.setEnabled(false);
		Font markf = new Font("SansSerif", Font.BOLD,90);
		plMark.setFont(markf);
		
		
		plStats = new JTextArea(10,100);		
		plStats.setPreferredSize(new Dimension(MainWindow.PLAYER_WIDTH,400));
		plStats.setAlignmentX(CENTER_ALIGNMENT);
		Font statsf = new Font("SansSerif", Font.BOLD,20);
		plStats.setFont(statsf);
		plStats.setEnabled(false);		
		plStats.setMargin(new Insets(10, 10, 10, 10));
		
		this.add(plMark);
		this.add(plName);		
		this.add(plStats);
		
	}

		
 
	private void changePlayer() {
		
		//get list of all players
		String[] allPlayersNames = gc.getModel().getPlayerCatalogue().getListOfPlNames();
		Arrays.sort(allPlayersNames);
		//show player selection
		String selPlayer = (String) JOptionPane.showInputDialog(this, "Choose a Player...", "Player Selection", JOptionPane.PLAIN_MESSAGE, null, allPlayersNames, currentPlayer);
		//set selected player
		if(selPlayer != null) { 
			if (selPlayer.equals(gc.getModel().getGamePlayers()[pos==0?1:0].getPlName())) {
				JOptionPane.showMessageDialog(gc.getView(),"This player has already been selected", "Ooopsss....", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			this.currentPlayer=gc.getModel().getPlayerCatalogue().findPlayer(selPlayer);	
			gc.selectPlayer(currentPlayer,pos);
			this.plName.setText(selPlayer);
			this.setPlayerStats(gc.getModel().getPlayerStats(currentPlayer));
			this.repaint();
			}
	}
			
	

	public JButton getSelectPlayerBtn() {
		return selectPlayerBtn;
	}

	public void setSelectPlayerBtn(JButton selectPlayerBtn) {
		this.selectPlayerBtn = selectPlayerBtn;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public JTextField getPlName() {
		return plName;
	}

	public void setPlName(JTextField plName) {
		this.plName = plName;
	}
	public void setPlayerStats(String stats) {
		this.plStats.setText(stats);
	}
	
	

	
}