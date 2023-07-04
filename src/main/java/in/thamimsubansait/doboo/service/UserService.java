package in.thamimsubansait.doboo.service;

import in.thamimsubansait.doboo.dao.UserDAO;

import in.thamimsubansait.doboo.model.User;
import in.thamimsubansait.doboo.validation.UserValidator;

public class UserService {

	public User[] getAll() {

		UserDAO userDAO = new UserDAO();

		User[] userList = userDAO.findAll();

		for (int i = 0; i < userList.length; i++) {
			System.out.println(userList[i]);
		}

		return userList;

	}

	public void create(User newUser) throws Exception {
		UserValidator.validate(newUser);
		UserDAO userDAO = new UserDAO();
		userDAO.create(newUser);
	}

	
	
	public void update(int id, User updateUser) {
		
		UserDAO userDAO = new UserDAO();
		userDAO.update(id,updateUser);
	}
	
	public void delete(int id) {
		UserDAO userDAO = new UserDAO();
		userDAO.delete(id);
	}

}
