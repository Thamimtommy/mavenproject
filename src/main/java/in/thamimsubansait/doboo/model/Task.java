package in.thamimsubansait.doboo.model;

public class Task {
	int id;
	String name;
	String duedate;
	boolean isActive;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", duedate=" + duedate + ", isActive=" + isActive + "]";
	}
	
	

}
