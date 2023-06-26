package in.thamimsubansait.doboo.dao;

import in.thamimsubansait.doboo.model.User;

public class UserDAO {
	
		public User[] findAll() {
			User[] userList = UserList.listOfUser;
			return userList;
		}
		
		public void create() {
			User newUser = new User();
			newUser.setId(001);
			newUser.setFirstName("thamim");
			newUser.setLastName("tommy");
			newUser.setEmail("thamimtommy@gmail.com");
			newUser.setPassword("tommy@8973");
			newUser.setActive(true);
			
			UserList.listOfUser[0] = newUser;
			
		};
}
		
		
