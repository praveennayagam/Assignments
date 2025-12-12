package com.mphasis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.mphasis.dao.UserDao;
import com.mphasis.model.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;

	private static List<User> userList=new ArrayList<User>();
	
	
	public boolean doAuthenticate(String role,String uname, String pwd) {
		userList= dao.findAll();
		for(User u:userList) {
			if(u.getRole().equalsIgnoreCase(role) && u.getUname().equalsIgnoreCase(uname) && u.getPwd().equals(pwd))
				return true;
		
		}
		
		return false;
		
	}
	
	public User userDetails(Long uid)
	{
		userList= dao.findAll();
		for(User u:userList) {
		if(u.getUid()==(uid))
			return u;
		}
		return null;
	}

	 @Transactional
	public User addUser(User user) {
		
		dao.save(user);
		return user;
	}

	public List<User> getUserList()
	{
		return dao.findAll();
	}

}
