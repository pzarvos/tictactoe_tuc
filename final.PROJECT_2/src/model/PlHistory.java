package model;

import java.util.ArrayList;

public class PlHistory {
	int PlGames ;
	int PlWins ;
	int PlLoses ;
	int PlDraws ;
	float PlScore ;
	private GameRecord[] listOfGamesRec;
	private GameRecord[] listOfGamesBest;
	
	
	public PlHistory(int games,int wins,int loses,int draws){
		this.PlGames = games;
		this.PlWins = wins;
		this.PlLoses = loses;
		this.PlDraws = draws;
		this.listOfGamesRec = new GameRecord[5];
		this.listOfGamesBest = new GameRecord[5];	
	}
	
	//GETTERS_SETTERS

	 public int getPlDraws() {
		return PlDraws;
	}

	public void setPlDraws(int plDraws) {
		PlDraws = plDraws;
	}

	public float getPlScore() {
		return PlScore;
	}

	public void setPlScore(float plScore) {
		PlScore = plScore;
	}

	public GameRecord[] getListOfGamesRec() {
		return listOfGamesRec;
	}

	public void setListOfGamesRec(GameRecord[] listOfGamesRec) {
		this.listOfGamesRec = listOfGamesRec;
	}

	public GameRecord[] getListOfGamesBest() {
		return listOfGamesBest;
	}

	public void setListOfGamesBest(GameRecord[] listOfGamesBest) {
		this.listOfGamesBest = listOfGamesBest;
	}

	public int getPlGames() {
		return PlGames;
	}

	public void setPlGames(int plGames) {
		PlGames = plGames;
	}

	public int getPlWins() {
		return PlWins;
	}

	public void setPlWins(int plWins) {
		PlWins = plWins;
	}

	public int getPlLoses() {
		return PlLoses;
	}

	public void setPlLoses(int plLoses) {
		PlLoses = plLoses;
	}
	//calculate score of each player 
		public float PlScore() {
			if(getPlGames() == 0) {
				PlScore=0;
			}
			else if(getPlGames()!=0) {
			PlScore = 50 * ((2*getPlWins()+getPlDraws())/getPlGames());
			}
			return PlScore;
		}

	}