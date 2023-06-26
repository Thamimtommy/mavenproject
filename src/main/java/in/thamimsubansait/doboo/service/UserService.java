package in.thamimsubansait.doboo.service;

import in.thamimsubansait.doboo.dao.UserDAO;

import in.thamimsubansait.doboo.model.User;

public class UserService {
		
	public User[] getAll() {
		
			UserDAO userDAO = new UserDAO();
			
			User[] userList = userDAO.findAll();
			
			for (int i=0;i<userList.length;i++) {
				System.out.println(userList[i]);
			}
			
			return userList;
			
		}
	
	public void create(){
		
		User newUser = new User();
		newUser.setId(001);
		newUser.setFirstName("thamim");
		newUser.setLastName("tommy");
		newUser.setEmail("thamimtommy@gmail.com");
		newUser.setPassword("tommy@8973");
		newUser.setActive(true);
			
			UserDAO userDAO = new UserDAO();
			userDAO.create(newUser);
	 }
	
	
	
}
