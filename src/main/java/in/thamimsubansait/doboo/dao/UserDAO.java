package in.thamimsubansait.doboo.dao;

import in.thamimsubansait.doboo.model.User;

public class UserDAO {

	public User[] findAll() {
		User[] userList = UserList.listOfUser;
		return userList;
	}
	
	/**
	 * 
	 * @param newUser
	 */

	public void create(User newUser) {
		User[] userList = UserList.listOfUser;

		for (int i = 0; i < userList.length; i++) {

			User user = userList[i];

			if (user == null) {
				userList[i] = newUser;
				break;
			}

		}

	}
	
	public void update(int id, User updatedUser) {
		User[] userList = UserList.listOfUser;
		for(int i=0;i<userList.length;i++) {
			User user1 = userList[i];
			
			if(user1 == null) {
				continue;
			}
			
			if(user1.getId() == id) {
				userList[i].setFirstName(updatedUser.getFirstName());
				userList[i].setLastName(updatedUser.getLastName());
				userList[i].setPassword(updatedUser.getPassword());
			}
		}
	}
	
	public void delete(int id) {
		User[] userList = UserList.listOfUser;
		for(int i=0;i<userList.length;i++) {
			User user1 = userList[i];
			
			if(user1 == null) {
				continue;
			}
			
			if(user1.getId() == id) {
				user1.setActive(false);
			}
		}
	}
	
	public User findById(int id) {
		
		User[] userList = UserList.listOfUser;
		User userMacth = null;
		
		for(int i=0;i<userList.length;i++) {
			User user1 = userList[i];
			
			if(user1 == null) {
				continue;
			}
			
			if(user1.getId() == id) {
				userMacth = user1;
				break;
			}
		}
		
		return userMacth;
		
	}
	
}
