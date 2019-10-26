package com.vcarpool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vcarpool.connection.ConnectionUtil;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.User;
import com.vcarpool.services.UserService;

public class UserDao  implements UserService{

	
	static Logger log = Logger.getLogger(UserDao.class.getName());
	public static UserDao dao=null;

	private UserDao() {
	
	}
	
	
	public static UserDao getDao() {
		if(dao==null) {
			dao= new UserDao();
		}
		return dao;
	}
	
	
	@Override
	public int insert(User user) throws VCarpoolException {

		log.info("---------inserting user details  into table-------------------");		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int key = 0;
		String query = "insert into user(userName, password, type, email) values(?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getType());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next())
				key = resultSet.getInt(1);
		} catch (SQLException e) {
			log.error("error-dao", e);
			throw new VCarpoolException("exception-dao");
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
		}

		return key;

	}

	@Override
	public int update(User u, String feild, String value) throws VCarpoolException {

		log.info("---------Updating user details in  table-------------------");		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int key = 0;
		String query = "update user set " + feild + "=? where userId= ?";

		System.out.println(query);
		try {
			preparedStatement = con.prepareStatement(query);

			preparedStatement.setString(1, value);
			preparedStatement.setInt(2, u.getUserId());
			key = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			log.error("update error- dao", e);
			throw new VCarpoolException("error-dao-update");
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
		}

		return key;
	}

	@Override
	public User delet(User user) throws VCarpoolException {
		User temp = user;
		log.info("---------Deleting User from table-------------------");		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		int key = 0;
		String query = "delete from user where userId=?";
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, user.getUserId());
			key = preparedStatement.executeUpdate();
			if (key > 0)
				return temp;
			else
				return null;
		} catch (SQLException e) {
			log.error("deletion error- dao", e);
			throw new VCarpoolException("error in deleting data");
		} finally {

			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
		}

	}

	@Override
	public List<User> showUsers() throws VCarpoolException {
		ArrayList<User> arr = new ArrayList<User>();
		ResultSet resultSet = null;
		Connection con = ConnectionUtil.getConnection();
		Statement statement = null;
		String query = "select * from user";
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			if (resultSet == null)
				return null;
			else {
				User user = null;
				while (resultSet.next()) {
					user = new User();
					user.setUserId(resultSet.getInt("userId"));
					user.setUserName(resultSet.getString("userName"));
					user.setPassword(resultSet.getString("password"));
					user.setType(resultSet.getString("type"));
					arr.add(user);
					user = null;
				}
			}
		} catch (SQLException e) {
			log.error("selection error- dao", e);
			throw new VCarpoolException("error in selecting data");
		}

		return arr;
	}

	@Override
	public int login(int userId, String password) throws VCarpoolException {

		Connection con = ConnectionUtil.getConnection();
		String query = "select * from user";
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = getUser(userId);

		try {
			statement = con.createStatement();
			preparedStatement = con.prepareStatement("select * from user", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.execute();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				if (resultSet.getString("password").equals(password) && (resultSet.getInt("userId") == user.getUserId()
						|| resultSet.getString("userName").equals(user.getUserName())))

					return 1;
			}

		} catch (SQLException e) {
			log.error("login- dao", e);
			throw new VCarpoolException("login- error");
		}

		finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
		}
		return 0;

	}

	@Override
	public User getUser(int userId) throws VCarpoolException {

		Connection con = ConnectionUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery("select * from user where userId=" + userId);
			if (resultSet.next()) {
				user = new User();
				user.setUserId(resultSet.getInt("userId"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				user.setType(resultSet.getString("type"));
				user.setEmail(resultSet.getString("email"));
			}

		} catch (SQLException e) {
			log.error("get -eeror", e);
			throw new VCarpoolException("error-getting user");
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					throw new VCarpoolException();
				}
		}

		return user;
	}

	@Override
	public int getUserEmail(String email) throws VCarpoolException {
		Connection con = ConnectionUtil.getConnection();
		String query = "select email from user where email=?";
		PreparedStatement  preparedStatement=null;
		ResultSet resultSet=null;
		int result=0;
		
		try {
			preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1, email);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
				result=1;
		} catch (SQLException e) {
			log.error(e.getMessage(),e);
			throw new VCarpoolException(e.getMessage());
		}
		return result;
	}

}
