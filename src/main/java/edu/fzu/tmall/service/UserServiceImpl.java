package edu.fzu.tmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import edu.fzu.tmall.dao.UserDAO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Override
	public List listUser() {
		// TODO Auto-generated method stub
		return userDAO.list();
	}
	
	/*
	 * public void setUserDAO(UserDAO userDAO) { this.userDAO = userDAO; }
	 */
}
