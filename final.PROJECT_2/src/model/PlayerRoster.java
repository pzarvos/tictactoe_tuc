package model;

import java.util.ArrayList;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import control.GameController;

public class PlayerRoster {
	private Player[] listOfPlayers;
	private ArrayList<String> listOfPlNames;
	private ArrayList<Float> listOfPlScores;
	private int numOfPls;
	private int i;
	

	public PlayerRoster(){
		
		this.listOfPlayers = new Player[50];

		this.addPls(new Player("Eleni",new PlHistory(3, 2, 1, 0)));
		this.addPls(new Player("Hal",new PlHistory(2, 1, 1, 0)));
		this.addPls(new Player("Mr.Bean",new PlHistory(1, 1, 0, 0)));
		this.addPls(new Player("Roberto",new PlHistory(3, 2, 1, 0)));
		this.addPls(new Player("andreas",new PlHistory(4, 2, 2, 0)));
		this.addPls(new Player("marios",new PlHistory(2, 1, 1, 0)));
		
		this.listOfPlNames = new ArrayList<String>();
        
		this.listOfPlNames.add(this.listOfPlayers[0].getPlName());
		this.listOfPlNames.add(this.listOfPlayers[1].getPlName());
		this.listOfPlNames.add(this.listOfPlayers[2].getPlName());
		this.listOfPlNames.add(this.listOfPlayers[3].getPlName());
		this.listOfPlNames.add(this.listOfPlayers[4].getPlName());
		this.listOfPlNames.add(this.listOfPlayers[5].getPlName());
		
		//convertFromArrToStr(this.listOfPlNames);
		//fillPlNameList();
	
	}
	public void addPls(Player p) {
		listOfPlayers[numOfPls]=p;
		numOfPls++;
	}
	public String[] convertFromArrToStr(ArrayList<String> list) {
		String[] str = new String[list.size()];
		 
        for (int i = 0; i < list.size(); i++) {
            str[i] = list.get(i);
        }
        return str;
	}
	
	public void fillPlNameList() {
		for(i = 0; i<this.numOfPls; i++) {
			this.listOfPlNames.add(this.listOfPlayers[i].getPlName());
		}
		
	}
	public void fillPlScore() {
		for(int w = 0 ; w < numOfPls ;w ++) {
			this.listOfPlScores.add(this.listOfPlayers[w].getHistory().getPlScore());
		}
	}
	
	public void addPlayerByName(String s) {	
			this.listOfPlayers[numOfPls] = new Player(s,null);			
			this.numOfPls++;	
	}
	
	public void addPlayerName(String s) {
	listOfPlNames.add(s);
	this.numOfPls++;
	}
	
	public void findPlayerNames(Player[] list){
			System.out.println("The players...:");
			for(int i=0;i<list.length;i++) {
				if(list[i]!=null) {
				System.out.println((i+1)+"."+list[i].getPlName());
				}
			}
	}
	
	public Player findPlayer(String name) {
		for(Player pl : this.listOfPlayers) {
			if((pl != null) && pl.getPlName().equals(name)) {
				return pl;
			}
		}
		//System.out.println("ERROR PLAYER NOT FOUND");
		return null;
		
	}
	
		public void findHallOfFame(int x, JTextArea area) {
			 //Collections.sort(listOfPlScores,Collections.reverseOrder());
			String a;
	        StringBuilder sb = new StringBuilder("");	
	         for(int i = 0; i < x ; i++) { 
	        sb.append(listOfPlayers[i].getPlName()).append("\n");
	         }
	         a = sb.toString();
	 		area.setText(a);

		}
	public int getNumOfPls() {
		return numOfPls;
	}


	public void setNumOfPls(int numOfPls) {
		this.numOfPls = numOfPls;
	}

	public Player[] getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(Player[] listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}
	public ArrayList getListOfPlNames() {
		return listOfPlNames;
	}
	public void setListOfPlNames(ArrayList listOfPlNames) {
		this.listOfPlNames = listOfPlNames;
	}

	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

	
	
}