package in.thamimsubansait.doboo.validation;

import in.thamimsubansait.doboo.exception.ValidationException;
import in.thamimsubansait.doboo.model.Task;
import in.thamimsubansait.doboo.util.StringUtil;

public class TaskValidation {
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
//		StringUtil.rejectIfInvalidString(task.getDuedate(), "duedate");
		
	
//		
	}
}
