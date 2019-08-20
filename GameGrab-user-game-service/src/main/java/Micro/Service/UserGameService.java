package Micro.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import Micro.Models.User;

@Service
public class UserGameService {

	public List<User> findAll(){
		return User.storage();
	}
	
	public User findByName(String Name) {
		for(int i = 0; i < User.storage().size(); i++) {
			if(Name.equals(User.storage().get(i).getUserName())) {
				return User.storage().get(i);
			}
		}
		return null;
	}
	
}
