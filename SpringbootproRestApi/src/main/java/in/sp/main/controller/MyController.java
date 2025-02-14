package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.Repositry.UserRepositry;
import in.sp.main.entitiye.User;
import in.sp.main.service.UserService;

@RestController 
public class MyController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user") 
	public User adduserDetials(@RequestBody User user) {
	
         
		return userService.createuser(user);
}
	@GetMapping("/user")
	public List<User> getAllUser(){
		
	return userService.getAllUser();
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getuserDetails(@PathVariable int id) {
		
		
		User user=userService.getuserDetails(id).orElse(null);
		if(user!=null) {
			
			return ResponseEntity.ok().body(user);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
		
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User>UpdateUserDetails(@PathVariable int id, @RequestBody User user){
		
		User Updateuser=userService.UpdateUserDetails(id, user);
	
	if(Updateuser!=null) {
		return ResponseEntity.ok(Updateuser);
	}
	else {
		return ResponseEntity.notFound().build();
	}
	}
	@DeleteMapping("/user/{id}")
	public  ResponseEntity<User> DeleteUserDetails (@PathVariable int id)
	{
		userService.DeleteUserDetails(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
}