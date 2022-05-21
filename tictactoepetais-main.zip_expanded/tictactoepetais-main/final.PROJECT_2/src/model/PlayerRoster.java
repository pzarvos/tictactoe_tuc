package model;

import java.util.Scanner;

public class PlayerRoster {
	private Player[] listOfPlayers;
	private String[] listOfPlNames;
	private int numOfPls;
	
		public void addPls(Player p) {
			listOfPlayers[numOfPls]=p;
			numOfPls++;
		}
		
	
	public PlayerRoster(){
		this.listOfPlayers = new Player[50];
		this.addPls(new Player("Eleni", null));
		this.addPls(new Player("Miguel", null));
		this.addPls(new Player("Panais", null));
		this.addPls(new Player("Roberto", null));
		this.addPls(new Player("Hal",null));
		this.addPls(new Player("Mr.Bean", null));
		
		this.listOfPlNames = new String[6];
		listOfPlNames[0] = this.listOfPlayers[0].getPlName();
		listOfPlNames[1] = this.listOfPlayers[1].getPlName();
		listOfPlNames[2] = this.listOfPlayers[2].getPlName();
		listOfPlNames[3] = this.listOfPlayers[3].getPlName();
		listOfPlNames[4] = this.listOfPlayers[4].getPlName();
		listOfPlNames[5] = this.listOfPlayers[5].getPlName();	
	}
	
	public String[] getListOfPlNames() {
		return listOfPlNames;
	}


	public void setListOfPlNames(String[] listOfPlNames) {
		this.listOfPlNames = listOfPlNames;
	}


	public void setListOfPlayers(Player[] listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
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
		System.out.println("ERROR PLAYER NOT FOUND");
		return null;
	}
	
	public void findHallOfFame(int x) {
		//SORTING_THE_ARRAY
	        int n = listOfPlayers.length;  
	        int temp = 0;  
	         for(int i=0; i < n; i++){  
	                 for(int j=1; j < (n-i); j++){  
	                          if(listOfPlayers[j-1].getHistory().PlWins > listOfPlayers[j].getHistory().PlWins ){  
	                                 //swap elements  
	                                 temp = listOfPlayers[j-1].getHistory().PlWins;  
	                                 listOfPlayers[j-1] = listOfPlayers[j];  
	                                 listOfPlayers[j].getHistory().PlWins  = temp;  
	                         }  
	                          
	                 }  
	         }  	  
	         System.out.println("The best"+" "+x+" "+"players...:");
				for(int ia=0;ia<5;ia++) {
					if(listOfPlayers[ia]!=null) {
						System.out.print(listOfPlayers[ia]);
					}
				}
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



	
	
}