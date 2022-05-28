package model;

import control.GameController;


public class GameModel {
	PlayerRoster  playerCatalogue;
	Player [] gamePlayers;
	String[][] gameBoard;
	GameController gc;
	Boolean mover;
	Board board;
	
	
	public Board getBoard() {
		return board;
	}


	public void setBoard(Board board) {
		this.board = board;
	}


	public GameModel(GameController gc) {
		this.gc=gc;
		board = new Board();
		gamePlayers = new Player[2];
		gameBoard= new String[3][3];
		playerCatalogue= new PlayerRoster();
		mover=false;
	}
	
	public void checkIfBean() {
			char c [][] = new char[3][3];
			for (int i = 0 ; i < 3 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if (gameBoard[i][j] != null)
						c[i][j] = gameBoard[i][j].charAt(0);
				}
			}
			
			gc.getModel().getBoard().beanMove(c, 'X');
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
	
	public int makeMove(int row, int col) {
		checkMoveValidity(row, col);
		gameBoard[row][col]=getMoverMark();
		mover=!mover;	
		char b [][] = new char [3][3];
		for (int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				if (gameBoard[i][j] != null)
					b[i][j] = gameBoard[i][j].charAt(0);
			}
		}
		@SuppressWarnings("static-access")
		int res = board.checkWinner(b);
		//System.out.println("result : "+res);
		if (res == 0) {
			//elexos an exun simplirothi oles oi thesis t pinaka -> res = -1
			boolean flag = false;
			for (int i = 0 ; i < 3 ; i++) {
				for(int j = 0 ; j < 3 ; j++) {
					if (gameBoard[i][j] == null)
						flag = true;
				}
			}
			if (!flag) {
				res =  -1;
			}
			
		}
		return(res);
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
		if(player.getHistory() == null) {
			StringBuilder sb = new StringBuilder("");
			sb.append(player.getPlName()).append("\n\n\n");
			sb.append("Total:").append("\t").append("no games").append("\n");
			sb.append("Won:").append("\t").append("no wins").append("\n");
			sb.append("Lost:").append("\t").append("no loses").append("\n");
			return sb.toString();		
		}
			else {
			StringBuilder sb = new StringBuilder("");
			sb.append(player.getPlName()).append("\n\n\n");
			sb.append("Total:").append("\t").append(player.getHistory().PlGames).append("\n");
			sb.append("Won:").append("\t").append(player.getHistory().PlWins).append("\n");
			sb.append("Lost:").append("\t").append(player.getHistory().PlLoses).append("\n");
			return sb.toString();			
		}
	}	
}
