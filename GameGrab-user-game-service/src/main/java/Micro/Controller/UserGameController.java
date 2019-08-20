package Micro.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import Micro.Models.GameDetails;
import Micro.Models.User; 
import Micro.Models.UserGameDetails;
import Micro.Service.UserGameService;

@RestController
@RequestMapping(value = "api/users")
public class UserGameController {
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@Autowired
	private UserGameService userGameService;
	
//	@Autowired
//	WebClient.builder webClientBuilder;
	
	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public User getUserStuff(@PathVariable("userName") String userName) {
		for(int i = 0; i < userGameService.findAll().size(); i++) {
			if(userGameService.findAll().get(i).getUserName().equals(userName)) {
				return userGameService.findAll().get(i);
			}
		}
		
		
		User user = new User();
		user.setUserName(userName);
		return user;
	}
	
	
	
//	@RequestMapping(value = "/userDetails/{userName}", method = RequestMethod.GET)
//	public List<UserGameDetails> getUserGamesPlayed(@PathVariable("userName") String userName){
//		List<UserGameDetails> games = new ArrayList<>();
//		for(int i = 0; i < userGameService.findAll().size(); i++) {
//			if(userGameService.findAll().get(i).getUserName().equals(userName)) {
//				for(int y = 0; y < userGameService.findAll().get(i).getGames().size(); y++) {
//					
////				GameDetails gameDetails = restTemplate.getForObject("http://game-service/api/game/" + userGameService.findAll().get(i).getGames().get(y), GameDetails.class);
//				GameDetails gameDetails = restTemplate.getForObject("http://localhost:8081/api/game/" + userGameService.findAll().get(i).getGames().get(y), GameDetails.class);
//				games.add(new UserGameDetails(userGameService.findAll().get(i).getGames().get(y), gameDetails.getDescription(), 1));
//				}
//			}
//		}
//		return games;
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userGameService.findAll();
	}
	
	@RequestMapping(value = "/userDetails/{userName}", method = RequestMethod.GET)
	public List<UserGameDetails> getUserGamesPlayed(@PathVariable("userName") String userName){
		
		List<UserGameDetails> games = new ArrayList<>();
		List<User> allUsers = userGameService.findAll();
		
		for(int i = 0; i < allUsers.size(); i++) {
			
			User currentUser = allUsers.get(i);
			
			if(currentUser.getUserName().equals(userName)) {
				
				for(int y = 0; y < currentUser.getGames().size(); y++) {
					
					String currentGame = currentUser.getGames().get(y);
				
					GameDetails gameDetails = restTemplate.getForObject("http://localhost:8081/api/game/" + currentGame, GameDetails.class);
				
					games.add(new UserGameDetails(currentGame, gameDetails.getDescription(), 1));
				
				}
			}
		}
		return games;
	}

}
