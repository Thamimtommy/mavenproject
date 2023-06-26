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
	
	
	
}
