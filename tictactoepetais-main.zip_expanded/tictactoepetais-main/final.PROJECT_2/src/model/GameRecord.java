package model;

public class GameRecord {
	private Player[] listOfPlayers;
	private String result;
	private float score;
	private float time;
	
		GameRecord(Player list,String result,float score,float time){
			this.listOfPlayers = new Player[10];
			this.result = result;
			this.score = score;
			this.time = time;
		
	}
		
		//GETTERS_SETTERS
		public Player[] getListOfPlayers() {
			return listOfPlayers;
		}

		public void setListOfPlayers(Player[] listOfPlayers) {
			this.listOfPlayers = listOfPlayers;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		public float getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public float getTime() {
			return time;
		}

		public void setTime(float time) {
			this.time = time;
		}
}