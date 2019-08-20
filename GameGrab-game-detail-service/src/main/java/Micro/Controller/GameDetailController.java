package Micro.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Micro.Models.GameDetails;

@RestController
@RequestMapping(value = "api/game")
public class GameDetailController {
	
	
	@RequestMapping(value = "/{gameName}", method = RequestMethod.GET)
	public GameDetails getDetails(@PathVariable("gameName") String gameName) {
		GameDetails mockGame = new GameDetails(gameName, "TEST");
		if(gameName.equals("CallofDuty")) {
			mockGame.setDescription("A game for people with no lives");
		}
		return mockGame;
		
	}

}
