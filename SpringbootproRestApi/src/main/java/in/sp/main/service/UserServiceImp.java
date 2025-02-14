package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Repositry.UserRepositry;
import in.sp.main.entitiye.User;
@Service
public class UserServiceImp implements UserService {
     @Autowired
	private UserRepositry userRepositry;
	
	@Override
	public User createuser(User user) {
		
		
		 
		return userRepositry.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepositry.findAll();
	}

	@Override
	public Optional<User> getuserDetails(int id) {
		
		return userRepositry.findById(id);
	}

	@Override
	public User UpdateUserDetails(int id, User newuser) {
		
		User userDate=userRepositry.findById(id).orElse(newuser);
		
		if(userDate!=null) {
			return userRepositry.save(newuser);
		}
		else {
		throw new RuntimeException("User not Found with id"+id);
	}
	}

	@Override
	public void DeleteUserDetails(int id) {
		
		userRepositry.deleteById(id);
	}

}
