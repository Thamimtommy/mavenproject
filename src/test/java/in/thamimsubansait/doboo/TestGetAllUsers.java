package in.thamimsubansait.doboo;

//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import java.util.*;

import in.thamimsubansait.doboo.model.User;
import in.thamimsubansait.doboo.service.UserService;

public class TestGetAllUsers {
	
	@Test

	public void testGetAllUser() {

		UserService userService = new UserService();
		
		Set <User> UserList = userService.getAll();
		
		System.out.print(UserList);
		

//		assertDoesNotThrow(() -> {
//			userService.getAll(newUser);
//		});

	}
	
	@Test

	public void testFindById() {

		UserService userService = new UserService();
		
		User UserList = userService.findById(1);
		
		System.out.print(UserList);

	}
	@Test
	
	public void testUpdateUser() {

		UserService userService = new UserService();
        User newUser = new User();
		
		newUser.setFirstName("thamim");
		newUser.setLastName("alagu");
		newUser.setEmail("tommy@gmail.com");
		newUser.setPassword("alagu@1234");
		
		userService.update(6, newUser);
		

	}
	
	

}
