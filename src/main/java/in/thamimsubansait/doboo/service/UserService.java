package in.thamimsubansait.doboo.service;

import in.thamimsubansait.doboo.dao.UserDAO;
import java.util.*;

import in.thamimsubansait.doboo.model.User;
import in.thamimsubansait.doboo.validation.UserValidator;

public class UserService {
	
	private UserDAO userDao;

	public UserService() {
		this.userDao = new UserDAO(); // Initialize userDao instance in the constructor
	}

	public Set<User> getAll() {

		Set<User> userList = userDao.findAll();
//		for (User user : userList) {
//			System.out.println(user);
//		}
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
	
	public User findById(int id) {
		UserDAO userDao = new UserDAO();
		return userDao.findById(id);
	}

}
