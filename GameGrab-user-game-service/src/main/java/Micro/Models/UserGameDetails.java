package Micro.Models;

public class UserGameDetails {
	
	private String gameName;
	private String gameDescription;
	private int hoursPlayed;
	
	public UserGameDetails() {}
	
	public UserGameDetails(String name, String desc, int hours) {
		this.gameName = name;
		this.gameDescription = desc;
		this.hoursPlayed = hours;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameDescription() {
		return gameDescription;
	}

	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}

	public int getHoursPlayed() {
		return hoursPlayed;
	}

	public void setHoursPlayed(int hoursPlayed) {
		this.hoursPlayed = hoursPlayed;
	}
	
	

}
