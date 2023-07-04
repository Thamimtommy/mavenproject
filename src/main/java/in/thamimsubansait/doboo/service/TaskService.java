package in.thamimsubansait.doboo.service;

import in.thamimsubansait.doboo.dao.TaskDAO;
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
		TaskValidation.validate(newTask);
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
