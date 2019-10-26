package com.vcarpool.services;

import java.util.List;

import com.vcarpool.dao.UserDao;
import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.User;

public class UserServiceImpl implements UserService {

	public static UserDao dao=  UserDao.getDao();
	public int insert(User u) throws VCarpoolException {
	
		return dao.insert(u);
	}

	
	public int update(User u, String feild, String value) throws VCarpoolException {
		
		return dao.update(u, feild, value);
	}

	
	public User delet(User u) throws VCarpoolException {
		
		return dao.delet(u);
	}
	
	public List<User> showUsers() throws VCarpoolException {
		return dao.showUsers();
	}
	
	public int login(int userId, String password) throws VCarpoolException {
		return dao.login(userId, password);
	}
	
	public User getUser(int userId) throws VCarpoolException {
		return dao.getUser(userId);
	}
	
	public int getUserEmail(String email) throws VCarpoolException {
		return dao.getUserEmail(email);
	}

}
