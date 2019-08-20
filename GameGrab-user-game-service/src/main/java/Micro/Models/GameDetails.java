package Micro.Models;

public class GameDetails {
	
	private String gameName;
	private String description;
//	add like a game type
	
	public GameDetails() {}
	
	public GameDetails(String name, String description) {
		this.gameName = name;
		this.description = description;
	}

	public String getName() {
		return gameName;
	}

	public void setName(String name) {
		this.gameName = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
