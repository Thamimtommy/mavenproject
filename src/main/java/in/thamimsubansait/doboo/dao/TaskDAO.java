package in.thamimsubansait.doboo.dao;

import in.thamimsubansait.doboo.model.Task;


public class TaskDAO {

	public Task[] findAll() {
		Task[] taskList = TaskList.listOfTask;
		return taskList;
	}

	public void create(Task newTask) {
		Task[] taskList = TaskList.listOfTask;

		for (int i = 0; i < taskList.length; i++) {

			Task task = taskList[i];

			if (task == null) {
				taskList[i] = newTask;
				break;
			}

		}

	}

	public void update(int id, Task updatedTask) {
		Task[] taskList = TaskList.listOfTask;
		for (int i = 0; i < taskList.length; i++) {
			Task task1 = taskList[i];

			if (task1 == null) {
				continue;
			}

			if (task1.getId() == id) {
				task1.setName(updatedTask.getName());
				task1.setDuedate(updatedTask.getDuedate());
			}
		}

	}
	
	public void delete(int id) {
		Task[] taskList = TaskList.listOfTask;
		for(int i=0;i<taskList.length;i++) {
			Task task1 = taskList[i];
			
			if(task1 == null) {
				continue;
			}
			
			if(task1.getId() == id) {
				task1.setActive(false);
			}
		}
	}
	
public Task findById(int id) {
		
	Task[] taskList = TaskList.listOfTask;
		Task taskMacth = null;
		
		for(int i=0;i<taskList.length;i++) {
			Task task1 = taskList[i];
			
			if(task1 == null) {
				continue;
			}
			
			if(task1.getId() == id) {
				taskMacth = task1;
				break;
			}
		}
		
		return taskMacth;
		
	}
	
	

}
