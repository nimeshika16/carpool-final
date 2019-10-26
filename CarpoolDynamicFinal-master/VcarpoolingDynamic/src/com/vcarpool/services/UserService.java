package com.vcarpool.services;

import java.util.List;

import com.vcarpool.exception.VCarpoolException;
import com.vcarpool.model.User;

public interface UserService {

	public int insert(User u) throws VCarpoolException;

	public int update(User u, String feild, String value) throws VCarpoolException;

	public User delet(User u) throws VCarpoolException;
	
	public List<User> showUsers() throws VCarpoolException;
	
	public int login(int userId, String password) throws VCarpoolException;
	
	public User getUser(int userId) throws VCarpoolException;
	
	public int getUserEmail(String email) throws VCarpoolException;
	
}
