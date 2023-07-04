
package in.thamimsubansait.doboo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import in.thamimsubansait.doboo.exception.ValidationException;
import in.thamimsubansait.doboo.model.User;
import in.thamimsubansait.doboo.service.UserService;

public class TestCreateUser {

	@Test

	public void testCreateUserWithValidInput() {

		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(3);
		newUser.setFirstName("Uthra");
		newUser.setLastName("Boopathy");
		newUser.setEmail("uthra@gmail.com");
		newUser.setPassword("Uthra@12");
		newUser.setActive(true);

		assertDoesNotThrow(() -> {
			userService.create(newUser);
		});

	}

	@Test

	public void testCreateUserWithInvalidInput() throws Exception {

		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(null);
		});
		String exceptedMessage = "Invalid user input";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithEmailNull() throws Exception {

		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(3);
		newUser.setFirstName("Uthra");
		newUser.setLastName("Boopathy");
		newUser.setEmail(null);
		newUser.setPassword("Uthra@12");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		String exceptedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithEmailEmpty() throws Exception {

		UserService userService = new UserService();

		User newUser = new User();
		newUser.setId(3);
		newUser.setFirstName("Uthra");
		newUser.setLastName("Boopathy");
		newUser.setEmail("");
		newUser.setPassword("Uthra@12");
		newUser.setActive(true);

		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		String exceptedMessage = "Email cannot be null or empty";
		String actualMessage = exception.getMessage();

		assertTrue(exceptedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithPasswordNull() {
		UserService userService = new UserService();
		User newUser = new User();
		newUser.setId(1);
		newUser.setFirstName("Uthra");
		newUser.setLastName("Boopathy");
		newUser.setEmail("uthra@gmail.com");
		newUser.setPassword(null);
		newUser.setActive(true);
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		String expectedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithPasswordEmpty() {
		UserService userService = new UserService();
		User newUser = new User();
		newUser.setId(1);
		newUser.setFirstName("Uthra");
		newUser.setLastName("Boopathy");
		newUser.setEmail("uthra@gmail.com");
		newUser.setPassword("");
		newUser.setActive(true);
		Exception exception = assertThrows(Exception.class, () -> {
			userService.create(newUser);
		});
		String expectedMessage = "Password cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithFirstNameNull() {
		UserService userService = new UserService();
		User newUser = new User();
		newUser.setId(1);
		newUser.setFirstName(null);
		newUser.setLastName("Boopathyt");
		newUser.setEmail("uthra@gmail.com");
		newUser.setPassword("Uthra4849");
		newUser.setActive(true);
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		String expectedMessage = "FirstName cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test

	public void testCreateUserWithFirstNameEmpty() {
		UserService userService = new UserService();
		User newUser = new User();
		newUser.setId(1);
		newUser.setFirstName("");
		newUser.setLastName("Boopathy");
		newUser.setEmail("uthra@gmail.com");
		newUser.setPassword("Uthra4849");
		newUser.setActive(true);
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(newUser);
		});
		String expectedMessage = "FirstName cannot be null or empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
}
