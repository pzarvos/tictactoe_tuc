package model;


import control.GameController;
import java.io.*;

public class GameModel {
	PlayerRoster  playerCatalogue;
	Player [] gamePlayers;		
	String[][] gameBoard;
	GameController gc;
	Boolean mover;
	
	
	public GameModel(GameController gc) {
		this.gc=gc;
		gamePlayers = new Player[2];
		gameBoard= null;
		playerCatalogue= new PlayerRoster();
		mover=false;
	}
	
	public GameController getGc() {
		return gc;
	}

	public void setGc(GameController gc) {
		this.gc = gc;
	}

	public Boolean getMover() {
		return mover;
	}

	public void setMover(Boolean mover) {
		this.mover = mover;
	}

	public void setGamePlayers(Player[] gamePlayers) {
		this.gamePlayers = gamePlayers;
	}

	public void checkDimValidity(int row, int col) {
		if (row <0 || col < 0 || row > 2 || col >2) {
			throw new IndexOutOfBoundsException(row + ","+col +" is not a valid board cell");
		}
	}
	
	public void checkMoveValidity(int row, int col) {
		checkDimValidity(row, col);
		if (gameBoard[row][col]!=null) {
			throw new IllegalArgumentException("Non playable cell");
		}
	}
	
	public String getBoardMark(int row, int col) {
		checkDimValidity(row, col);
		return gameBoard[row][col];
	}
	
	public void makeMove(int row, int col) {
		checkMoveValidity(row, col);
		gameBoard[row][col]=getMoverMark();
		mover=!mover;		
	}
	
	public String getMoverMark() {
		return mover? "X": "O";
	}
	
	public void selectPlayer(Player player, int pos) {
		if (pos<0 && pos>1)return;
		gamePlayers[pos]=player;		
	}
	
	public boolean ready() {
		return (gamePlayers[0] != null && gamePlayers[1] !=null);
	}
		
	public void startGame() {
		gameBoard= new String[3][3];
	}
	
	public boolean inPlay() {
		return gameBoard !=null;
	}
	
	public boolean NoPlay() {
		return !inPlay();
	}
	
	public Player[] getGamePlayers() {
		return gamePlayers;
	}

	public String[][] getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(String[][] gameBoard) {
		this.gameBoard = gameBoard;
	}

	public PlayerRoster getPlayerCatalogue() {
		return playerCatalogue;
	}

	public void setPlayerCatalogue(PlayerRoster playerCatalogue) {
		this.playerCatalogue = playerCatalogue;
	}
	
	public String getPlayerStats(Player player) {
		StringBuilder sb = new StringBuilder("");
		sb.append(player).append("\n\n\n");
		sb.append("Total:").append("\t").append(4).append("\n");
		sb.append("Won:").append("\t").append("75%").append("\n");
		sb.append("Lost:").append("\t").append("25%").append("\n");
		return sb.toString();			
	}
}
