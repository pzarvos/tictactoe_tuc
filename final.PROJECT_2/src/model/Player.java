package model;

public class Player {
	private String PlName;
	private PlHistory history;
	private PlayerRoster plRoster;
	
	 
	
	public Player(String name,PlHistory history) {
		this.PlName = name;
		this.history = history;
		/*this.history.PlDraws = draws;
		this.history.PlGames = games;
		this.history.PlLoses = loses;
		this.history.PlWins = wins;*/
	}
	 public void findPlayerNames() {
		 
	 }
	 //GETTERS_SETTERS
	 public void setPlRoster(PlayerRoster plRoster) {
			this.plRoster = plRoster;
		}
	public String getPlName() {
		return PlName;
	}
	public void setPlName(String plName) {
		PlName = plName;
	}
	public PlHistory getHistory() {
		return history;
	}
	public void setHistory(PlHistory history) {
		this.history = history;
	}
	public PlayerRoster getPlRoster() {
		return plRoster;
	}
}