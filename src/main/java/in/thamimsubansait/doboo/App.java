package in.thamimsubansait.doboo;

import in.thamimsubansait.doboo.model.User;
import in.thamimsubansait.doboo.model.Task;

import in.thamimsubansait.doboo.service.UserService;
import in.thamimsubansait.doboo.service.TaskService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService userService;
		try {
			userService = new UserService();

			User newUser = new User();
			newUser.setId(001);
			newUser.setFirstName("thamim");
			newUser.setLastName("tommy");
			newUser.setEmail("thamimtommy@gmail.com");
			newUser.setPassword("tommy@8973");
			newUser.setActive(true);

			userService.create(newUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TaskService taskService;
//		
		try {
			taskService = new TaskService();
			
			Task newTask = new Task();
			
			newTask.setName("Shopping");
			newTask.setDuedate("10/07/2023");
			newTask.setId(1);
			newTask.setActive(true);
			
			
			taskService.create(newTask);
			taskService.getAll();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		

//		User newUser2 = new User();
//		newUser2.setId(002);
//		newUser2.setFirstName("thamim");
//		newUser2.setLastName("tommy");
//		newUser2.setEmail("thamimtommy@gmail.com");
//		newUser2.setPassword("tommy@8973");
//		newUser2.setActive(true);
//
//		userService.create(newUser2);

		

//		User newUser3 = new User();
//		newUser3.setId(001);
//		newUser3.setFirstName("Surya");
//		newUser3.setLastName("Umapathy");
//		newUser3.setEmail("thamimtommy@gmail.com");
//		newUser3.setPassword("tommy@8973");
//		newUser3.setActive(true);
//
//		userService.update(001, newUser3);
//		
//		userService.delete(002);
//		
//		userService.getAll();
		
		

	}

}
