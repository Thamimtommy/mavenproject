
package in.thamimsubansait.doboo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import in.thamimsubansait.doboo.exception.ValidationException;
import in.thamimsubansait.doboo.model.Task;

import in.thamimsubansait.doboo.service.TaskService;



public class TestCreateTask {

	@Test

	public void testCreateTaskWithValidInput() {

		TaskService taskService = new TaskService();

		Task newTask = new Task();
		newTask.setId(1);
		newTask.setDuedate("19.07.2023");
		newTask.setName("To do");
		newTask.setActive(true);

		assertDoesNotThrow(() -> {
			taskService.create(newTask);
		});

	}

	@Test

	public void testCreateTaskWithInvalidInput() throws Exception {

		TaskService taskService = new TaskService();
		
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(null);
		});
		String exceptedMessage = "Invalid task input";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}
	
	@Test

	public void testCreateTaskNameWithNull() {
		TaskService taskService = new TaskService();
		
		Task newTask = new Task();
		
		newTask.setId(1);
		newTask.setDuedate("19.07.2023");
		newTask.setName(null);
		newTask.setActive(true);
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});
		String expectedMessage = "name cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateTaskNameWithEmpty() {
		TaskService taskService = new TaskService();
		
		Task newTask = new Task();
		newTask.setId(1);
		newTask.setDuedate("19.07.2023");
		newTask.setName("");
		newTask.setActive(true);
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});
		String expectedMessage = "name cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@Test

	public void testCreateTaskWithTaskDueDateNull() {
		TaskService taskService = new TaskService();
		Task newTask = new Task();
		newTask.setId(1);
		newTask.setName("RC");
		newTask.setDuedate(null);
		newTask.setActive(true);
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});
		String expectedMessage = "duedate cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	/// TEST FOR TASK DUE DATE WITH EMPTY
	
@Test

	public void testCreateTaskWithTaskDueDateEmpty() {
		TaskService taskService = new TaskService();
		Task newTask = new Task();
		newTask.setId(1);
		newTask.setName("RC");
		newTask.setDuedate("");
		newTask.setActive(true);
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});
		String expectedMessage = "duedate cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	/// TEST FOR TASK DUE DATE FORMAT
	
	
@Test

	public void testCreateTaskWithTaskDueDateFormat() {
		TaskService taskService = new TaskService();
		Task newTask = new Task();
		newTask.setId(1);
		newTask.setName("RC");
		newTask.setDuedate("1.1.02");
		newTask.setActive(true);
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});
		String expectedMessage = "Invalid Date or Invalid date Format";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	/// TEST FOR TASK DUE DATE IS PAST OR NOT
	
	
@Test

	public void testCreateTaskWithTaskDueDateIsPast() {
		TaskService taskService = new TaskService();
		Task newTask = new Task();
		newTask.setId(1);
		newTask.setName("RC");
		newTask.setDuedate("10.01.2002");
		newTask.setActive(true);
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(newTask);
		});
		String expectedMessage = "Invalid Date or Invalid date Format";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	/// TEST FOR TASK DUE DATE IS INValid
	
		
@Test

		public void testCreateTaskWithTaskDueDateInValid() {
			TaskService taskService = new TaskService();
			Task newTask = new Task();
			newTask.setId(1);
			newTask.setName("RC");
			newTask.setDuedate("1.10.2024");
			newTask.setActive(true);
			Exception exception = assertThrows(ValidationException.class, () -> {
				taskService.create(newTask);
			});
			String expectedMessage = "Invalid Date or Invalid date Format";
			String actualMessage = exception.getMessage();
			assertTrue(expectedMessage.equals(actualMessage));
		}
	
}
