package in.thamimsubansait.doboo.validation;
import in.thamimsubansait.doboo.exception.ValidationException;
import in.thamimsubansait.doboo.model.User;
import in.thamimsubansait.doboo.util.StringUtil;
public class UserValidator {
	public static void validate(User user) throws ValidationException {
		if (user == null) {
			throw new ValidationException("Invalid user input");
		}
//		if(user.getEmail()==null || "".equals(user.getEmail().trim())) {
//			
//			throw new ValidationException("Email cannot be null or empty");
//			
//		}
		StringUtil.rejectIfInvalidString(user.getEmail(), "Email");
		StringUtil.rejectIfInvalidString(user.getPassword(), "Password");
		
		StringUtil.rejectIfInvalidString(user.getFirstName(), "FirstName");
//		
	}
}
