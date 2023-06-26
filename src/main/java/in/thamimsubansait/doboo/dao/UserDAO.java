package in.thamimsubansait.doboo.dao;

import in.thamimsubansait.doboo.model.User;

public class UserDAO {
	
		public User[] findAll() {
			User[] userList = UserList.listOfUser;
			return userList;
		}
		
		public void create(User newUser) {
//			
			
			UserList.listOfUser[0] = newUser;
			
		};
}
		
		
