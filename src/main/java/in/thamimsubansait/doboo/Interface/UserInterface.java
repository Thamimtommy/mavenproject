package in.thamimsubansait.doboo.Interface;

import in.thamimsubansait.doboo.model.User;

public interface UserInterface extends Base<User> {
	
	public abstract User findByEmailId(String email);
	
//	public abstract UserEntity findByNumber(Integer number);

	public abstract int count();
}
