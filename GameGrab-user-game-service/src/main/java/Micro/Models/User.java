package Micro.Models;

import java.util.Arrays;
import java.util.List;

public class User {
	
	private String userName;
	private List<String> games;
	
	public User() {}
	
	public User(String userName,List<String> games) {
		this.userName = userName;
		this.games = games;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getGames() {
		return games;
	}

	public void setGames(List<String> games) {
		this.games = games;
	}
	
	public static List<User> storage(){
		return Arrays.asList(
				new User("Jimmy", Arrays.asList("CommandConqurer","BattleField")),
				new User("Tom" , Arrays.asList("CallofDuty", "SupremeCommander"))
				);
	}

}
