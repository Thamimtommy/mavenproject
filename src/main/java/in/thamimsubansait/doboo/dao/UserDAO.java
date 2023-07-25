package in.thamimsubansait.doboo.dao;

import in.thamimsubansait.doboo.Interface.UserInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import in.thamimsubansait.doboo.model.User;
import in.thamimsubansait.doboo.model.UserEntity;
import in.thamimsubansait.doboo.util.ConnectionUtil;

public class UserDAO implements UserInterface {

	public Set<User> findAll() throws RuntimeException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<User> setOfUser = new HashSet<>();

		try {
			String query = "SELECT * FROM users WHERE is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setActive(rs.getBoolean("is_active"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

				setOfUser.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return setOfUser;
//		Set<User> userList = UserList.listOfUser;

//		return userList;

	}

	/**
	 * 
	 * @param newUser
	 */

	public void create(User newUser) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			String query = "INSERT INTO users(first_name,last_name,password,email)Values (?,?,?,?)";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1,newUser.getFirstName());
			ps.setString(2,newUser.getLastName());
			ps.setString(3,newUser.getPassword());
			ps.setString(4,newUser.getEmail());
			
		   ps.executeUpdate();
			System.out.println("User is successfully created");
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		finally {
			ConnectionUtil.close(con, ps, rs);
		}
		

	}

	public void update(int id, User updatedUser) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			String query = "UPDATE users set first_name = ?,last_name = ? WHERE is_active = 1 AND id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1,updatedUser.getFirstName());
			ps.setString(2,updatedUser.getLastName());
			ps.setInt(3,id);
			
		   ps.executeUpdate();
			System.out.println("User details is successfully updated");
			
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		finally {
			ConnectionUtil.close(con, ps, rs);
		}
		
		}
	

	public void delete(int id) {
		Set<User> userList = UserList.listOfUser;
		for (User ListOfusers : userList) {
			User user1 = ListOfusers;

			if (user1 == null) {
				continue;
			}

			if (user1.getId() == id) {
				user1.setActive(false);
			}
		}
	}

	public User findById(int id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			String query = "SELECT * FROM users WHERE is_active = 1  AND id = ? ";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setActive(rs.getBoolean("is_active"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException();
		}
		finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return user;
		
	}

	public User findByEmailId(String email) {
		Set<User> userList = UserList.listOfUser;
		for (User user : userList) {
			if (user != null && user.getEmail() == email) {
				return user;
			}
		}
		return null;
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
