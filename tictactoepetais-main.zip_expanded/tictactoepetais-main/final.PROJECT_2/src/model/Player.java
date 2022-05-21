package model;

public class Player {
	private String PlName;
	private PlHistory history;
	private PlayerRoster plRoster;
	
	 public PlayerRoster getPlRoster() {
		return plRoster;
	}
	
	public Player(String name, PlHistory history) {
		this.PlName = name;
		this.history = history;
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
}