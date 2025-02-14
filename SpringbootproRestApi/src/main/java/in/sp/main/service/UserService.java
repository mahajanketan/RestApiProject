package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import in.sp.main.entitiye.User;

public interface UserService {
	
	
	public User createuser(User user);
    public List<User> getAllUser();
    public Optional<User>getuserDetails(int id);
    public User UpdateUserDetails(int id, User user);
    public void DeleteUserDetails(int id);
}
