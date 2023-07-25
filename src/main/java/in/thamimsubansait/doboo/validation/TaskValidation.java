package in.thamimsubansait.doboo.validation;

import in.thamimsubansait.doboo.exception.ValidationException;
import in.thamimsubansait.doboo.model.Task;
import in.thamimsubansait.doboo.util.StringUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;


public class TaskValidation {
	// We are checking if the task object is null and then we throw a exception.
	
	/**
	 * {@systemProperty} StringUtil,LocalDate,DateTimeFormatter
	 * @param task
	 * @throws ValidationException
	 * @return void
	 */
	public static void validate(Task task) throws ValidationException {
		
		if (task == null) {
			throw new ValidationException("Invalid task input");
		}
//		if(user.getEmail()==null || "".equals(user.getEmail().trim())) {
//			
//			throw new ValidationException("Email cannot be null or empty");
//			
//		}
		StringUtil.rejectIfInvalidString(task.getName(), "name");
		
		StringUtil.rejectIfInvalidString(task.getDuedate(), "duedate");
		
		String date = task.getDuedate();
		DateTimeFormatter formatDate =DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate formattedDate = LocalDate.parse(date,formatDate);
		
		LocalDate.parse(date,
                 DateTimeFormatter.ofPattern("dd.MM.uuuu").withResolverStyle(ResolverStyle.STRICT));
		
		LocalDate currentDay = LocalDate.now();
		
		if(currentDay.equals(date) || formattedDate.isBefore(currentDay)) {
			
			throw new ValidationException("Invalid Date or Invalid date Format");
		}
		 
		
		
		
		
	
//		
	}
}
