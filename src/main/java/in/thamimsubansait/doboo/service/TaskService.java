package in.thamimsubansait.doboo.service;

//import java.time.format.DateTimeParseException;

import in.thamimsubansait.doboo.dao.TaskDAO;
import in.thamimsubansait.doboo.exception.ValidationException;
import in.thamimsubansait.doboo.model.Task;
import in.thamimsubansait.doboo.validation.TaskValidation;

public class TaskService {

	public Task[] getAll() {

		TaskDAO taskDAO = new TaskDAO();

		Task[] taskList = taskDAO.findAll();

		for (int i = 0; i < taskList.length; i++) {
			System.out.println(taskList[i]);
		}

		return taskList;

	}

	public void create(Task newTask) throws Exception {
		
		try{
			
			TaskValidation.validate(newTask);
		}
		catch(ValidationException e) {
			throw new ValidationException(e.getMessage());
		}
		catch(Exception e) {
			throw new ValidationException("Invalid Date or Invalid date Format");
		}
		
		TaskDAO taskDAO = new TaskDAO();
		taskDAO.create(newTask);
	}

	public void update(int id, Task updateTask) {

		TaskDAO taskDAO = new TaskDAO();
		taskDAO.update(id, updateTask);
	}

	public void delete(int id) {
		TaskDAO taskDAO = new TaskDAO();
		taskDAO.delete(id);
	}
	
	public Task findById(int id) {
		TaskDAO taskDao = new TaskDAO();
		Task task = taskDao.findById(id);
		return task;
	}

}
